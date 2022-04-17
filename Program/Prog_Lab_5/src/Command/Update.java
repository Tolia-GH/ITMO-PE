package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

/**
 * The type Update.
 */
public class Update extends AbstractCommand {
    /**
     * Instantiates a new Update.
     */
    public Update() {
        this.name = "update";
        this.description = "Update the value of the collection element whose id is equal to the given one";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length!=2) {
            throw new ParaIncorrectException("Error [update]: this command only and must accept one parameter");
        } else if (Integer.parseInt(para[1])<=0) {
            throw new ParaIncorrectException("Error [update]: id should bigger than 0");
        } else {
            commandManager.executeUpdate(Long.valueOf(para[1]));
        }
    }
}
