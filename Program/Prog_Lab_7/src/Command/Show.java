package Command;

import Main.PackageCommand;
import Manager.CommandManager;

/**
 * The type Show.
 */
public class Show extends AbstractCommand {
    /**
     * Instantiates a new Show.
     */
    public Show() {
        this.name = "show";
        this.description = "Print to standard output all elements of the collection in string representation";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        commandManager.executeShow();
    }
}
