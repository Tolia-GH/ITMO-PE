package Command;

import Main.PackageCommand;
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
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        commandManager.executeExit();
    }
}
