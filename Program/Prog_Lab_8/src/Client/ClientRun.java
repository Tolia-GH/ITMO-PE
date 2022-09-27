package Client;

import Exceptions.AbstractException;
import Manager.OrganizationManager;
import Tools.Tools;

import java.net.ConnectException;

/**
 * The type Client run.
 */
public class ClientRun {

    /**
     * The File path.
     */
    static String filePath;
    /**
     * The Ip.
     */
    static String ip;
    /**
     * The Port.
     */
    static int port;

    /**
     * The Is set from file.
     */
    static boolean isSetFromFile = false;

    private static void setArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
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
            Tools.MessageL("       -ip ipAddress");
            Tools.MessageL("       -p port");
            System.exit(1);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ClientRun.setArgs(args);
        Client client = new Client("localhost", 2001);
        try {
            client.run();
            client.runTerminal();
        } catch (ConnectException e) {
            Tools.MessageL("Error: Server not available!");
        } catch (AbstractException e) {
            Tools.MessageL(e.getMessage());
        } catch (Exception e) {
            Tools.MessageL("Error: Something Wrong!");
            e.printStackTrace();
        }
    }
}
