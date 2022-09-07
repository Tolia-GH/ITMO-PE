/**
 * 8632
 */

package Server;

import Command.AbstractCommand;
import Main.PackageCommand;
import Main.Response;
import Manager.CommandManager;
import Manager.OrganizationManager;
import Tools.Tools;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


/**
 * The type Server.
 */
public class Server {

    private final int port;
    private ServerSocket serverSocket;
    private String fileName;

    /**
     * Instantiates a new Server.
     *
     * @param port the port
     */
    public Server(int port) {
        this.port = port;
    }

    /**
     * Begins server operation.
     *
     * @throws IOException the io exception
     */
    public void run() throws IOException {
        serverSocket = new ServerSocket(port);

        Tools.MessageL("Server: Listening at port: " + port);
        Tools.MessageL("Server: Waiting for client connection...");

        while (true) {
            Service();
        }
    }

    /**
     * Service.
     *
     * @throws IOException the io exception
     */
    public void Service() throws IOException {
        Socket socket = serverSocket.accept();
        Tools.MessageL("Server: New connection accepted from: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

        //Handler handler = new Handler(readFromClient,writeToClient);
        handleMessage(socket);
        handleCommand(socket);

    }

    /**
     * Handle message.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
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

    /**
     * Handle command.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
    public void handleCommand(Socket socket) throws IOException {
        CommandManager commandManager = new CommandManager();

        while (true) {
            //byte[] buffer = new byte[102400];

            try {
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                PackageCommand packageCommand = (PackageCommand) ois.readObject();
                if (packageCommand.isSetFromFile()) {
                    OrganizationManager.setOrganizationSet(packageCommand.getOrganizationSet());
                    OrganizationManager.sort();
                } else {
                    OrganizationManager.doInitialization();

                    String commandName = packageCommand.getAbstractCommand().getName();
                    AbstractCommand command = packageCommand.getAbstractCommand();
                    fileName = packageCommand.getFileName();
                    Tools.MessageL("Server: Receive command from client: " + commandName);

                    if (!command.getName().equalsIgnoreCase("execute_script")) {
                        command.execute(commandManager, packageCommand);

                        Response response = new Response(OrganizationManager.getOrganizationSet(),commandManager.getResponseMessage(),OrganizationManager.getOrganizationSet().size());

                        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();//
                        ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
                        objectOut.writeObject(response);
                        byte[] bytes = byteArrayOut.toByteArray();
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(bytes);//
                    /*
                    ATTENTION HERE!!!
                    I tried sending response to Client like this:
                        ObjectOutputStream objectOut = new ObjectOutputStream(socket.getOutputStream);
                        objectOut.writeObject(response);
                        objectOut.flush();
                    but cause java.io.StreamCorruptedException: invalid type code: 00
                    because when Create the object of ObjectOutputStream,the system will send 2 bytes head [AC ED] message to the IOStream
                    so when deserialize the object, if the ObjectOutputStream and the ObjectInputStream do not match each other
                    when deSerialization the ObjectInputStream will not receive the 2 bytes head message
                    and the serialVersionUID client receive not equals the class we want
                    As a result, java.io.StreamCorruptedException will be thrown
                    the ObjectInputStream and ObjectOutStream must patch each other when doing Serialization and deSerialization
                     */
                    } else {//for execute_script
                        List<PackageCommand> packCommand = packageCommand.getList();
                        StringBuilder message = new StringBuilder("executing commands from file...");

                        for (PackageCommand pack : packCommand) {
                            AbstractCommand commandFromList = pack.getAbstractCommand();
                            commandFromList.execute(commandManager,pack);
                            message.append("\nCommand[").append(commandFromList.getName()).append("]:\n");
                            message.append(commandManager.getResponseMessage());
                        }

                        Response response = new Response(OrganizationManager.getOrganizationSet(), message.toString(),OrganizationManager.getOrganizationSet().size());

                        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();//
                        ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
                        objectOut.writeObject(response);
                        byte[] bytes = byteArrayOut.toByteArray();
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(bytes);//
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
