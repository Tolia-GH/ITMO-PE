package Server;

import Exceptions.AbstractException;
import Tools.Tools;

import java.io.IOException;

/**
 * The type Server run.
 */
public class ServerRun {
    /**
     * The Port.
     */
    static int port = 2001;

    private static void setArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-p")) {
                    port = Integer.parseInt(args[++i]);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            Tools.MessageL("Error: You should input the arguments in the following format:");
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
        ServerRun.setArgs(args);
        Server server = new Server(port);
        try {
            server.run();
        } catch (AbstractException e) {
            Tools.MessageL(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
