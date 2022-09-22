package Command;

import Main.PackageCommand;
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
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        commandManager.executeAddIfMax(packageCommand.getOrganization());
    }
}
