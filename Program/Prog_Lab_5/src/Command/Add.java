package Command;

import Collection.Exceptions.ParaIncorrectException;
import Collection.Organization;
import Manager.CommandManager;
import Tools.Tools;

public class Add extends AbstractCommand{
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
