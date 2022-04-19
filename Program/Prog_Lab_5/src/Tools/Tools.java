package Tools;

import java.util.Scanner;

/**
 * The type Tools.
 */
public class Tools {
    /**
     * Message.
     *
     * @param message description of exeption
     */
    public static void Message(String message) {
        System.out.print(message);
    }

    /**
     * Message l.
     *
     * @param messageL description of exeption l
     */
    public static void MessageL(String messageL) {
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
}
