import Collection.Exceptions.*;
import Collection.Organization;
import Command.AbstractCommand;
import Command.Add;
import JSON.JsonReader;
import Manager.CommandManager;
import Manager.OrganizationManager;
import Tools.Tools;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;

import static Manager.OrganizationManager.*;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();

        if (args.length != 0) {
            try {
                String path = args[0];
                ArrayDeque<Organization>arrayDequeIn = JsonReader.getCollectionFromFile(path);
                OrganizationManager.setOrganizationSet(arrayDequeIn);
            } catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception e) {
                Tools.MessageL("Error: Something wrong with file input, You should input the path of a json file as parameter!");
            }
        }

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
