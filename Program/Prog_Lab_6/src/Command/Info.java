package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

/**
 * The type Info.
 */
public class Info extends AbstractCommand {
    /**
     * Instantiates a new Info.
     */
    public Info() {
        this.name = "info";
        this.description = "Print information about the collection to standard output (type, initialization date, number of elements, etc.)";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error [info]: This command doesn't accept any parameter!\n");
        }else {
            commandManager.executeInfo();
        }
    }
}
