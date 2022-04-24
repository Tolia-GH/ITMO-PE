package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

/**
 * The type Head.
 */
public class Head extends AbstractCommand{
    /**
     * Instantiates a new Head.
     */
    public Head() {
        this.name = "head";
        this.description = "Return the first element of collection";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error [head]: This command doesn't accept any parameter!\n");
        } else {
            commandManager.executeHead();
        }
    }
}
