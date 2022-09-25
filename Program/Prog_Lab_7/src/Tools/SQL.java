package Tools;

import Collection.Address;
import Collection.Coordinates;
import Collection.Organization;
import Collection.OrganizationType;
import Manager.OrganizationManager;

import java.sql.*;
import java.util.Date;

public class SQL {

    private final static String host = "pg";//localhost
    private final static String nameDB = "studs";
    private final static String managerName = "s336184";//postgres
    private final static String managerPass = "Di2oaLyDd20js6Ox";//123456
    private final static String linkDB = "jdbc:postgresql://" + host + ":5432/" + nameDB;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try(Connection connection = DriverManager.getConnection(linkDB,managerName,managerPass)){
            System.out.print(connection);
        }
    }

    public static void getOrganizationsFromDB() {
        OrganizationManager.doInitialization();
        OrganizationManager.getOrganizationSet().clear();

        try {
            Connection connection = DriverManager.getConnection(linkDB, managerName, managerPass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM organizations ");
            while (resultSet.next()) {
                Organization organization = new Organization();

                organization.setOwner(resultSet.getString("owner"));
                organization.setId(resultSet.getLong("id"));
                organization.setName(resultSet.getString("name"));
                float x = resultSet.getFloat("x");
                double y = resultSet.getDouble("y");
                Coordinates coordinates = new Coordinates(x,y);
                organization.setCoordinates(coordinates);
                Date date = resultSet.getDate("date");
                organization.setCreationDate(date);
                organization.setAnnualTurnover(resultSet.getLong("annualturnover"));
                organization.setFullName(resultSet.getString("fullname"));
                organization.setEmployeesCount(resultSet.getLong("employeescount"));
                String type = resultSet.getString("type");
                organization.setType(OrganizationType.valueOf(type));
                String street = resultSet.getString("street");
                String zipCode = resultSet.getString("zipcode");
                Address address = new Address(street,zipCode);
                organization.setPostalAddress(address);

                OrganizationManager.getOrganizationSet().add(organization);
                //Tools.Message(".");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
