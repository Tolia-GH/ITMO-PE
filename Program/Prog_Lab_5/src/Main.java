import Collection.Exceptions.*;
import Collection.Organization;
import Command.AbstractCommand;
import Manager.CommandManager;
import Tools.Tools;

import java.util.Iterator;

/**
 * @author P3113 Чжоу Хунсян
 * Variant 951316
 */

public class Main {
    public static void main(String[] args) {

        CommandManager commandManager = new CommandManager();

        Iterator<AbstractCommand> iterator;
        while (true) {
            AbstractCommand abstractCommand;
            iterator = commandManager.getCommands().iterator();
            boolean comExist = false;

            Tools.MessageL("Program: Input your command:");
            Tools.Message("User: ");
            String[] command = Tools.Input().split(" ");
            try {
                while (iterator.hasNext()) {
                    abstractCommand = iterator.next();
                    if (abstractCommand.getName().equals(command[0])) {
                        comExist = true;
                        abstractCommand.execute(commandManager, command, "Person.csv");
                        Tools.Message("\n");
                    }
                }
                if (!comExist) {
                    throw new NoSuchCommandException("Error: Command [" +command[0] + "] not found!\n");
                }

            } catch (NoSuchCommandException noSuchCom) {
                Tools.MessageL(noSuchCom.getMessage());
            } catch (ParaIncorrectException para) {
                Tools.MessageL(para.getMessage());
            } catch (NoSuchTypeException noSuchType) {
                Tools.MessageL(noSuchType.getMessage());
            } catch (ValueOutOfRangeException valueOutOfRange) {
                Tools.MessageL(valueOutOfRange.getMessage());
            } catch (NullValueException nullValue) {
                Tools.MessageL(nullValue.getMessage());
            } catch (NumberFormatException numberFormat) {
                Tools.MessageL("Error: Value format error!");
            } catch (StringLengthOutOfRange lengthOutOfRange) {
                Tools.MessageL(lengthOutOfRange.getMessage());
            } catch (NotInitializedException notInitialized) {
                Tools.MessageL(notInitialized.getMessage());
            }
        }
    }
}
