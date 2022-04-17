package Command;

import Collection.Exceptions.ParaIncorrectException;
import Collection.OrganizationType;
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
    public void execute(CommandManager commandManager, String[] para, String saver) {
        if (para.length != 2) {
            throw new ParaIncorrectException("Error [filter_less_than_type]: this command only and must accept one parameter");
        } else if (!OrganizationType.findType(para[1])) {
            throw new ParaIncorrectException("Error [filter_less_than_type]: Organization type not found!");
        } else {
            commandManager.executeFilterLessThanType(OrganizationType.valueOf(para[1]));
        }
    }
}
