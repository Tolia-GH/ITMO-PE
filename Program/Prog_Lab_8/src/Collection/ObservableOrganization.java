package Collection;

import javafx.beans.property.*;

public class ObservableOrganization {
    private StringProperty owner;
    private LongProperty id;
    private StringProperty name;
    private FloatProperty x;
    private DoubleProperty y;
    private StringProperty creationDate;
    private LongProperty annualTurnover;
    private StringProperty fullName;
    private LongProperty employeesCount;
    private StringProperty Type;
    private StringProperty Street;
    private StringProperty zipCode;

    public void setOwner(String owner) {
        this.owner = new SimpleStringProperty(owner);
    }

    public void setId(long id) {
        this.id = new SimpleLongProperty(id);
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setX(float x) {
        this.x = new SimpleFloatProperty(x);
    }

    public void setY(double y) {
        this.y = new SimpleDoubleProperty(y);
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = new SimpleStringProperty(creationDate);
    }

    public void setAnnualTurnover(long annualTurnover) {
        this.annualTurnover = new SimpleLongProperty(annualTurnover);
    }

    public void setFullName(String fullName) {
        this.fullName = new SimpleStringProperty(fullName);
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = new SimpleLongProperty(employeesCount);
    }

    public void setType(String type) {
        this.Type = new SimpleStringProperty(type);
    }

    public void setStreet(String street) {
        this.Street = new SimpleStringProperty(street);
    }

    public void setZipCode(String zipCode) {
        this.zipCode = new SimpleStringProperty(zipCode);
    }
}
