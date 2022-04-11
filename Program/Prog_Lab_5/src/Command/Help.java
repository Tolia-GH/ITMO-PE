package Command;

import Collection.Exceptions.ParaIncorrectException;
import Manager.CommandManager;

public class Help extends AbstractCommand {
    public Help() {
        this.name = "help";
        this.description = "Display help on available commands";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length > 1) {
            throw new ParaIncorrectException("Error [help]: This command doesn't accept any parameter!\n");
        }else {
            commandManager.executeHelp();
        }
    }
}
