package Server;

import Command.AbstractCommand;
import Main.PackageCommand;
import Main.Response;
import Manager.CommandManager;
import Manager.OrganizationManager;
import Tools.SQL;
import Tools.Tools;

import java.io.IOException;
import java.util.List;

public class ServerDealThread extends Thread {

    private PackageCommand packageCommand;
    private CommandManager commandManager;
    private String linkDB;
    private String managerName;
    private String managerPass;

    private Response response;

    public ServerDealThread(PackageCommand packageCommand, CommandManager commandManager, String linkDB, String managerName, String managerPass) {
        this.packageCommand = packageCommand;
        this.commandManager = commandManager;
        this.linkDB = linkDB;
        this.managerName = managerName;
        this.managerPass = managerPass;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public void run() {
        try {
            SQL.getOrganizationsFromDB();

            String commandName = packageCommand.getAbstractCommand().getName();
            AbstractCommand command = packageCommand.getAbstractCommand();
            //fileName = packageCommand.getFileName();
            Tools.MessageL("Server: Receive command from client: " + commandName);

            if (!command.getName().equalsIgnoreCase("execute_script")) {
                command.execute(commandManager, packageCommand,linkDB,managerName,managerPass);
                response = new Response(OrganizationManager.getOrganizationSet(),commandManager.getResponseMessage());
            } else {//for execute_script
                List<PackageCommand> packCommand = packageCommand.getList();
                StringBuilder message = new StringBuilder("executing commands from file...");
                for (PackageCommand pack : packCommand) {
                    AbstractCommand commandFromList = pack.getAbstractCommand();
                    commandFromList.execute(commandManager,pack,linkDB,managerName,managerPass);
                    message.append("\nCommand[").append(commandFromList.getName()).append("]:\n");
                    message.append(commandManager.getResponseMessage());
                }

                response = new Response(OrganizationManager.getOrganizationSet(), message.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
