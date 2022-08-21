package Command;

import Main.PackageCommand;
import Manager.CommandManager;

/**
 * The type Help.
 */
public class Help extends AbstractCommand {
    /**
     * Instantiates a new Help.
     */
    public Help() {
        this.name = "help";
        this.description = "Display help on available commands";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand) {
        commandManager.executeHelp();
    }
}
