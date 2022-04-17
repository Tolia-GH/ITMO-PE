package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

/**
 * The type Exit.
 */
public class Exit extends AbstractCommand {
    /**
     * Instantiates a new Exit.
     */
    public Exit() {
        this.name = "exit";
        this.description = "End the program(without saving)";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error [exit]: This command doesn't accept any parameter!\n");
        }else {
            commandManager.executeExit();
        }
    }
}
