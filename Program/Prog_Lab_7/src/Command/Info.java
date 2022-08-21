package Command;

import Main.PackageCommand;
import Manager.CommandManager;

/**
 * The type Info.
 */
public class Info extends AbstractCommand {
    /**
     * Instantiates a new Info.
     */
    public Info() {
        this.name = "info";
        this.description = "Print information about the collection to standard output (type, initialization date, number of elements, etc.)";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand) {
        commandManager.executeInfo();
    }
}
