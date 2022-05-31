package Client;

import Tools.Tools;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    //args
    static int port = 2001;
    static String ip = "localhost";
    static String filePath;

    //channel
    private SocketChannel socketChannel;
    //buffer
    ByteBuffer buffer;
    int bytesRead;
    int bytesWrite;
    Handler handler;


    public Client(String ip, int port) {
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

            handler = new Handler(socketChannel);
            buffer = ByteBuffer.allocate(1024);//setting buffer


            int i = 0;
            Tools.MessageL("Writing to Server");
            handler.write("I'm " + i++ + "-th information from client");
            handler.write("I'm " + i++ + "-th information from client");
            handler.read();


        } catch (Exception e) {
            e.printStackTrace();
            Tools.MessageL("Error: Something went wrong when setting client!");
        }
    }

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

    private class Handler {
        private SocketChannel socketChannel;
        public Handler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        private void read() {
            try {

                bytesRead = socketChannel.read(buffer);
                buffer.flip();
                String message = new String(buffer.array(), 0, bytesRead);
                System.out.println(message);
                buffer.clear();

            } catch (Exception e) {
                e.printStackTrace();
                Tools.MessageL("Error while reading data!");
            }
        }

        private void write(String message) {
            try {
                buffer.clear();
                buffer.put(message.getBytes());
                //bytesWrite = socketChannel.write(buffer);

                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.println();
                    socketChannel.write(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        setArgs(args);

        Client myClient = new Client(ip,port);

    }
}
