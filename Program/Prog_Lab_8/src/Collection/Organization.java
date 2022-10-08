package Collection;

import Exceptions.NoSuchTypeException;
import Exceptions.NullValueException;
import Exceptions.ValueOutOfRangeException;
import Tools.Tools;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The type Organization.
 */
public class Organization implements Comparable<Organization>, Serializable {

    private String owner;
    //public static Long idCode = 1L;

    /**
     * The id of Organization.
     */
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * The Name of Organization.
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * The Coordinates of Organization.
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * The Creation date of Organization.
     */
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * The Annual turnover of Organization.
     */
    private Long annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    /**
     * The Full name of Organization.
     */
    private String fullName; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле не может быть null
    /**
     * The Employees count of Organization.
     */
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    /**
     * The Type of Organization.
     */
    private OrganizationType type; //Поле может быть null
    /**
     * The Postal address of Organization.
     */
    private Address postalAddress; //Поле не может быть null

    /**
     * Instantiates a new Organization of Organization.
     */
    public Organization() {
    }

    /**
     * Create organization.
     *
     * @return the organization
     * @throws NullValueException       the null value exception
     * @throws ValueOutOfRangeException the value out of range exception
     */
    public static Organization Create() throws NullValueException, ValueOutOfRangeException {

        Tools.MessageL("Program [add]: Please input parameters to create a organization");
        Organization organization = new Organization();

        Tools.Message("    Input name of Organization: ");
        String name = Tools.Input();
        if (name.equals("")) {
            name = null;
        }
        organization.setName(name);

        Coordinates coordinates = new Coordinates();
        Tools.Message("    Input coordinates x(x>-295): ");
        Float x = null;
        String sx = Tools.Input();
        if (!sx.equals("")) {
            try {
                x = Float.valueOf(sx);
            } catch (NumberFormatException e) {
                throw new ValueOutOfRangeException("Error: input numbers only!");
            }
        }
        coordinates.setX(x);

        Tools.Message("    Input coordinates y(y<=500): ");
        Double y = null;
        String sy = Tools.Input();
        if (!sy.equals("")) {
            try {
                y = Double.valueOf(sy);
            } catch (NumberFormatException e) {
                throw new ValueOutOfRangeException("Error: input numbers only!");
            }
        }
        coordinates.setY(y);
        organization.setCoordinates(coordinates);

        Tools.Message("    Input annualTurnover(annualTurnover>0): ");
        String sAT = Tools.Input();
        Long annualTurnover = null;
        if (!sAT.equals("")) {
            try {
                annualTurnover = Long.valueOf(sAT);
            } catch (NumberFormatException e) {
                throw new ValueOutOfRangeException("Error: input numbers only!");
            }
        }
        organization.setAnnualTurnover(annualTurnover);

        Tools.Message("    Input full name: ");
        String fullName = Tools.Input();
        if (fullName.equals("")) {
            fullName = null;
        }
        organization.setFullName(fullName);

        Tools.Message("    Input employeesCount(employeesCount>0): ");
        String sEC = Tools.Input();
        Long employeesCount = null;
        if (!sEC.equals("")) {
            try {
                employeesCount = Long.valueOf(sEC);
            } catch (NumberFormatException e) {
                throw new ValueOutOfRangeException("Error: input numbers only!");
            }
        }
        organization.setEmployeesCount(employeesCount);

        OrganizationType type;
        Tools.MessageL("    Set organization type from: ");
        Tools.MessageL(OrganizationType.list());
        Tools.Message("    Organization type = ");
        String typeInput = Tools.Input();
        if (typeInput.equals("")) {
            type = OrganizationType.NULL;
        } else {
            if (OrganizationType.findType(typeInput)) {
                type = OrganizationType.valueOf(typeInput);
            } else {
                throw new NoSuchTypeException("Type [" + typeInput + "] not found\n");
            }
        }
        organization.setType(type);

        Tools.Message("    Set the street of postal address: ");
        String street = Tools.Input();
        Tools.Message("    Set the zipCode of postal address(length bigger than 8): ");
        String zipCode = Tools.Input();
        Address postalAddress = new Address(street, zipCode);
        organization.setPostalAddress(postalAddress);

        organization.setCreationDate(new Date());

        return organization;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Sets id.
     *
     * @param idCode the id code
     */
    public void setId(Long idCode) {
        this.id = idCode;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @throws NullValueException the null value exception
     */
    public void setName(String name) throws NullValueException{
        if (name == null || name.equals("")) {
            throw new NullValueException("Error: Name can not be empty!\n");
        } else {
            this.name = name;
        }
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     * @throws NullValueException the null value exception
     */
    public void setCoordinates(Coordinates coordinates) throws NullValueException {
        if (coordinates == null) {
            throw new NullValueException("Error: Coordinates can't be empty!\n");
        } else {
            this.coordinates = coordinates;
        }
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets annual turnover.
     *
     * @param annualTurnover the annual turnover
     * @throws NullValueException       the null value exception
     * @throws ValueOutOfRangeException the value out of range exception
     */
    public void setAnnualTurnover(Long annualTurnover) throws NullValueException,ValueOutOfRangeException{
        if (annualTurnover == null) {
            throw new NullValueException("Error: AnnualTurnover can not be empty!\n");
        } else
        if (annualTurnover <= 0) {
            throw new ValueOutOfRangeException("Error: Value out of range! The range of is >0\n");
        }
        else {
            this.annualTurnover = annualTurnover;
        }
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        if (fullName == null || fullName.equals("")) {
            throw new NullValueException("Error: Full name nan not be empty!\n");
        } else {
            this.fullName = fullName;
        }
    }

    /**
     * Sets employees count.
     *
     * @param employeesCount the employees count
     * @throws NullValueException       the null value exception
     * @throws ValueOutOfRangeException the value out of range exception
     */
    public void setEmployeesCount(Long employeesCount) throws NullValueException,ValueOutOfRangeException {
        if (employeesCount == null) {
            throw new NullValueException("Error: employeesCount can not be empty!\n");
        }
        else if (employeesCount <= 0) {
            throw new ValueOutOfRangeException("Error: Value out of Range! The range of employeesCount is >0\n");
        }
        this.employeesCount = employeesCount;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @throws NullValueException the null value exception
     */
    public void setType(OrganizationType type) throws NullValueException {
        if (type.equals(OrganizationType.NULL)) {
            throw new NullValueException("Error: Organization type can not be null!\n");
        } else {
            this.type = type;
        }
    }

    /**
     * Sets postal address.
     *
     * @param postalAddress the postal address
     * @throws NullValueException the null value exception
     */
    public void setPostalAddress(Address postalAddress) throws NullValueException {
        if (postalAddress == null) {
            throw new NullValueException("Error: PostalAddress can not be null");
        } else {
            this.postalAddress = postalAddress;
        }
    }

    public String getOwner() {
        return owner;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Gets annual turnover.
     *
     * @return the annual turnover
     */
    public Long getAnnualTurnover() {
        return annualTurnover;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Gets employees count.
     *
     * @return the employees count
     */
    public Long getEmployeesCount() {
        return employeesCount;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public OrganizationType getType() {
        return type;
    }

    /**
     * Gets postal address.
     *
     * @return the postal address
     */
    public Address getPostalAddress() {
        return postalAddress;
    }

    public String toString() {
        return this.id + ","
                + this.name + ","
                + this.getType() + ","
                + this.coordinates.toString() + ","
                + this.annualTurnover + ","
                + this.employeesCount + ","
                + this.fullName + ","
                + this.postalAddress + ","
                + this.creationDate;
    }
    public ObservableOrganization toObservableOrganization() {
        ObservableOrganization observableOrganization = new ObservableOrganization();

        observableOrganization.setOwner(this.owner);
        observableOrganization.setId(this.id);
        observableOrganization.setName(this.name);
        observableOrganization.setCreationDate(this.creationDate.toString());
        observableOrganization.setX(this.coordinates.getX());
        observableOrganization.setY(this.coordinates.getY());
        observableOrganization.setAnnualTurnover(this.annualTurnover);
        observableOrganization.setFullName(this.fullName);
        observableOrganization.setEmployeesCount(this.employeesCount);
        observableOrganization.setType(this.type.toString());
        observableOrganization.setStreet(this.postalAddress.getStreet());
        observableOrganization.setZipCode(this.postalAddress.getZipCode());

        return observableOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(coordinates, that.coordinates) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(annualTurnover, that.annualTurnover) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(employeesCount, that.employeesCount) &&
                type == that.type && Objects.equals(postalAddress, that.postalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, postalAddress);
    }

    @Override
    public int compareTo(Organization o) {
        if (o == null) {
            throw new NullPointerException("Error: Null can't be compare!\n");
        }
        else if (this.equals(o)) {
            return 0;
        }
        else if (this.hashCode() > o.hashCode()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
