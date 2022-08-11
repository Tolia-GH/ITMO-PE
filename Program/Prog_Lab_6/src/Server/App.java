package Server;

import Manager.CommandManager;
import Tools.Tools;

import java.io.IOException;

public class App {

    String filePath;
    int port;

    private void setArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-f": {
                        filePath = args[++i];
                        break;
                    }
                    /*case "-p": {
                        port = Integer.parseInt(args[++i]);
                        break;
                    }*/
                }
            }
        } catch (IndexOutOfBoundsException e) {
            Tools.MessageL("Error: You should input the arguments in the following format:");
            Tools.MessageL("       -f filepath");
            /*Tools.MessageL("       -ip ipAddress");
            Tools.MessageL("       -p port");*/
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();

        Server server = new Server(2001);
        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
