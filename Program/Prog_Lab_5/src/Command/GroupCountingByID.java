package Command;

import Manager.CommandManager;

public class GroupCountingByID extends AbstractCommand {
    public GroupCountingByID() {
        this.name = "group_counting_by_id";
        this.description = "Group the elements of the collection by the value of the id field, display the number of elements in each group";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {

    }
}
