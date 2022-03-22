package Collection;

import Collection.Exceptions.NullValueException;
import Collection.Exceptions.StringLengthOutOfRange;

public class Address {
    private String street; //Поле не может быть null
    private String zipCode; //Длина строки должна быть не меньше 8, Поле может быть null

    public Address(String street, String zipCode) {
        setStreet(street);
        setZipCode(zipCode);
    }

    public void setStreet(String street) throws NullValueException {
        if(street == null) {
            throw new NullValueException("Street can't be null");
        }
        else {
            this.street = street;
        }
    }

    public void setZipCode(String zipCode) {
        if(zipCode == null) {
            throw new NullValueException("zipcode shouldn't be null");
        }
        else if(zipCode.length() < 8) {
            throw new StringLengthOutOfRange("the length of zipcode shouldn't be smaller than 8");
        }
        else {
            this.zipCode = zipCode;
        }
    }

    public String toString() {
        return "Address: " + this.street + " street, zipcode: " + this.zipCode;
    }
}
