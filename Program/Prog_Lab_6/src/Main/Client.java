package Main;

import Tools.Tools;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    //args
    static int port = 2001;
    static String ip = "localhost";
    static String filePath;
    //channel
    private static SocketChannel socketChannel;
    //buffer
    static ByteBuffer buffer;
    static int bytesRead;
    static int bytesWrite;

    private static void setArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-f": {//setting file path
                        filePath = args[++i];
                        break;
                    }
                    case "-ip": {//setting ip address
                        ip = args[++i];
                        break;
                    }
                    case "-p": {//setting port
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

    private static void setClient() {
        try {
            InetSocketAddress address = new InetSocketAddress(ip,port);//setting ip address

            socketChannel = SocketChannel.open();//setting channel
            socketChannel.configureBlocking(false);
            Tools.Message("Client: Connecting server at port: " + port + "...");
            Thread.sleep(600L);
            Tools.MessageL("successful!");
            socketChannel.connect(address);//connecting to server
            Thread.sleep(300L);
            Tools.MessageL("Client: Server connected successfully at:");
            Thread.sleep(300L);
            Tools.MessageL("        " + socketChannel.getRemoteAddress());

            buffer = ByteBuffer.allocate(1024);//setting buffer


        } catch (Exception e) {
            Tools.MessageL("Error: Something went wrong when setting client!");
        }
    }

    private static void read() {
        try {
            bytesRead = socketChannel.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        try {
            bytesWrite = socketChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client.setArgs(args);
        Client.setClient();
    }
}
