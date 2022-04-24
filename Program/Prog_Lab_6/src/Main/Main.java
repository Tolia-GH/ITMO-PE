package Main;

import Collection.Exceptions.*;
import Command.AbstractCommand;
import Manager.CommandManager;
import Tools.Tools;

import java.io.IOException;
import java.util.Iterator;

/**
 * The type Main.Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        CommandManager commandManager = new CommandManager();

        Iterator<AbstractCommand> iterator;
        while (true) {
            AbstractCommand abstractCommand;
            iterator = commandManager.getCommands().iterator();
            //boolean comExist = false;

            Tools.MessageL("Program: Input your command:");
            Tools.Message("User: ");
            String[] command = Tools.Input().split(" ");
            try {
                while (iterator.hasNext()) {
                    abstractCommand = iterator.next();
                    if (abstractCommand.getName().equals(command[0])) {
                        //comExist = true;
                        abstractCommand.execute(commandManager, command, "Organizations.json");
                        Tools.Message("\n");
                    }
                }
                if (!commandManager.isCommandExist(command[0])) {
                    throw new NoSuchCommandException("Error: Command [" +command[0] + "] not found!\n");
                }
            } catch (NoSuchCommandException |
                    ParaIncorrectException |
                    NoSuchTypeException |
                    ValueOutOfRangeException |
                    NullValueException |
                    StringLengthOutOfRange |
                    NotInitializedException |
                    IOException exception) {
                Tools.MessageL(exception.getMessage());
            } catch (NumberFormatException numberFormat) {
                Tools.MessageL("Error: Value format error!");
            }
        }
    }
}
