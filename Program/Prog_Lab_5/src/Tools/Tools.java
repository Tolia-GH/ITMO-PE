package Tools;

import java.util.Scanner;

public class Tools {
    public static void Message(String message) {
        System.out.println(message);
    }

    public static String Input() {
        return new Scanner(System.in).nextLine();
    }
}
