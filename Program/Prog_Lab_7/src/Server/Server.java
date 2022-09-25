/**
 * 8632
 */

package Server;

import Client.ClientInformation;
import Exceptions.UserInformationException;
import Main.PackageCommand;
import Main.Response;
import Manager.CommandManager;
import Tools.Tools;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


/**
 * The type Server.
 */
public class Server {

    private final int port;
    private ServerSocket serverSocket;
    private Response response;
    private final String host = "pg";//localhost
    private final String nameDB = "studs";
    private final String managerName = "s336184";//postgres
    private final String managerPass = "Di2oaLyDd20js6Ox";//123456
    private final String linkDB = "jdbc:postgresql://" + host + ":5432/" + nameDB;

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
    public void run() throws IOException, InterruptedException {
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
    public void Service() throws IOException, InterruptedException {
        Socket socket = serverSocket.accept();
        Tools.MessageL("Server: New connection accepted from: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

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
            Tools.MessageL("Server: Message from Client: " + new String(temp));
        //}
    }

    public void handleAccount(Socket socket, ClientInformation clientInformation) throws IOException, ClassNotFoundException {
        if (clientInformation.isCreate()) {
            addUser(clientInformation);

            String message = "You add a account: " + clientInformation.getUserName();
            Response response = new Response(message);
            Tools.sendObject(response,socket);
        } else {
            try {
                checkUser(clientInformation);

                String message = "Welcome! " + clientInformation.getUserName();
                Response response = new Response(message);
                Tools.sendObject(response,socket);
            } catch (UserInformationException e) {
                String message = e.getMessage();
                Tools.MessageL(message);

                Response response = new Response(message);

                Tools.sendObject(response,socket);

                System.exit(1);
            }
        }
    }

    /**
     * Handle command.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
    public void handleCommand(Socket socket) throws IOException, InterruptedException {
        CommandManager commandManager = new CommandManager();
        boolean isClientSet = false;

        while (true) {
            //byte[] buffer = new byte[102400];

            try {
                ServerReceiveThread serverReceiveThread = new ServerReceiveThread(socket);
                serverReceiveThread.start();
                serverReceiveThread.join();

                PackageCommand packageCommand = serverReceiveThread.getPackageCommand();
                ClientInformation clientInformation = serverReceiveThread.getClientInformation();

                Class.forName("org.postgresql.Driver");
                if (!isClientSet) {//deal with account
                    handleAccount(socket,clientInformation);
                    isClientSet = true;
                } else {//deal with commands
                    ServerDealThread serverDealThread = new ServerDealThread(packageCommand,commandManager,linkDB,managerName,managerPass);
                    serverDealThread.start();
                    serverDealThread.join();

                    response = serverDealThread.getResponse();

                    ServerSendThread serverSendThread = new ServerSendThread(response,socket);
                    serverSendThread.start();
                    serverSendThread.join();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkUser(ClientInformation clientInformation) {
        try {
            Connection connection = DriverManager.getConnection(linkDB, managerName, managerPass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM users " +
                            "WHERE username = " + "'" + clientInformation.getUserName() + "'");
            if (resultSet.next()) {
                resultSet = statement.executeQuery("SELECT * FROM users " +
                        "WHERE username = " + "'" + clientInformation.getUserName() + "'" +
                        "AND password = " + "'" + clientInformation.getPassWord() + "'");
                if (resultSet.next()) {
                    Tools.MessageL("Welcome! " + clientInformation.getUserName());
                } else {
                    throw new UserInformationException("Error: Incorrect password!");
                }
            } else {
                throw new UserInformationException("Error: User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUser(ClientInformation clientInformation) {
        try {
            Connection connection = DriverManager.getConnection(linkDB, managerName, managerPass);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username,password) VALUES (?,?);");
            statement.setObject(1,clientInformation.getUserName());
            statement.setObject(2,clientInformation.getPassWord());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
