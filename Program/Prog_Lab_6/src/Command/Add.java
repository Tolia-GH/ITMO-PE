package Command;

import Collection.Exceptions.ParaIncorrectException;
import Collection.Organization;
import Manager.CommandManager;
import Tools.Tools;

/**
 * The type Add.
 */
public class Add extends AbstractCommand{
    /**
     * Instantiates a new Add.
     */
    public Add() {
        this.name = "add";
        this.description = "Add a new element to the organization set";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error: This command doesn't accept any parameter!\n");
        }else {
            Tools.MessageL("Program [add]: Please input parameters to create a organization");
            commandManager.executeAdd(Organization.Create());
        }
    }
}
