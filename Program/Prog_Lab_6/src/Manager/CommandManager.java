package Manager;

import Exceptions.NoSuchCommandException;
import Exceptions.ParaIncorrectException;
import Collection.Organization;
import Collection.OrganizationType;
import Command.*;
import JSON.JsonWriter;
import Main.PackageCommand;
import Tools.Tools;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedHashSet;

/**
 * The type Command manager.
 */
public class CommandManager {
    /**
     * The constant commands.
     */
    private static LinkedHashSet<AbstractCommand> commands = new LinkedHashSet<>();

    private String responseMessage = "";

    public void appendResponseMessage(String message) {
        this.responseMessage = this.responseMessage + message;
    }

    public void appendResponseMessageL(String message) {
        this.responseMessage = this.responseMessage + message + "\n";
    }

    public void clearResponseMessage() {
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

    public String getResponseMessage() {
        return this.responseMessage;
    }

    /**
     * Execute help.
     */
    public void executeHelp() {
        clearResponseMessage();
        appendResponseMessageL("All commands:");
        for (AbstractCommand C : commands) {
            appendResponseMessageL(C.getName() + ": " + C.getDescription());
            System.out.println();
        }
    }

    /**
     * Execute info.
     */
    public void executeInfo() {
        clearResponseMessage();
        appendResponseMessageL("Info of Collections:");
        appendResponseMessageL("    The amount of elements is: "
                + OrganizationManager.getOrganizationSet().size());
        appendResponseMessageL("    The type of collection is: "
                + OrganizationManager.getOrganizationSet().getClass());
        Tools.MessageL(getResponseMessage());
    }

    /**
     * Execute show.
     */
    public void executeShow() {
        clearResponseMessage();
        if (!OrganizationManager.IsInitialized) {
            appendResponseMessageL("Error: Collections was not initialized!");
        }
        if (OrganizationManager.getOrganizationSet().size() == 0) {
            appendResponseMessageL("Error: Collections of organization is empty!");
        } else {
            appendResponseMessageL("All organizations:");
            for (Organization organization : OrganizationManager.getOrganizationSet()) {
                appendResponseMessageL(organization.toString());
            }
            System.out.print(responseMessage);
        }
    }

    /**
     * Execute add.
     *
     * @param organization the organization
     */
    public void executeAdd(Organization organization) {
        clearResponseMessage();
        if (OrganizationManager.IsInitialized) {
            OrganizationManager.getOrganizationSet().add(organization);
        } else {
            OrganizationManager.doInitialization();
            OrganizationManager.getOrganizationSet().add(organization);
        }
        OrganizationManager.sort();
        appendResponseMessageL("You add an organization:");
        appendResponseMessageL(organization.toString());
    }

    /**
     * Execute update.
     *
     * @param id the id
     */
    public void executeUpdate(Long id, Organization organization) {
        clearResponseMessage();

        Organization changed = organization;
        Organization original = OrganizationManager.findById(id);

        appendResponseMessageL("Program [update]: organization updated");
        original.setName(changed.getName());
        original.setCoordinates(changed.getCoordinates());
        original.setAnnualTurnover(changed.getAnnualTurnover());
        original.setFullName(changed.getFullName());
        original.setEmployeesCount(changed.getEmployeesCount());
        original.setType(changed.getType());
        original.setPostalAddress(changed.getPostalAddress());
    }

    /**
     * Execute remove by id.
     *
     * @param id the id
     */
    public void executeRemoveByID(Long id) {
        clearResponseMessage();

        Organization organization = OrganizationManager.findById(id);

        OrganizationManager.getOrganizationSet().remove(organization);
        appendResponseMessageL("Program[execute_by_id]: organization removed.");
        OrganizationManager.sort();
    }

    /**
     * Execute remove head.
     */
    public void executeRemoveHead() {
        clearResponseMessage();

        if (!OrganizationManager.IsInitialized) {
            appendResponseMessageL("Error: Collections was not initialized!");
        } else {
            Organization organization = OrganizationManager.findById(1L);
            OrganizationManager.getOrganizationSet().remove(organization);
            appendResponseMessageL("Program[remove_head]: organization removed.");
        }
        Tools.MessageL(getResponseMessage());
        OrganizationManager.sort();
    }

    /**
     * Execute clear.
     */
    public void executeClear() {
        clearResponseMessage();
        OrganizationManager.getOrganizationSet().clear();
        appendResponseMessageL("Program [clear]: Set cleared");
        Tools.MessageL(getResponseMessage());
    }

    /**
     * Execute save.
     *
     * @param saver the saver
     * @throws IOException the io exception
     */
    public void executeSave(String saver) throws IOException {
        clearResponseMessage();

        JsonWriter.SaveCollectionsToFile(OrganizationManager.getOrganizationSet(), saver);
        appendResponseMessageL("Collection saved at: " + new File(saver).getAbsolutePath());
    }


    /**
     * Execute execute script.
     *
     * @param name           the name
     * @throws IOException the io exception
     */
    public void executeExecuteScript(String name, PackageCommand packageCommand) throws IOException {
        clearResponseMessage();

        File file = new File(name);
        if (!file.exists()) {
            throw new FileNotFoundException("Error: File [" + name + "] not found!");
        }
        if (!file.canRead()) {
            throw new SecurityException("Error: File [" + name + "] can not read!");
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String commandLine;
        while ((commandLine = bufferedReader.readLine()) != null){
            String []split = commandLine.split(" ");
            AbstractCommand command = findCommand(split[0]);

            if (command != null && !(command.getName().equals("ExecuteScript")&&split[1].equals(name))) {
                //command.execute(new CommandManager(), packageCommand);
            }
        }
        bufferedReader.close();
    }

    /**
     * Execute exit.
     */
    public void executeExit() {
        clearResponseMessage();

        Tools.MessageL("Server: Client exit");
        System.exit(0);
    }

    /**
     * Execute head.
     */
    public void executeHead() {
        clearResponseMessage();
        if (!OrganizationManager.IsInitialized) {
            clearResponseMessage();

            appendResponseMessageL("Error: Collections was not initialized!");
        } else if (OrganizationManager.getOrganizationSet().size() == 0) {
            appendResponseMessageL("Error: Collections of organization is empty!");
        } else {
            appendResponseMessageL("First organization:");
            appendResponseMessageL(OrganizationManager.getOrganizationSet().getFirst().toString());
        }
        Tools.MessageL(getResponseMessage());
    }

    /**
     * Execute add if max.
     *
     * @param organization the organization
     */
    public void executeAddIfMax(Organization organization) {
        clearResponseMessage();

        boolean isMax = true;
        for (Organization value : OrganizationManager.getOrganizationSet()) {
            if (organization.compareTo(value) < 0) {
                isMax = false;

            }
        }
        if (isMax) {
            OrganizationManager.getOrganizationSet().add(organization);
            OrganizationManager.sort();
            appendResponseMessageL(" You add an Organization: " + organization.toString());
        } else {
            appendResponseMessageL("Program [add_if_max]: element id is not the max");
        }
    }

    /**
     * Execute group counting by id.
     */
    public void executeGroupCountingByID() {
        clearResponseMessage();
        Tools.MessageL("author: Haven't figure out what should I do with this command...");
    }

    /**
     * Execute filter less than type.
     *
     * @param type the type
     */
    public void executeFilterLessThanType(OrganizationType type) {
        clearResponseMessage();
        boolean hasLess = false;
        appendResponseMessageL("Checking collections...");
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (organization.getType().compareTo(type) < 0) {
                appendResponseMessageL(organization.toString());
                hasLess = true;
            }
        }
        if (!hasLess) {
            appendResponseMessageL("    Found no element!");
        }
    }

    /**
     * Execute print field ascending annual turnover.
     */
    public void executePrintFieldAscendingAnnualTurnover() {
        clearResponseMessage();
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
            appendResponseMessageL(minOrg.toString());
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
