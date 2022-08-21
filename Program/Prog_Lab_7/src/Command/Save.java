package Command;

import Main.PackageCommand;
import Manager.CommandManager;

import java.io.IOException;

/**
 * The type Save.
 */
public class Save extends AbstractCommand {
    /**
     * Instantiates a new Save.
     */
    public Save() {
        this.name = "save";
        this.description = "Save collection to file";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand) throws IOException {
        commandManager.executeSave(packageCommand.getFileName());
    }
}
