package Main;

import Exceptions.NoSuchCommandException;
import Exceptions.ParaIncorrectException;
import Collection.Organization;
import Command.AbstractCommand;
import Manager.CommandManager;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.List;

public class PackageCommand implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String[] commandWithArgs;
    private final AbstractCommand abstractCommand;
    private final Organization organization;
    private final ArrayDeque<Organization> arrayDeque;
    private final String fileName;
    private final List<PackageCommand> list;
    private final boolean set;

    public PackageCommand() {
        this.commandWithArgs = null;
        this.abstractCommand = null;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = null;
        this.list = null;
        this.set = false;
    }

    public PackageCommand(String[] arg, AbstractCommand command, String fileName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }

    public PackageCommand(AbstractCommand command, Organization organization, String fileName) {
        this.commandWithArgs = null;
        this.abstractCommand = command;
        this.organization = organization;
        this.arrayDeque = null;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }

    public PackageCommand(AbstractCommand command, ArrayDeque<Organization> arrayDeque, String fileName) {
        this.commandWithArgs = null;
        this.abstractCommand = command;
        this.organization = null;
        this.arrayDeque = arrayDeque;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }

    public PackageCommand(String[] arg, AbstractCommand command, Organization organization, String fileName) {
        this.commandWithArgs = arg;
        this.abstractCommand = command;
        this.organization = organization;
        this.arrayDeque = null;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }

    public PackageCommand(String name,boolean set){
        this.commandWithArgs = null;
        this.abstractCommand = null;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = name;
        this.list = null;
        this.set = set;
    }

    public PackageCommand(List<PackageCommand> list) {
        this.commandWithArgs = null;
        this.abstractCommand = null;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = null;
        this.list = list;
        this.set = false;
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

    public ArrayDeque<Organization> getArrayDeque() {
        return this.arrayDeque;
    }

    public String getFileName() {
        return fileName;
    }

    public List<PackageCommand> getList() {
        return this.list;
    }

    public boolean isSet() {
        return set;
    }

    public static PackageCommand packCommand(String[] commandWithArgs, CommandManager commandManager, String fileName) {

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
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
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
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command do not accept any parameters!");
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
                }
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            default: {
                throw new NoSuchCommandException("Error: Command not found while packing!");
            }
        }
    }

}
