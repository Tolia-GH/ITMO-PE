package Manager;

import Collection.Exceptions.*;
import Collection.*;
import Command.*;
import JSON.JsonWriter;
import Tools.Tools;

import java.io.*;
import java.util.*;

/**
 * The type Command manager.
 */
public class CommandManager {
    /**
     * The constant commands.
     */
    public static LinkedHashSet<AbstractCommand> commands = new LinkedHashSet<>();

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
     * Find by id organization.
     *
     * @param id the id
     * @return the organization
     */
    public Organization findById(Long id) {
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (id.equals(organization.getId())) {
                return organization;
            }
        }
        throw new ParaIncorrectException("Error: Target organization not found!\n");
    }

    /**
     * Execute help.
     */
    public void executeHelp() {
        for (AbstractCommand C : commands) {
            System.out.println(C.getName() + ": " + C.getDescription());
        }
    }

    /**
     * Execute info.
     */
    public void executeInfo() {
        Tools.MessageL("    The date of initialization is: "
                + OrganizationManager.getInitializationTime() + "\n");
        Tools.MessageL("    The amount of elements is: "
                + OrganizationManager.getOrganizationSet().size()+"\n");
        Tools.MessageL("    The type of collection is: "
                + OrganizationManager.getOrganizationSet().getClass() +"\n");
    }

    /**
     * Execute show.
     */
    public void executeShow() {
        if (OrganizationManager.getOrganizationSet().size() == 0) {
            System.out.println(OrganizationManager.getOrganizationSet().size());
            Tools.MessageL("Program [show]: Collections of organization is empty!");
        } else {
            for (Organization organization : OrganizationManager.getOrganizationSet()) {
                System.out.print(organization.toString());
            }
        }
    }

    /**
     * Execute add.
     *
     * @param organization the organization
     */
    public void executeAdd(Organization organization) {
        if (OrganizationManager.IsInitialized) {
            OrganizationManager.getOrganizationSet().add(organization);
        } else {
            OrganizationManager.doInitialization();
            OrganizationManager.getOrganizationSet().add(organization);
        }
    }

    /**
     * Execute update.
     *
     * @param id the id
     */
    public void executeUpdate(Long id) {
        Organization changed = Organization.Create();
        Organization original = findById(id);

        Tools.MessageL("Program [update]: input new parameters to the target organization.");
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

        Organization organization = findById(id);

        OrganizationManager.getOrganizationSet().remove(organization);
    }

    /**
     * Execute remove head.
     */
    public void executeRemoveHead() {
        if (!OrganizationManager.IsInitialized) {
            throw new NoSuchCommandException("Error: Collections was not initialized!\n");
        }

        Organization organization = findById(1L);

        OrganizationManager.getOrganizationSet().remove(organization);
    }

    /**
     * Execute clear.
     */
    public void executeClear() {
        OrganizationManager.getOrganizationSet().clear();
        Tools.MessageL("Program [clear]: Set cleared\n");
    }

    /**
     * Execute save.
     *
     * @param saver the saver
     * @throws IOException the io exception
     */
    public void executeSave(String saver) throws IOException {
        JsonWriter.SaveCollectionsToFile(OrganizationManager.getOrganizationSet(), saver);
    }

    /**
     * Execute execute script.
     *
     * @param name           the name
     * @param commandManager the command manager
     * @param Saver          the saver
     * @throws IOException the io exception
     */
    public void executeExecuteScript(String name, CommandManager commandManager, String Saver) throws IOException {
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
                command.execute(commandManager, split,Saver);
            }
        }
        bufferedReader.close();
    }

    /**
     * Execute exit.
     */
    public void executeExit() {
        System.exit(2);
    }

    /**
     * Execute head.
     */
    public void executeHead() {
        if (OrganizationManager.getOrganizationSet().size() == 0) {
            Tools.MessageL("Program [show]: Collections of organization is empty!");
        } else {
            Tools.Message(OrganizationManager.getOrganizationSet().getFirst().toString());
        }
    }

    /**
     * Execute add if max.
     *
     * @param organization the organization
     */
    public void executeAddIfMax(Organization organization) {

        boolean isMax = true;
        for (Organization value : OrganizationManager.getOrganizationSet()) {
            if (organization.compareTo(value) < 0) {
                isMax = false;
                Tools.MessageL("Program [add_if_max]: element id is not the max\n");
            }
        }
        if (isMax) {
            OrganizationManager.getOrganizationSet().add(organization);
        }
    }

    /**
     * Execute group counting by id.
     */
    public void executeGroupCountingByID() {
        Tools.MessageL("author: Haven't figure out what should I do with this command...");
    }

    /**
     * Execute filter less than type.
     *
     * @param type the type
     */
    public void executeFilterLessThanType(OrganizationType type) {
        boolean hasLess = false;
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (organization.getType().compareTo(type) < 0) {
                Tools.Message(organization.toString());
                hasLess = true;
            }
        }
        if (!hasLess) {
            Tools.MessageL("    Found no element!");
        }
    }

    /**
     * Execute print field ascending annual turnover.
     */
    public void executePrintFieldAscendingAnnualTurnover() {
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
            Tools.Message(minOrg.toString());
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
