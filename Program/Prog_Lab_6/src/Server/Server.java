/**
 * 8632
 */

package Server;

import Command.AbstractCommand;
import Command.Add;
import Main.PackageCommand;
import Manager.CommandManager;
import Manager.OrganizationManager;
import Tools.Tools;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {

    private final int port;
    private ServerSocket serverSocket;
    private BufferedReader readFromClient;
    private PrintWriter writeToClient;
    private String fileName;

    public Server(int port) {
        this.port = port;
    }

    /**
     * Begins server operation.
     */
    public void run() throws IOException {
        serverSocket = new ServerSocket(port);

        Tools.MessageL("Server: Listening at port: " + port);
        Tools.MessageL("Server: Waiting for client connection...");

        while (true) {
            Service();
        }
    }

    /*private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8),true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
    }*/

    public void Service() throws IOException {
        Socket socket = serverSocket.accept();
        Tools.MessageL("Server: New connection accepted from: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

        //Handler handler = new Handler(readFromClient,writeToClient);
        handleMessage(socket);
        handleCommand(socket);

    }

    public void handleMessage(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        byte[] receiveBuffer = new byte[1024];
        int messageSize = in.read(receiveBuffer);
        //while ((messageSize = in.read(receiveBuffer)) != -1) {
            byte[] temp = new byte[messageSize];
            System.arraycopy(receiveBuffer,0,temp,0,messageSize);
            Tools.MessageL("Message from Client: " + new String(temp));
        //}
    }

    public void handleCommand(Socket socket) throws IOException {
        CommandManager commandManager = new CommandManager();
        while (true) {
            //byte[] buffer = new byte[102400];
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            try {
                PackageCommand packageCommand = (PackageCommand) ois.readObject();
                String commandName = packageCommand.getAbstractCommand().getName();
                AbstractCommand command = packageCommand.getAbstractCommand();
                fileName = packageCommand.getFileName();
                Tools.MessageL("Server: Receive command from client: " + commandName);
                //command.execute(commandManager, packageCommand.getCommandWithArgs(), packageCommand.getFileName());
                if (commandName.equals("add")) {
                    Tools.MessageL("Receive command from client: add");
                    Tools.MessageL(packageCommand.getOrganization().toString());

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
