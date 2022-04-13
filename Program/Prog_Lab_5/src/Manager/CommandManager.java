package Manager;

import Collection.Exceptions.NoSuchCommandException;
import Collection.Exceptions.ParaIncorrectException;
import Collection.Organization;
import Collection.OrganizationType;
import Command.*;
import Tools.Tools;

import java.sql.ClientInfoStatus;
import java.util.*;

public class CommandManager {
    public static LinkedHashSet<AbstractCommand> commands = new LinkedHashSet<>();

    public CommandManager() {
        commands.add(new Help());
        commands.add(new Info());
        commands.add(new Show());
        commands.add(new Add());
        commands.add(new Update());
        commands.add(new RemoveByID());
        commands.add(new Clear());
        commands.add(new Save());
        commands.add(new ExecuteScript());
        commands.add(new Exit());
        commands.add(new Head());
        commands.add(new RemoveHead());
        commands.add(new AddIfMax());
        commands.add(new GroupCountingByID());
        commands.add(new FilterLessThanType());
        commands.add(new PrintFieldAscendingAnnualTurnover());
    }

    public LinkedHashSet<AbstractCommand> getCommands() {
        return commands;
    }

    public Organization findById(Long id) {
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (id.equals(organization.getId())) {
                return organization;
            }
        }
        throw new ParaIncorrectException("Error: Target organization not found!\n");
    }

    public void executeHelp() {
        for (AbstractCommand C : commands) {
            System.out.println(C.getName() + ": " + C.getDescription());
        }
    }

    public void executeInfo() {
        Tools.MessageL("    The date of initialization is: "
                + OrganizationManager.getInitializationTime() + "\n");
        Tools.MessageL("    The amount of elements is: "
                + OrganizationManager.getOrganizationSet().size()+"\n");
        Tools.MessageL("    The type of collection is: "
                + OrganizationManager.getOrganizationSet().getClass() +"\n");
    }

    public void executeShow() {
        if (OrganizationManager.getOrganizationSet().size() == 0) {
            Tools.MessageL("Program [show]: Collections of organization is empty!");
        } else {
            for (Organization organization : OrganizationManager.getOrganizationSet()) {
                System.out.print(organization.toString());
            }
        }
    }

    public void executeAdd(Organization organization) {
        if (OrganizationManager.IsInitialized) {
            OrganizationManager.getOrganizationSet().add(organization);
        } else {
            OrganizationManager.doInitialization();
            OrganizationManager.getOrganizationSet().add(organization);
        }
    }

    public void executeUpdate(Long id) {
        Organization changed = Organization.Create();
        Organization original = findById(id);

        Tools.MessageL("Program [update]: input new parameters to the target organization.");
        original.setName(changed.getName());
        original.setCoordinates(changed.getCoordinates());
        original.setAnnualTurnover(changed.getAnnualTurnover());
        original.setFullName(changed.getFullName());
        original.setEmployeesCount(changed.getEmployeesCount());
        original.setType(changed.getType());
        original.setPostalAddress(changed.getPostalAddress());
    }

    public void executeRemoveByID(Long id) {

        Organization organization = findById(id);

        OrganizationManager.getOrganizationSet().remove(organization);
    }

    public void executeRemoveHead() {
        if (!OrganizationManager.IsInitialized) {
            throw new NoSuchCommandException("Error: Collections was not initialized!\n");
        }

        Organization organization = findById(1L);

        OrganizationManager.getOrganizationSet().remove(organization);
    }

    public void executeClear() {
        OrganizationManager.getOrganizationSet().clear();
        Tools.MessageL("Program [clear]: Set cleared\n");
    }

    public void executeSave() {
    }

    public void executeExecuteScript(String name, CommandManager commandManager, String Saver) {
    }

    public void executeExit() {
        System.exit(2);
    }

    public void executeHead() {
        if (OrganizationManager.getOrganizationSet().size() == 0) {
            Tools.MessageL("Program [show]: Collections of organization is empty!");
        } else {
            Tools.Message(OrganizationManager.getOrganizationSet().getFirst().toString());
        }
    }

    public void executeAddIfMax(Organization organization) {

        boolean isMax = true;
        for (Organization value : OrganizationManager.getOrganizationSet()) {
            if (organization.compareTo(value) < 0) {
                isMax = false;
                Tools.MessageL("Program [add_if_max]: element id is not the max\n");
            }
        }
        if (isMax) {
            OrganizationManager.getOrganizationSet().add(organization);
        }
    }

    public void executeGroupCountingByID() {

    }

    public void executeFilterLessThanType(OrganizationType type) {
        boolean hasLess = false;
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (organization.getType().compareTo(type) < 0) {
                Tools.Message(organization.toString());
                hasLess = true;
            }
        }
        if (!hasLess) {
            Tools.MessageL("    Found no element!");
        }
    }

    public void executePrintFieldAscendingAnnualTurnover() {
        ArrayDeque<Organization> arrayDeque = OrganizationManager.getOrganizationSet().clone();
        long min = 9223372036854775807L;
        while (arrayDeque.size() > 0) {
            Organization minOrg = new Organization();
            for (Organization organization : arrayDeque) {
                if(organization.getAnnualTurnover() < min) {
                    min = organization.getAnnualTurnover();
                    minOrg = organization;
                }
            }
            Tools.Message(minOrg.toString());
            arrayDeque.remove(minOrg);
            min = 9223372036854775807L;
        }
//////
    }
}
