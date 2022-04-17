package Command;

import Manager.CommandManager;

import java.io.IOException;

/**
 * The type Abstract command.
 */
public abstract class AbstractCommand {
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Description.
     */
    protected String description;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Execute.
     *
     * @param commandManager the command manager
     * @param para           the para
     * @param saver          the saver
     * @throws IOException the io exception
     */
    abstract public void execute(CommandManager commandManager, String[] para, String saver) throws IOException;
}
