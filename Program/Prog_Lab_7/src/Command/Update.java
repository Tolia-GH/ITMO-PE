package Command;

import Exceptions.ParaIncorrectException;
import Main.PackageCommand;
import Manager.CommandManager;

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
    public void execute(CommandManager commandManager, PackageCommand packageCommand) {
        if (Integer.parseInt(packageCommand.getCommandWithArgs()[1])<=0) {
            throw new ParaIncorrectException("Error [update]: id should bigger than 0");
        } else {
            commandManager.executeUpdate(Long.valueOf(packageCommand.getCommandWithArgs()[1]), packageCommand.getOrganization());
        }
    }
}
