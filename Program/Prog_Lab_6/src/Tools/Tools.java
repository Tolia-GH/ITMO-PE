package Tools;

import java.io.IOException;
import java.net.ServerSocket;
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
