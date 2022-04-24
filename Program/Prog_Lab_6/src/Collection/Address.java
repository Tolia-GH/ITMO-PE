package Collection;

import Collection.Exceptions.NullValueException;
import Collection.Exceptions.StringLengthOutOfRange;

/**
 * The type Address.
 */
public class Address {
    /**
     * The street of address.
     * Value can not be null.
     */
    private String street; //Поле не может быть null
    /**
     * The zip code of address.
     * Value can not be null.
     */
    private String zipCode; //Длина строки должна быть не меньше 8, Поле может быть null

    /**
     * Instantiates a new Address.
     *
     * @param street  the street.
     * @param zipCode the zip code.
     */
    public Address(String street, String zipCode) {
        setStreet(street);
        setZipCode(zipCode);
    }

    /**
     * Sets street.
     *
     * @param street the street
     * @throws NullValueException throw while value is null.
     */
    public void setStreet(String street) throws NullValueException {
        if (street == null) {
            throw new NullValueException("Error: Street can't be null\n");
        }
        else {
            this.street = street;
        }
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        if (zipCode == null) {
            throw new NullValueException("Error: zipcode can not be null!\n");
        }
        else if (zipCode.length() < 8) {
            throw new StringLengthOutOfRange("Error: The length of zipcode shouldn't be smaller than 8!\n");
        }
        else {
            this.zipCode = zipCode;
        }
    }

    public String toString() {
        return this.street + " street,zipcode:" + this.zipCode;
    }
}
