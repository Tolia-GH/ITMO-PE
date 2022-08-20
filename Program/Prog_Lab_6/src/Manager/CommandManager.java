package Manager;

import Collection.Organization;
import Collection.OrganizationType;
import Command.*;
import Exceptions.NoSuchCommandException;
import JSON.JsonWriter;
import Tools.Tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedHashSet;

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
            appendMessageL("Error: Collections was not initialized!");
        }
        if (OrganizationManager.getOrganizationSet().size() == 0) {
            appendMessageL("Error: Collections of organization is empty!");
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
    public void executeAdd(Organization organization) {
        clearMessage();
        if (OrganizationManager.IsInitialized) {
            OrganizationManager.getOrganizationSet().add(organization);
        } else {
            OrganizationManager.doInitialization();
            OrganizationManager.getOrganizationSet().add(organization);
        }
        OrganizationManager.sort();
        appendMessageL("You add an organization:");
        appendMessageL(organization.toString());
    }

    /**
     * Execute update.
     *
     * @param id           the id
     * @param organization the organization
     */
    public void executeUpdate(Long id, Organization organization) {
        clearMessage();

        Organization original = OrganizationManager.findById(id);

        appendMessageL("Program [update]: organization updated");
        original.setName(organization.getName());
        original.setCoordinates(organization.getCoordinates());
        original.setAnnualTurnover(organization.getAnnualTurnover());
        original.setFullName(organization.getFullName());
        original.setEmployeesCount(organization.getEmployeesCount());
        original.setType(organization.getType());
        original.setPostalAddress(organization.getPostalAddress());
    }

    /**
     * Execute remove by id.
     *
     * @param id the id
     */
    public void executeRemoveByID(Long id) {
        clearMessage();

        Organization organization = OrganizationManager.findById(id);

        OrganizationManager.getOrganizationSet().remove(organization);
        appendMessageL("Program[execute_by_id]: organization removed.");
        OrganizationManager.sort();
    }

    /**
     * Execute remove head.
     */
    public void executeRemoveHead() {
        clearMessage();

        if (!OrganizationManager.IsInitialized) {
            appendMessageL("Error: Collections was not initialized!");
        } else {
            Organization organization = OrganizationManager.findById(1L);
            OrganizationManager.getOrganizationSet().remove(organization);
            appendMessageL("Program[remove_head]: organization removed.");
        }
        Tools.MessageL(getResponseMessage());
        OrganizationManager.sort();
    }

    /**
     * Execute clear.
     */
    public void executeClear() {
        clearMessage();
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
        Tools.MessageL("author: Haven't figure out what should I do with this command...");
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
        ArrayDeque<Organization> arrayDeque = OrganizationManager.getOrganizationSet().clone();
        long min = Long.MAX_VALUE;
        while (arrayDeque.size() > 0) {
            Organization minOrg = new Organization();
            for (Organization organization : arrayDeque) {
                if(organization.getAnnualTurnover() < min) {
                    min = organization.getAnnualTurnover();
                    minOrg = organization;
                }
            }
            appendMessageL(minOrg.toString());
            arrayDeque.remove(minOrg);
            min = Long.MAX_VALUE;
        }
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
