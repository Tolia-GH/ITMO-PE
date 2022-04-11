package Tools;

import java.util.Scanner;

public class Tools {
    public static void Message(String message) {
        System.out.print(message);
    }

    public static void MessageL(String messageL) {
        System.out.println(messageL);
    }

    public static String Input() {
        return new Scanner(System.in).nextLine();
    }
}
