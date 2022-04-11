package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

public class RemoveByID extends AbstractCommand {
    public RemoveByID() {
        this.name = "remove_by_id";
        this.description = "Remove an element from the collection by its id";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length!=2) {
            throw new ParaIncorrectException("Error [remove_by_id]: this command only and must accept one parameter");
        }else if (Integer.parseInt(para[1])<=0) {
            throw new ParaIncorrectException("Error [remove_by_id]: id should bigger than 0");
        } else {
            commandManager.executeRemoveByID(Long.valueOf(para[1]));
        }
    }
}
