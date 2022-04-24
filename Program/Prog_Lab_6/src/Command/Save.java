package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

import java.io.IOException;

/**
 * The type Save.
 */
public class Save extends AbstractCommand {
    /**
     * Instantiates a new Save.
     */
    public Save() {
        this.name = "save";
        this.description = "Save collection to file";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) throws IOException {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error [save]: This command doesn't accept any parameter!\n");
        }else {
            commandManager.executeSave(saver);
        }
    }
}
