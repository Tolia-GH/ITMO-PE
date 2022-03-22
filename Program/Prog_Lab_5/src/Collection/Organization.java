package Collection;

import Collection.Exceptions.NullValueException;
import Collection.Exceptions.ValueOutOfRangeException;
import Tools.Tools;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.function.ToLongBiFunction;

public class Organization implements Comparable<Organization> {
    public static int idCode = 0;

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле не может быть null
    private Long employeesCount; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле не может быть null

    public Organization(String name, Coordinates coordinates, Long annualTurnover, String fullName, Long employeesCount, OrganizationType type, Address postalAddress) {
        setName(name);
        setCoordinates(coordinates);
        setAnnualTurnover(annualTurnover);
        setFullName(fullName);
        setEmployeesCount(employeesCount);
        setType(type);
        setPostalAddress(postalAddress);

        setId();
        setCreationDate(new Date());
    }

    public static Organization Create() throws NullValueException, ValueOutOfRangeException {

        Tools.Message("Input name of Organization:");
        String name = Tools.Input();

        Tools.Message("Input coordinates x(x>-295):");
        Float x = Float.valueOf(Tools.Input());

        Tools.Message("Input coordinates y(y<=500):");
        Double y = Double.valueOf(Tools.Input());

        Coordinates coordinates = new Coordinates(x,y);

        Tools.Message("Input annualTurnover");
        Long annualTurnover = Long.valueOf(Tools.Input());

        Tools.Message("Input full name");
        String fullName = Tools.Input();

        Tools.Message("Input employeesCount");
        Long employeesCount = Long.valueOf(Tools.Input());

        Tools.Message("Set organization type");
        OrganizationType type = OrganizationType.valueOf(Tools.Input());

        Tools.Message("Set postal address");
        String street = Tools.Input();
        String zipCode = Tools.Input();
        Address postalAddress = new Address(street, zipCode);

        return new Organization(name, coordinates, annualTurnover, fullName, employeesCount, type, postalAddress);
    }

    public void setId() {
        this.id = idCode;
        idCode++;
    }

    public void setName(String name) throws NullValueException{
        if(name == null) {
            throw new NullValueException("");
        } else {
            this.name = name;
        }
    }

    public void setCoordinates(Coordinates coordinates) throws NullValueException {
        if(coordinates == null) {
            throw new NullValueException("coordinates can't be null");
        } else {
            this.coordinates = coordinates;
        }
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setAnnualTurnover(Long annualTurnover) throws NullValueException,ValueOutOfRangeException{
        if(annualTurnover == null) {

        } else
        if(annualTurnover <= 0) {
            throw new ValueOutOfRangeException("annualTurnover should be bigger than 0");
        }
        else {
            this.annualTurnover = annualTurnover;
        }
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmployeesCount(Long employeesCount) throws NullValueException,ValueOutOfRangeException {
        if(employeesCount == null) {
            throw new NullValueException("");
        }
        else if(employeesCount < 0) {
            throw new ValueOutOfRangeException("");
        }
        this.employeesCount = employeesCount;
    }

    public void setType(OrganizationType type) throws NullValueException {
        if(type == null) {
            throw new NullValueException("");
        } else {
            this.type = type;
        }
    }

    public void setPostalAddress(Address postalAddress) throws NullValueException {
        if(postalAddress == null) {
            throw new NullValueException("");
        } else {
            this.postalAddress = postalAddress;
        }
    }

    public int getIdCode() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return id == that.id &&
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
        return 0;
    }
}
