package Tools;

import Client.Client;
import Client.UIController.ManagerUI;
import Collection.Organization;
import Main.PackageCommand;
import Main.Request;
import Main.Response;
import Manager.CommandManager;
import javafx.scene.control.Alert;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The type Tools.
 */
public class Tools {
    /**
     * Message.
     *
     * @param message description of exception
     */
    public static void Message(String message) {
        System.out.print(message);
    }

    /**
     * Message.
     *
     * @param message the message
     */
    public static void Message(char message) {
        System.out.print(message);
    }

    /**
     * Message l.
     *
     * @param messageL description of exception l
     */
    public static void MessageL(String messageL) {
        System.out.println(messageL);
    }

    /**
     * Message l.
     *
     * @param messageL the message l
     */
    public static void MessageL(char messageL) {
        System.out.println(messageL);
    }

    /**
     * Input string.
     *
     * @return the string
     */
    public static String Input() {
        return new Scanner(System.in).nextLine();
    }

    public static void sendObject(Object obj, Socket socket) throws IOException {
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();//
        ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
        objectOut.writeObject(obj);
        objectOut.close();
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
    }

    public static void sendObject(Object obj, SocketChannel socketChannel) throws IOException {
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);

        objectOut.writeObject(obj);
        objectOut.flush();

        byte[] bytes = byteArrayOut.toByteArray();
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        socketChannel.write(byteBuffer);
    }

    public static Object readObject(SelectionKey key) throws IOException, ClassNotFoundException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        Tools.MessageL("Client: Receiving response from Server:\n");
        ByteBuffer byteBuffer = ByteBuffer.allocate(102400);
        byteBuffer.clear();
        socketChannel.read(byteBuffer);
        byteBuffer.flip();
        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(byteBuffer.array());

        ObjectInputStream objectIn = new ObjectInputStream(byteArrayIn);//
        return objectIn.readObject();
    }

    public static void handleCommand(String[] commandWithArgs, Organization organization) throws IOException, ClassNotFoundException {
        Client.socketChannel.register(Client.selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);

        CommandManager commandManager = new CommandManager();

        int numReadyChannel;

        while (true) {
            numReadyChannel = Client.selector.select();

            if (numReadyChannel > 0) {
                Iterator<SelectionKey> keyIterator = Client.selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (key.isWritable()) {

                        PackageCommand packCommand = PackageCommand.packCommand(Client.response, commandWithArgs, organization, commandManager, Client.fileName, Client.clientInformation.getUserName());
                        Request request = new Request(packCommand);

                        Tools.sendObject(request, Client.socketChannel);

                        if (commandWithArgs[0].equalsIgnoreCase("exit")) {
                            System.exit(0);
                        }

                        key.interestOps(SelectionKey.OP_READ);
                    }
                    if (key.isReadable()) {
                        Client.response = (Response) Tools.readObject(key);//Attention Here!

                        Alert alert;
                        if (Client.response.getResponseMessage().contains("Error")) {
                            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                        } else {
                            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Response from Server");
                        }
                        alert.setContentText(Client.response.getResponseMessage());
                        alert.showAndWait();

                        ManagerUI.refresh();
                        return;
                    }
                }
            }
        }
    }
}
