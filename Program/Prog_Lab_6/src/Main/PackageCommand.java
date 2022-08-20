package Main;

import Exceptions.NoSuchCommandException;
import Exceptions.OrganizationNotFoundException;
import Exceptions.ParaIncorrectException;
import Collection.Organization;
import Command.AbstractCommand;
import Exceptions.ValueOutOfRangeException;
import Manager.CommandManager;
import Manager.OrganizationManager;
import Tools.Tools;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PackageCommand implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String[] commandWithArgs;
    private final AbstractCommand abstractCommand;
    private final Organization organization;
    private final ArrayDeque<Organization> organizationSet;
    private final String fileName;
    private final List<PackageCommand> list;
    private final boolean setFromFile;

    public PackageCommand() {
        this.commandWithArgs = null;
        this.abstractCommand = null;
        this.organization = null;
        this.organizationSet = null;
        this.fileName = null;
        this.list = null;
        this.setFromFile = false;
    }

    public PackageCommand(String[] arg, AbstractCommand command, String fileName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = null;
        this.organizationSet = null;
        this.fileName = fileName;
        this.list = null;
        this.setFromFile = false;
    }

    public PackageCommand(String[] arg, AbstractCommand command, List<PackageCommand> packageCommands, String fileName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = null;
        this.organizationSet = null;
        this.fileName = fileName;
        this.list = packageCommands;
        this.setFromFile = false;
    }

    public PackageCommand(String[] arg, AbstractCommand command, Organization organization, String fileName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = organization;
        this.organizationSet = null;
        this.fileName = fileName;
        this.list = null;
        this.setFromFile = false;
    }

    public PackageCommand(ArrayDeque<Organization> organizationSet) {
        this.commandWithArgs = null;
        this.abstractCommand = null;
        this.organization = null;
        this.organizationSet = organizationSet;
        this.fileName = null;
        this.list = null;
        this.setFromFile = true;
    }



    public String[] getCommandWithArgs() {
        return this.commandWithArgs;
    }

    public AbstractCommand getAbstractCommand() {
        return this.abstractCommand;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public ArrayDeque<Organization> getOrganizationSet() {
        return this.organizationSet;
    }

    public String getFileName() {
        return fileName;
    }

    public List<PackageCommand> getList() {
        return this.list;
    }

    public boolean isSetFromFile() {
        return setFromFile;
    }

    public static PackageCommand packCommand(Response response, String[] commandWithArgs, CommandManager commandManager, String fileName) throws IOException {

        AbstractCommand commandToBePacked = commandManager.findCommand(commandWithArgs[0]);
        PackageCommand packageCommand;

        switch (commandToBePacked.getName()) {
            case "add":
            case "add_if_max": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                Organization organization = Organization.Create();
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, organization, fileName);
                return packageCommand;
            }
            case "clear": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
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
                        if (command != null && !(command.getName().equals("execute_script") && splitCommand[1].equals(commandFile))) {
                            PackageCommand packCommand = packCommand(response,splitCommand,commandManager,fileName);
                            commandList.add(packCommand);
                        }
                    }
                    packageCommand = new PackageCommand(commandWithArgs,commandToBePacked,commandList,fileName);
                }
                return packageCommand;
            }
            case "exit": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "filter_less_than_type": {
                if (commandWithArgs.length != 2) {
                    throw new ParaIncorrectException("Error: This command accept 1 parameter!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "group_counting_by_id": {//haven't figure out what to do with this command
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "head": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "help": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "info": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "print_field_ascending_annual_turnover": {
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "remove_by_id": {
                if (commandWithArgs.length != 2) {
                    throw new ParaIncorrectException("Error: This command accept 1 parameter!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "remove_head": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
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
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "show": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "update": {
                if (commandWithArgs.length != 2) {
                    throw new ParaIncorrectException("Error: This command accept 1 parameter!");
                } else if(Integer.valueOf(commandWithArgs[1]) > response.getAmountSet()) {
                    throw new OrganizationNotFoundException("Error: Organization not found!");
                } else {
                    Organization organization = Organization.Create();
                    packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, organization, fileName);

                }
                return packageCommand;
            }
            default: {
                throw new NoSuchCommandException("Error: Command not found while packing!");
            }
        }
    }

}
