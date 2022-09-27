package Command;

import Main.PackageCommand;
import Manager.CommandManager;

import java.sql.SQLException;

/**
 * The type Remove head.
 */
public class RemoveHead extends AbstractCommand {
    /**
     * Instantiates a new Remove head.
     */
    public RemoveHead() {
        this.name = "remove_head";
        this.description = "Print the first element of the collection and remove it";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        try {
            commandManager.executeRemoveHead(linkDB,packageCommand,managerDB,passwordDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
