package Command;

import Main.PackageCommand;
import Manager.CommandManager;

import java.io.IOException;

/**
 * The type Execute script.
 */
public class ExecuteScript extends AbstractCommand {
    /**
     * Instantiates a new Execute script.
     */
    public ExecuteScript() {
        this.name = "execute_script";
        this.description = "Read and execute a script from the specified file. The script contains commands in the same form in which the user enters them interactively";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand) throws IOException {
        //commandManager.executeExecuteScript(para[1], commandManager, saver);
    }//useless
}
