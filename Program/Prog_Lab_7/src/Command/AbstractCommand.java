package Command;

import Main.PackageCommand;
import Manager.CommandManager;

import java.io.IOException;
import java.io.Serializable;

/**
 * The type Abstract command.
 */
public abstract class AbstractCommand implements Serializable {
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
     * @param packageCommand the package command
     * @throws IOException the io exception
     */
    abstract public void execute(CommandManager commandManager, PackageCommand packageCommand) throws IOException;
}
