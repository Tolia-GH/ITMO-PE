package Command;

import Exceptions.ParaIncorrectException;
import Main.PackageCommand;
import Manager.CommandManager;

import java.sql.SQLException;

/**
 * The type Update.
 */
public class Update extends AbstractCommand {
    /**
     * Instantiates a new Update.
     */
    public Update() {
        this.name = "update";
        this.description = "Update the value of the collection element whose id is equal to the given one";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        if (Integer.parseInt(packageCommand.getCommandWithArgs()[1])<=0) {
            throw new ParaIncorrectException("Error [update]: id should bigger than 0");
        } else {
            try {
                commandManager.executeUpdate(Long.valueOf(packageCommand.getCommandWithArgs()[1]), packageCommand.getOrganization(), packageCommand, linkDB, managerDB, passwordDB);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
