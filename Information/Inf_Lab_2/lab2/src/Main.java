import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HammingCode hamming = new HammingCode();
        while(true) {
            hamming.getMessage();
            hamming.handleMessage();
        }
    }
}

class HammingCode {
    Scanner sc = new Scanner(System.in);

    int getCode;
    int wrongBit;
    int[] bitGot = new int[7];
    int[] bitTrue = new int[7];

    void getMessage() {
        System.out.println("Program: Please input the Hamming code");
        System.out.print("User: ");
        getCode = sc.nextInt();
        for(int i = 6; i >= 0; i--) {
            bitGot[i] = getCode % 10;
            getCode /= 10;
        }
    }

    void handleMessage() {
        bitTrue = bitGot;
        int[] key = new int[3];
        key[0] = (bitGot[0] + bitGot[2] +bitGot[4] + bitGot[6]) % 2;
        key[1] = (bitGot[1] + bitGot[2] +bitGot[5] + bitGot[6]) % 2;
        key[2] = (bitGot[3] + bitGot[4] +bitGot[5] + bitGot[6]) % 2;
        wrongBit = key[2] * 4 + key[1] * 2 + key[0];
        if(wrongBit == 0) {
            System.out.println("Program: The code is correct!");
        } else {
            bitTrue[wrongBit - 1] = bitGot[wrongBit - 1] == 0? 1 : 0;
            System.out.println("Program: The code is wrong, the wrong bit is No." + wrongBit);
            System.out.print("Program: The correct code is: ");
            for(int bit:bitTrue) {
                System.out.print(bit);
            }
            System.out.println();
            System.out.println();
        }
    }
}