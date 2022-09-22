package Command;

import Main.PackageCommand;
import Manager.CommandManager;

import java.sql.SQLException;

/**
 * The type Add.
 */
public class Add extends AbstractCommand{
    /**
     * Instantiates a new Add.
     */
    public Add() {
        this.name = "add";
        this.description = "Add a new element to the organization set";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        try {
            commandManager.executeAdd(packageCommand.getOrganization(),packageCommand,linkDB,managerDB,passwordDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
