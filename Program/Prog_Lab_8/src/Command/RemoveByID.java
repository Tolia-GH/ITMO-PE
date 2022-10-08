package Command;

import Exceptions.ParaIncorrectException;
import Main.PackageCommand;
import Manager.CommandManager;

import java.sql.SQLException;

/**
 * The type Remove by id.
 */
public class RemoveByID extends AbstractCommand {
    /**
     * Instantiates a new Remove by id.
     */
    public RemoveByID() {
        this.name = "remove_by_id";
        this.description = "Remove an element from the collection by its id";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        try {
            commandManager.executeRemoveByID(Long.valueOf(packageCommand.getCommandWithArgs()[1]),packageCommand,linkDB,managerDB,passwordDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
