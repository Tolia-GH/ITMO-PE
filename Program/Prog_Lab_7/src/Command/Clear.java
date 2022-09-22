package Command;

import Main.PackageCommand;
import Manager.CommandManager;

import java.sql.SQLException;

/**
 * The type Clear.
 */
public class Clear extends AbstractCommand {
    /**
     * Instantiates a new Clear.
     */
    public Clear() {
        this.name = "clear";
        this.description = "Clear collection";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        try {
            commandManager.executeClear(packageCommand, linkDB, managerDB, passwordDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
