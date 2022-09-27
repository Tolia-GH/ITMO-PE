package Command;

import Collection.OrganizationType;
import Exceptions.ParaIncorrectException;
import Main.PackageCommand;
import Manager.CommandManager;

/**
 * The type Filter less than type.
 */
public class FilterLessThanType extends AbstractCommand {
    /**
     * Instantiates a new Filter less than type.
     */
    public FilterLessThanType() {
        this.name = "filter_less_than_type";
        this.description = "Display elements whose type field value is less than the given one";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand, String linkDB, String managerDB, String passwordDB) {
        if (!OrganizationType.findType(packageCommand.getCommandWithArgs()[1])) {
            throw new ParaIncorrectException("Error [filter_less_than_type]: Organization type not found!");
        } else {
            commandManager.executeFilterLessThanType(OrganizationType.valueOf(packageCommand.getCommandWithArgs()[1]));
        }
    }
}
