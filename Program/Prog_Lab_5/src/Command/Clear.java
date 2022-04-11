package Command;

import Collection.Exceptions.ParaIncorrectException;
import Collection.Organization;
import Manager.CommandManager;

public class Clear extends AbstractCommand {
    public Clear() {
        this.name = "clear";
        this.description = "Clear collection";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error: This command doesn't accept any parameter!\n");
        } else {
            commandManager.executeClear();
        }
    }
}
