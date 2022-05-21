package Main;

import Tools.Tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static BufferedReader buffReader;
    private static BufferedWriter buffWriter;
    private static ServerSocket serverSocket;
    private static Socket socket;
    static String filePath;
    static int port = 2022;

    private static void setArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-f": {
                        filePath = args[++i];
                        break;
                    }
                    case "-p": {
                        port = Integer.parseInt(args[++i]);
                        break;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            Tools.MessageL("Error: You should input the arguments in the following format:");
            Tools.MessageL("       -f filepath");
            Tools.MessageL("       -ip ipAddress");
            Tools.MessageL("       -p port");
            System.exit(1);
        }
    }

    static void setServer() {
        try {
            Tools.Message("Server: Creating ServerSocket...");
            serverSocket = new ServerSocket(port);
            Thread.sleep(500L);
            Tools.MessageL("successful!");
            Thread.sleep(300L);
            Tools.MessageL("Server: Server Socket created at port: " + port);
            Thread.sleep(300L);
            Tools.MessageL("Server: Waiting for client connection...");
            socket = serverSocket.accept();
            Thread.sleep(300L);
            Tools.MessageL("Server: Client connected successfully from: " + getClientInfo());
            buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            buffWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
            Tools.MessageL("Error: Something went wrong while setting server!");
        }
    }

    private static String getClientInfo() {
        return socket.getInetAddress() + ":" + socket.getPort();
    }

    private static void read() {

    }

    private static void write() {

    }

    public static void main(String[] args) {
        Server.setArgs(args);
        Server.setServer();
    }
}
