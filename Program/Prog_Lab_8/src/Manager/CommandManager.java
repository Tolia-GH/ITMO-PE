package Manager;

import Client.UIController.ManagerUI;
import Collection.ObservableOrganization;
import Collection.Organization;
import Collection.OrganizationType;
import Command.*;
import Exceptions.NoSuchCommandException;
import JSON.JsonWriter;
import Main.PackageCommand;
import Tools.Tools;
import com.sun.corba.se.spi.orb.StringPair;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingDeque;
import Tools.SQL;

/**
 * The type Command manager.
 */
public class CommandManager {
    /**
     * The constant commands.
     */
    private static final LinkedHashSet<AbstractCommand> commands = new LinkedHashSet<>();

    private String responseMessage = "";

    /**
     * Append message.
     *
     * @param message the message
     */
    public void appendMessage(String message) {
        this.responseMessage = this.responseMessage + message;
    }

    /**
     * Append message l.
     *
     * @param message the message
     */
    public void appendMessageL(String message) {
        this.responseMessage = this.responseMessage + message + "\n";
    }

    /**
     * Clear message.
     */
    public void clearMessage() {
        this.responseMessage = "";
    }

    /**
     * Instantiates a new Command manager.
     */
    public CommandManager() {
        commands.add(new Help());
        commands.add(new Info());
        commands.add(new Show());
        commands.add(new Add());
        commands.add(new Update());
        commands.add(new RemoveByID());
        commands.add(new Clear());
        commands.add(new Save());
        commands.add(new ExecuteScript());
        commands.add(new Exit());
        commands.add(new Head());
        commands.add(new RemoveHead());
        commands.add(new AddIfMax());
        commands.add(new GroupCountingByID());
        commands.add(new FilterLessThanType());
        commands.add(new PrintFieldAscendingAnnualTurnover());
    }

    /**
     * Gets commands.
     *
     * @return the commands
     */
    public LinkedHashSet<AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * Gets response message.
     *
     * @return the response message
     */
    public String getResponseMessage() {
        return this.responseMessage;
    }

    /**
     * Execute help.
     */
    public void executeHelp() {
        clearMessage();
        appendMessageL("All commands:");
        for (AbstractCommand C : commands) {
            appendMessageL(C.getName() + ": " + C.getDescription());
        }
    }

    /**
     * Execute info.
     */
    public void executeInfo() {
        clearMessage();
        appendMessageL("Info of Collections:");
        appendMessageL("    The amount of elements is: "
                + OrganizationManager.getOrganizationSet().size());
        appendMessageL("    The type of collection is: "
                + OrganizationManager.getOrganizationSet().getClass());
    }

    /**
     * Execute show.
     */
    public void executeShow() {
        clearMessage();
        if (!OrganizationManager.IsInitialized) {
            appendMessageL("Attention: Collections was not initialized!");
        }
        if (OrganizationManager.getOrganizationSet().size() == 0) {
            appendMessageL("Attention: Collections of organization is empty!");
        } else {
            appendMessageL("All organizations:");
            for (Organization organization : OrganizationManager.getOrganizationSet()) {
                appendMessageL(organization.toString());
            }
        }
    }

    /**
     * Execute add.
     *
     * @param organization the organization
     */
    public void executeAdd(Organization organization, PackageCommand packageCommand,String linkDb, String managerDb, String passwordDB) throws ClassNotFoundException, SQLException {
        clearMessage();
        if (!OrganizationManager.IsInitialized) {
            OrganizationManager.doInitialization();
        }

        organization.setId(1+OrganizationManager.getMaxId());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(linkDb,managerDb,passwordDB);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO organizations " +
                "(owner, id, name, x, y, date, annualTurnover, fullName, employeesCount, type, street, zipCode) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setObject(1,packageCommand.getUserName());
        preparedStatement.setObject(2,organization.getId());
        preparedStatement.setObject(3,organization.getName());
        preparedStatement.setObject(4,organization.getCoordinates().getX());
        preparedStatement.setObject(5,organization.getCoordinates().getY());
        preparedStatement.setObject(6,formatter.format(organization.getCreationDate()));
        preparedStatement.setObject(7,organization.getAnnualTurnover());
        preparedStatement.setObject(8,organization.getFullName());
        preparedStatement.setObject(9,organization.getEmployeesCount());
        preparedStatement.setObject(10,organization.getType().toString());
        preparedStatement.setObject(11,organization.getPostalAddress().getStreet());
        preparedStatement.setObject(12,organization.getPostalAddress().getZipCode());

        OrganizationManager.getOrganizationSet().add(organization);

        preparedStatement.executeUpdate();

        //ManagerUI.organizationList.add(organization.toObservableOrganization());

        //OrganizationManager.getOrganizationSet().add(organization);
        //OrganizationManager.sort();
        appendMessageL("You add an organization:");
        appendMessageL(organization.toString());
    }

    /**
     * Execute update.
     *
     * @param id           the id
     * @param organization the organization
     */
    public void executeUpdate(Long id, Organization organization, PackageCommand packageCommand, String linkDb, String managerDb, String passwordDB) throws ClassNotFoundException, SQLException {
        clearMessage();

        Organization original = OrganizationManager.findById(id);

        OrganizationManager.getOrganizationSet().remove(original);
        OrganizationManager.getOrganizationSet().add(organization);

        if (original != null && original.getOwner().equals(packageCommand.getUserName())) {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(linkDb,managerDb,passwordDB);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE organizations SET " +
                    "name = ?, x = ?, y = ?, date = ?, annualturnover = ?, fullname = ?, employeescount = ?, type = ?, street = ?, zipcode = ? WHERE id= ?");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            preparedStatement.setObject(1,organization.getName());
            preparedStatement.setObject(2,organization.getCoordinates().getX());
            preparedStatement.setObject(3,organization.getCoordinates().getY());
            preparedStatement.setObject(4,formatter.format(organization.getCreationDate()));
            preparedStatement.setObject(5,organization.getAnnualTurnover());
            preparedStatement.setObject(6,organization.getFullName());
            preparedStatement.setObject(7,organization.getEmployeesCount());
            preparedStatement.setObject(8,organization.getType().toString());
            preparedStatement.setObject(9,organization.getPostalAddress().getStreet());
            preparedStatement.setObject(10,organization.getPostalAddress().getZipCode());
            preparedStatement.setObject(11,organization.getId());
            preparedStatement.executeUpdate();

            appendMessageL("Program [update]: organization updated");
        } else {
            appendMessageL("Program [update]: Not available to update organization!");
        }

        /*
        original.setName(organization.getName());
        original.setCoordinates(organization.getCoordinates());
        original.setAnnualTurnover(organization.getAnnualTurnover());
        original.setFullName(organization.getFullName());
        original.setEmployeesCount(organization.getEmployeesCount());
        original.setType(organization.getType());
        original.setPostalAddress(organization.getPostalAddress());*/
    }

    /**
     * Execute remove by id.
     *
     * @param id the id
     */
    public void executeRemoveByID(Long id,PackageCommand packageCommand, String linkDb,String managerDb,String passwordDB) throws ClassNotFoundException, SQLException {
        clearMessage();
        if (!OrganizationManager.IsInitialized) {
            appendMessageL("Attention: Collections was not initialized!");
        } else {
            Organization organization = OrganizationManager.findById(id);
            OrganizationManager.getOrganizationSet().remove(organization);

            if (organization != null && organization.getOwner().equals(packageCommand.getUserName())) {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(linkDb,managerDb,passwordDB);
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM organizations WHERE id = ? AND owner = ?");
                preparedStatement.setObject(1,id);
                preparedStatement.setObject(2,packageCommand.getUserName());
                preparedStatement.executeUpdate();

                appendMessageL("Program[remove_by_id]: organization removed.");
            } else {
                appendMessageL("Program[remove_by_id]: Not available to remove organization!");
            }
        }

        //OrganizationManager.getOrganizationSet().remove(organization);

        //OrganizationManager.sort();
    }

    /**
     * Execute remove head.
     */
    public void executeRemoveHead(String linkDb,PackageCommand packageCommand,String managerDb,String passwordDB) throws ClassNotFoundException, SQLException {
        clearMessage();

        if (!OrganizationManager.IsInitialized) {
            appendMessageL("Error: Collections was not initialized!");
        } else {
            Organization organization = OrganizationManager.getOrganizationSet().getFirst();
            OrganizationManager.getOrganizationSet().remove(organization);

            if (organization != null && organization.getOwner().equals(packageCommand.getUserName())) {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(linkDb,managerDb,passwordDB);
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM organizations WHERE id = ? AND owner = ?");
                preparedStatement.setObject(1,1L);
                preparedStatement.setObject(2,packageCommand.getUserName());
                preparedStatement.executeUpdate();

                appendMessageL("Program[execute_by_id]: organization removed.");
            } else {
                appendMessageL("Program[execute_by_id]: Not available to remove organization!");
            }

            //OrganizationManager.getOrganizationSet().remove(organization);
            //appendMessageL("Program[remove_head]: organization removed.");
        }
        Tools.MessageL(getResponseMessage());
        //OrganizationManager.sort();
    }

    /**
     * Execute clear.
     * @param packageCommand
     * @param linkDB
     * @param managerDB
     * @param passwordDB
     */
    public void executeClear(PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) throws ClassNotFoundException, SQLException {
        clearMessage();

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(linkDB,managerDB,passwordDB);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM organizations WHERE owner = ?");
        preparedStatement.setObject(1,packageCommand.getUserName());
        preparedStatement.executeUpdate();

        OrganizationManager.getOrganizationSet().clear();

        appendMessageL("Program [clear]: Set cleared");
        Tools.MessageL(getResponseMessage());
    }

    /**
     * Execute save.
     *
     * @param saver the saver
     * @throws IOException the io exception
     */
    public void executeSave(String saver) throws IOException {
        clearMessage();

        JsonWriter.SaveCollectionsToFile(OrganizationManager.getOrganizationSet(), saver);
        appendMessageL("Collection saved at: " + new File(saver).getAbsolutePath());
    }


    /**
     * Execute exit.
     */
    public void executeExit() {
        clearMessage();

        Tools.MessageL("Server: Client exit");
        System.exit(0);
    }

    /**
     * Execute head.
     */
    public void executeHead() {
        clearMessage();
        if (!OrganizationManager.IsInitialized) {
            clearMessage();

            appendMessageL("Error: Collections was not initialized!");
        } else if (OrganizationManager.getOrganizationSet().size() == 0) {
            appendMessageL("Error: Collections of organization is empty!");
        } else {
            appendMessageL("First organization:");
            appendMessageL(OrganizationManager.getOrganizationSet().getFirst().toString());
        }
        //Tools.MessageL(getResponseMessage());
    }

    /**
     * Execute add if max.
     *
     * @param organization the organization
     */
    public void executeAddIfMax(Organization organization) {
        clearMessage();

        boolean isMax = true;
        for (Organization value : OrganizationManager.getOrganizationSet()) {
            if (organization.compareTo(value) < 0) {
                isMax = false;

                break;
            }
        }
        if (isMax) {
            OrganizationManager.getOrganizationSet().add(organization);
            OrganizationManager.sort();
            appendMessageL("You add an organization:");
            appendMessageL(organization.toString());
        } else {
            appendMessageL("Program [add_if_max]: element id is not the max");
        }
    }

    /**
     * Execute group counting by id.
     */
    public void executeGroupCountingByID() {
        clearMessage();
        appendMessageL("author: Haven't figure out what should I do with this command...");
    }

    /**
     * Execute filter less than type.
     *
     * @param type the type
     */
    public void executeFilterLessThanType(OrganizationType type) {
        clearMessage();
        boolean hasLess = false;
        appendMessageL("Checking collections...");
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (organization.getType().compareTo(type) < 0) {
                appendMessageL(organization.toString());
                hasLess = true;
            }
        }
        if (!hasLess) {
            appendMessageL("    Found no element!");
        }
    }

    /**
     * Execute print field ascending annual turnover.
     */
    public void executePrintFieldAscendingAnnualTurnover() {
        clearMessage();
        LinkedBlockingDeque<Organization> linkedBlockingDeque = new LinkedBlockingDeque<>();
        for (Organization o : OrganizationManager.getOrganizationSet()) {
            linkedBlockingDeque.add(o);
        }
        long min = Long.MAX_VALUE;
        while (linkedBlockingDeque.size() > 0) {
            Organization minOrg = new Organization();
            for (Organization organization : linkedBlockingDeque) {
                if(organization.getAnnualTurnover() < min) {
                    min = organization.getAnnualTurnover();
                    minOrg = organization;
                }
            }
            appendMessageL(minOrg.toString());
            linkedBlockingDeque.remove(minOrg);
            min = Long.MAX_VALUE;
        }
        //SQL.getOrganizationsFromDB();
    }

    /**
     * Got command abstract command.
     *
     * @param commandName the command name
     * @return the abstract command
     */
    public AbstractCommand findCommand(String commandName) {
        AbstractCommand targetCommand;
        for (AbstractCommand command : commands) {
            if(command.getName().equalsIgnoreCase(commandName)) {
                targetCommand = command;
                return targetCommand;
            }
        }
        throw new NoSuchCommandException("Error: Command not found!");
    }

    /**
     * Is command exist boolean.
     *
     * @param commandName the command name
     * @return the boolean
     */
    public boolean isCommandExist(String commandName) {
        for (AbstractCommand command : commands) {
            if (command.getName().equalsIgnoreCase(commandName)) {
                return true;
            }
        }
        return false;
    }
}
