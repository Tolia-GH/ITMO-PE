package Command;

import Collection.Exceptions.ParaIncorrectException;
import Collection.Organization;
import Manager.CommandManager;

/**
 * The type Add if max.
 */
public class AddIfMax extends AbstractCommand {
    /**
     * Instantiates a new Add if max.
     */
    public AddIfMax() {
        this.name = "add_if_max";
        this.description = "Add a new element to the collection if its value is the max in this collection";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error: This command doesn't accept any parameter!\n");
        } else {
            commandManager.executeAddIfMax(Organization.Create());
        }
    }
}
