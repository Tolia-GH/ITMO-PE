package Command;

import Main.PackageCommand;
import Manager.CommandManager;

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
    public void execute(CommandManager commandManager, PackageCommand packageCommand) {
        commandManager.executeClear();
    }
}
