package Command;

import Main.PackageCommand;
import Manager.CommandManager;

/**
 * The type Print field ascending annual turnover.
 */
public class PrintFieldAscendingAnnualTurnover extends AbstractCommand {
    /**
     * Instantiates a new Print field ascending annual turnover.
     */
    public PrintFieldAscendingAnnualTurnover() {
        this.name = "print_field_ascending_annual_turnover";
        this.description = "Print the values of the annualTurnover field of all elements in ascending order";
    }

    @Override
    public void execute(CommandManager commandManager, PackageCommand packageCommand) {
        commandManager.executePrintFieldAscendingAnnualTurnover();
    }
}
