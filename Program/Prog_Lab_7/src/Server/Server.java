/**
 * 8632
 */

package Server;

import Client.ClientInformation;
import Collection.Address;
import Collection.Coordinates;
import Collection.Organization;
import Collection.OrganizationType;
import Command.AbstractCommand;
import Exceptions.UserInformationException;
import Main.PackageCommand;
import Main.Request;
import Main.Response;
import Manager.CommandManager;
import Manager.OrganizationManager;
import Tools.Tools;

import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Date;
import java.util.List;


/**
 * The type Server.
 */
public class Server {

    private final int port;
    private ServerSocket serverSocket;
    private String fileName;
    private final String host = "localhost";
    private final String nameDB = "studs";
    private final String managerName = "postgres";
    private final String managerPass = "123456";
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

    /**
     * Handle command.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
    public void handleCommand(Socket socket) throws IOException {
        CommandManager commandManager = new CommandManager();
        boolean isClientSet = false;


        while (true) {
            //byte[] buffer = new byte[102400];

            try {//deal with account
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                Request request = (Request) ois.readObject();
                PackageCommand packageCommand = request.getPackageCommand();
                ClientInformation clientInformation = request.getClientInformation();
                Class.forName("org.postgresql.Driver");
                if (!isClientSet) {
                    Tools.MessageL("Server: Information of client: ");
                    Tools.MessageL("       Username: " + clientInformation.getUserName());
                    Tools.MessageL("       PassWord: " + clientInformation.getPassWord());
                    Tools.MessageL("       Hash: " + clientInformation.getHash());
                    isClientSet = true;
                    if (clientInformation.isCreate()) {
                        addUser(clientInformation);

                        String message = "You add a account: " + clientInformation.getUserName();

                        Response response = new Response(message);

                        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();//
                        ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
                        objectOut.writeObject(response);
                        byte[] bytes = byteArrayOut.toByteArray();
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(bytes);//
                    } else {
                        try {
                            checkUser(clientInformation);

                            String message = "Welcome! " + clientInformation.getUserName();
                            //Tools.MessageL(message);

                            Response response = new Response(message);

                            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();//
                            ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
                            objectOut.writeObject(response);
                            byte[] bytes = byteArrayOut.toByteArray();
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write(bytes);//
                        } catch (UserInformationException e) {
                            String message = e.getMessage();
                            Tools.MessageL(message);

                            Response response = new Response(message);

                            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();//
                            ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
                            objectOut.writeObject(response);
                            byte[] bytes = byteArrayOut.toByteArray();
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write(bytes);//

                            System.exit(1);
                        }
                    }
                } else {//deal with commands
                    OrganizationManager.doInitialization();
                    OrganizationManager.getOrganizationSet().clear();

                    try {
                        Connection connection = DriverManager.getConnection(linkDB, managerName, managerPass);
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM organizations ");
                        while (resultSet.next()) {
                            Organization organization = new Organization();

                            organization.setOwner(resultSet.getString("owner"));
                            organization.setId(resultSet.getLong("id"));
                            organization.setName(resultSet.getString("name"));
                            float x = resultSet.getFloat("x");
                            double y = resultSet.getDouble("y");
                            Coordinates coordinates = new Coordinates(x,y);
                            organization.setCoordinates(coordinates);
                            Date date = resultSet.getDate("date");
                            organization.setCreationDate(date);
                            organization.setAnnualTurnover(resultSet.getLong("annualturnover"));
                            organization.setFullName(resultSet.getString("fullname"));
                            organization.setEmployeesCount(resultSet.getLong("employeescount"));
                            String type = resultSet.getString("type");
                            organization.setType(OrganizationType.valueOf(type));
                            String street = resultSet.getString("street");
                            String zipCode = resultSet.getString("zipcode");
                            Address address = new Address(street,zipCode);
                            organization.setPostalAddress(address);

                            OrganizationManager.getOrganizationSet().add(organization);
                            //Tools.Message(".");
                        }
                        resultSet.close();
                        statement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                    String commandName = packageCommand.getAbstractCommand().getName();
                    AbstractCommand command = packageCommand.getAbstractCommand();
                    fileName = packageCommand.getFileName();
                    Tools.MessageL("Server: Receive command from client: " + commandName);

                    if (!command.getName().equalsIgnoreCase("execute_script")) {
                        command.execute(commandManager, packageCommand,linkDB,managerName,managerPass);

                        Response response = new Response(OrganizationManager.getOrganizationSet(),commandManager.getResponseMessage());

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
                            commandFromList.execute(commandManager,pack,linkDB,managerName,managerPass);
                            message.append("\nCommand[").append(commandFromList.getName()).append("]:\n");
                            message.append(commandManager.getResponseMessage());
                        }

                        Response response = new Response(OrganizationManager.getOrganizationSet(), message.toString());

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

    private void addUser(ClientInformation clientInformation) throws ClassNotFoundException {
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

    private void checkUser(ClientInformation clientInformation) throws ClassNotFoundException {
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
}
