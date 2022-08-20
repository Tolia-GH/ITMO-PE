package Command;

import Main.PackageCommand;
import Manager.CommandManager;

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
    public void execute(CommandManager commandManager, PackageCommand packageCommand) {
        commandManager.executeAdd(packageCommand.getOrganization());
    }
}
