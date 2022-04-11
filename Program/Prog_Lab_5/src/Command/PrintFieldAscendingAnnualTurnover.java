package Command;

import Manager.CommandManager;

public class PrintFieldAscendingAnnualTurnover extends AbstractCommand {
    public PrintFieldAscendingAnnualTurnover() {
        this.name = "print_field_ascending_annual_turnover";
        this.description = "Print the values \u200B\u200Bof the annualTurnover field of all elements in ascending order";
    }

    @Override
    public void execute(CommandManager commandManager, String[] para, String saver) {

    }
}
