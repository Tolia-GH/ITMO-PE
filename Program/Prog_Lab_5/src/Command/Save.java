package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

public class Save extends AbstractCommand {
    public Save() {
        this.name = "save";
        this.description = "Save collection to file";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error [save]: This command doesn't accept any parameter!\n");
        }else {
            commandManager.executeSave();
        }
    }
}
