package Client;

import Collection.Organization;
import Exceptions.MyException;
import JSON.JsonReader;
import Manager.OrganizationManager;
import Tools.Tools;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayDeque;

public class ClientRun {

    static String filePath;
    static String ip;
    static int port;

    static boolean isSetFromFile = false;

    private static void setArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-f": {//setting file path
                        filePath = args[++i];
                        isSetFromFile = true;
                        break;
                    }
                    case "-ip": {//setting ip address
                        ip = args[++i];
                        break;
                    }
                    case "-p": {//setting port
                        port = Integer.parseInt(args[++i]);
                        break;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            Tools.MessageL("Error: You should input the arguments in the following format:");
            Tools.MessageL("       -f filepath");
            Tools.MessageL("       -ip ipAddress");
            Tools.MessageL("       -p port");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        ClientRun.setArgs(args);
        Client client = new Client("localhost", 2001);
        try {
            client.run();
            client.runTerminal(isSetFromFile, filePath);
        } catch (ConnectException e) {
            Tools.MessageL("Error: Server not available!");
        } catch (MyException e) {
            Tools.MessageL(e.getMessage());
        } catch (IOException e) {
            //Tools.MessageL("Error: IO Exception!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
