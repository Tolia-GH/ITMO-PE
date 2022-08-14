package Client;

import Exceptions.MyException;
import Exceptions.NoSuchCommandException;
import Exceptions.NoSuchTypeException;
import Tools.Tools;

import java.io.IOException;
import java.net.ConnectException;

public class App {

    String filePath;
    String ip;
    int port;

    private void setArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-f": {//setting file path
                        filePath = args[++i];
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
        Client client = new Client("localhost", 2001);
        try {
            client.run();
            client.runTerminal();
        } catch (ConnectException e) {
            Tools.MessageL("Error: Server not available!");
        } catch (MyException e) {
            Tools.MessageL(e.getMessage());
        } catch (IOException e) {
            //Tools.MessageL("Error: IO Exception!");
            e.printStackTrace();
        }
    }
}
