package Collection;

import Collection.Exceptions.NoSuchTypeException;
import Collection.Exceptions.NullValueException;
import Collection.Exceptions.ValueOutOfRangeException;
import Tools.Tools;

import java.util.Date;
import java.util.Objects;

public class Organization implements Comparable<Organization> {
    public static Long idCode = 1L;

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле не может быть null
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле не может быть null

    public Organization() {
    }

    public static Organization Create() throws NullValueException, ValueOutOfRangeException {
        Organization organization = new Organization();

        Tools.Message("    Input name of Organization: ");
        String name = Tools.Input();
        if (name.equals("")) {
            name = null;
        }
        organization.setName(name);

        Coordinates coordinates = new Coordinates();
        Tools.Message("    Input coordinates x(x>-295): ");
        Float x;
        String sx = Tools.Input();
        if (sx.equals("")) {
            x = null;
        } else {
            x = Float.valueOf(sx);
        }
        coordinates.setX(x);

        Tools.Message("    Input coordinates y(y<=500): ");
        Double y;
        String sy = Tools.Input();
        if (sy.equals("")) {
            y = null;
        } else {
            y = Double.valueOf(sy);
        }
        coordinates.setY(y);
        organization.setCoordinates(coordinates);

        Tools.Message("    Input annualTurnover(annualTurnover>0): ");
        String sAT = Tools.Input();
        Long annualTurnover;
        if (sAT.equals("")) {
            annualTurnover = null;
        } else {
            annualTurnover = Long.valueOf(sAT);
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
        Long employeesCount;
        if (sEC.equals("")) {
            employeesCount = null;
        } else {
            employeesCount = Long.valueOf(sEC);
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

        organization.setId(idCode);
        idCode++;
        organization.setCreationDate(new Date());

        return organization;
    }

    public void setId(Long idCode) {
        this.id = idCode;
    }

    public void setName(String name) throws NullValueException{
        if (name == null) {
            throw new NullValueException("Error: Name can not be empty!\n");
        } else {
            this.name = name;
        }
    }

    public void setCoordinates(Coordinates coordinates) throws NullValueException {
        if (coordinates == null) {
            throw new NullValueException("Error: Coordinates can't be empty!\n");
        } else {
            this.coordinates = coordinates;
        }
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmployeesCount(Long employeesCount) throws NullValueException,ValueOutOfRangeException {
        if (employeesCount == null) {
            throw new NullValueException("Error: employeesCount can not be empty!\n");
        }
        else if (employeesCount <= 0) {
            throw new ValueOutOfRangeException("Error: Value out of Range! The range of employeesCount is >0\n");
        }
        this.employeesCount = employeesCount;
    }

    public void setType(OrganizationType type) throws NullValueException {
        if (type.equals(OrganizationType.NULL)) {
            throw new NullValueException("Error: Organization type can not be null!\n");
        } else {
            this.type = type;
        }
    }

    public void setPostalAddress(Address postalAddress) throws NullValueException {
        if (postalAddress == null) {
            throw new NullValueException("");
        } else {
            this.postalAddress = postalAddress;
        }
    }

    public Long getIdCode() {
        return idCode;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Long getAnnualTurnover() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

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
                + this.creationDate + "\n";
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
