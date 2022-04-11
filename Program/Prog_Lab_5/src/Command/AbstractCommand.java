package Command;

import Manager.CommandManager;

public abstract class AbstractCommand {
    protected String name;
    protected String description;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    abstract public void execute(CommandManager commandManager, String[] para, String saver);
}
