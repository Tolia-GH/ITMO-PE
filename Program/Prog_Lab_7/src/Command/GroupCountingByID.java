package Command;

import Main.PackageCommand;
import Manager.CommandManager;

/**
 * The type Group counting by id.
 */
public class GroupCountingByID extends AbstractCommand {
    /**
     * Instantiates a new Group counting by id.
     */
    public GroupCountingByID() {
        this.name = "group_counting_by_id";
        this.description = "Group the elements of the collection by the value of the id field, display the number of elements in each group";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand) {
        commandManager.executeGroupCountingByID();
    }
}
