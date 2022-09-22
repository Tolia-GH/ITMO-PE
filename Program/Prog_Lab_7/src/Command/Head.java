package Command;

import Main.PackageCommand;
import Manager.CommandManager;

/**
 * The type Head.
 */
public class Head extends AbstractCommand{
    /**
     * Instantiates a new Head.
     */
    public Head() {
        this.name = "head";
        this.description = "Return the first element of collection";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        commandManager.executeHead();
    }
}
