package Tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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

    /**
     * Is port available boolean.
     *
     * @param port the port
     * @return the boolean
     */
    public static boolean isPortAvailable(int port) {
        boolean available = true;
        ServerSocket s = null;
        try {
            s = new ServerSocket(port);
        } catch (IOException e) {
            available = false;
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {

                }
            }
        }
        return available;
    }
}
