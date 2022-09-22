package Main;

import Collection.Organization;
import Command.AbstractCommand;
import Exceptions.*;
import Manager.CommandManager;
import Tools.Tools;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * The type Package command.
 */
public class PackageCommand implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String[] commandWithArgs;
    private final AbstractCommand abstractCommand;
    private final Organization organization;
    private final LinkedBlockingDeque<Organization> organizationSet;
    private final String userName;
    private final String fileName;
    private final List<PackageCommand> list;
    private final boolean setFromFile;

    /**
     * Instantiates a new Package command.
     */
    public PackageCommand() {
        this.commandWithArgs = null;
        this.abstractCommand = null;
        this.organization = null;
        this.organizationSet = null;
        this.userName = null;
        this.fileName = null;
        this.list = null;
        this.setFromFile = false;
    }

    /**
     * Instantiates a new Package command.
     *
     * @param arg      the arg
     * @param command  the command
     * @param fileName the file name
     */
    public PackageCommand(String[] arg, AbstractCommand command, String fileName,String userName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = null;
        this.organizationSet = null;
        this.userName = userName;
        this.fileName = fileName;
        this.list = null;
        this.setFromFile = false;
    }

    /**
     * Instantiates a new Package command.
     *
     * @param arg             the arg
     * @param command         the command
     * @param packageCommands the package commands
     * @param fileName        the file name
     */
    public PackageCommand(String[] arg, AbstractCommand command, List<PackageCommand> packageCommands, String fileName,String userName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = null;
        this.organizationSet = null;
        this.userName = userName;
        this.fileName = fileName;
        this.list = packageCommands;
        this.setFromFile = false;
    }

    /**
     * Instantiates a new Package command.
     *
     * @param arg          the arg
     * @param command      the command
     * @param organization the organization
     * @param fileName     the file name
     */
    public PackageCommand(String[] arg, AbstractCommand command, Organization organization, String fileName, String userName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = organization;
        this.organizationSet = null;
        this.userName = userName;
        this.fileName = fileName;
        this.list = null;
        this.setFromFile = false;
    }

    /**
     * Instantiates a new Package command.
     *
     * @param organizationSet the organization set
     */
    public PackageCommand(LinkedBlockingDeque<Organization> organizationSet) {
        this.commandWithArgs = null;
        this.abstractCommand = null;
        this.organization = null;
        this.organizationSet = organizationSet;
        this.userName = null;
        this.fileName = null;
        this.list = null;
        this.setFromFile = true;
    }


    /**
     * Get command with args string [ ].
     *
     * @return the string [ ]
     */
    public String[] getCommandWithArgs() {
        return this.commandWithArgs;
    }

    /**
     * Gets abstract command.
     *
     * @return the abstract command
     */
    public AbstractCommand getAbstractCommand() {
        return this.abstractCommand;
    }

    /**
     * Gets organization.
     *
     * @return the organization
     */
    public Organization getOrganization() {
        return this.organization;
    }

    /**
     * Gets organization set.
     *
     * @return the organization set
     */
    public LinkedBlockingDeque<Organization> getOrganizationSet() {
        return this.organizationSet;
    }

    public String getUserName() {
        return this.userName;
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<PackageCommand> getList() {
        return this.list;
    }

    /**
     * Is set from file boolean.
     *
     * @return the boolean
     */
    public boolean isSetFromFile() {
        return setFromFile;
    }

    /**
     * Pack command package command.
     *
     * @param response        the response
     * @param commandWithArgs the command with args
     * @param commandManager  the command manager
     * @param fileName        the file name
     * @return the package command
     * @throws IOException the io exception
     */
    public static PackageCommand packCommand(Response response, String[] commandWithArgs, CommandManager commandManager, String fileName, String userName) throws IOException {

        AbstractCommand commandToBePacked = commandManager.findCommand(commandWithArgs[0]);
        PackageCommand packageCommand;

        switch (commandToBePacked.getName()) {
            case "add":
            case "add_if_max": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                Organization organization = Organization.Create();
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, organization, fileName, userName);
                return packageCommand;
            }
            case "clear":
            case "exit":
            case "head":
            case "help":
            case "info":
            case "remove_head":
            case "show": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName, userName);
                return packageCommand;
            }
            case "execute_script": {
                if (commandWithArgs.length != 2) {
                    throw new ParaIncorrectException("Error: This command accept 1 parameter!");
                } else {
                    File commandFile = new File(commandWithArgs[1]);
                    if (!commandFile.exists()) {
                        throw new FileNotFoundException("Error: File [" + commandWithArgs[1] + "] not found!");
                    }
                    if (!commandFile.canRead()){
                        throw new SecurityException("Error: File [" + commandWithArgs[1] + "] can not read!");
                    }
                    FileReader fileReader = new FileReader(commandFile);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String commandLine;
                    List<PackageCommand> commandList = new ArrayList<>();
                    while ((commandLine = bufferedReader.readLine()) != null) {
                        String[] splitCommand = commandLine.split(" ");
                        AbstractCommand command = commandManager.findCommand(splitCommand[0]);
                        if (command.getName().equals("execute_script")) {
                            throw new IllegalRecursionException("Error: Illegal recursion!");
                        } else {
                            PackageCommand packCommand = packCommand(response,splitCommand,commandManager,fileName, userName);
                            commandList.add(packCommand);
                        }
                    }
                    packageCommand = new PackageCommand(commandWithArgs,commandToBePacked,commandList,fileName, userName);
                }
                return packageCommand;
            }
            case "filter_less_than_type":
            case "remove_by_id": {
                if (commandWithArgs.length != 2) {
                    throw new ParaIncorrectException("Error: This command accept 1 parameter!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName, userName);
                return packageCommand;
            }
            case "group_counting_by_id":
            case "print_field_ascending_annual_turnover": {//haven't figured out what to do with this command
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName, userName);
                return packageCommand;
            }
            case "save": {
                if (commandWithArgs.length != 1) {//check parameter number
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }

                File file = new File(fileName);//check if file exist and ask if replace
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    Tools.Message("Program: File Already exist, Would you like to replace it? Y/N:");
                    switch (Tools.Input()) {
                        case "Y": {
                            file.delete();
                            file.createNewFile();
                            break;
                        }
                        case "N": {
                            throw new FileAlreadyExistsException("Program: command return because file exist");
                        }
                        default: {
                            throw new ValueOutOfRangeException("Program: command return because input error!");
                        }
                    }
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName,userName);
                return packageCommand;
            }
            case "update": {
                if (commandWithArgs.length != 2) {
                    throw new ParaIncorrectException("Error: This command accept 1 parameter!");
                } else if(Integer.parseInt(commandWithArgs[1]) > response.getAmountSet()) {
                    throw new OrganizationNotFoundException("Error: Organization not found!");
                } else {
                    Organization organization = Organization.Create();
                    packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, organization, fileName, userName);

                }
                return packageCommand;
            }
            default: {
                throw new NoSuchCommandException("Error: Command not found while packing!");
            }
        }
    }

}
