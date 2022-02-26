package Manager;

import Command.*;

import java.util.LinkedHashSet;

public class CommandManager {

    private static LinkedHashSet<AbstractCommand> commands = new LinkedHashSet<>();

    public CommandManager() {
        commands.add(new Add());
        commands.add(new Clear());
        commands.add(new ExecuteScript());
        commands.add(new Exit());
        commands.add(new Help());
        commands.add(new Info());
        commands.add(new RemoveByID());
        commands.add(new Save());
        commands.add(new Show());
        commands.add(new Update());
        commands.add(new PrintFieldAscendingAnnualTurnover());
        commands.add(new RemoveHead());
        commands.add(new GroupCountingByID());
        commands.add(new AddIfMax());
        commands.add(new FliterLessThanType());
    }

    public LinkedHashSet getCommands() {
        return this.commands;
    }
}
