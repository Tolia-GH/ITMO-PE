package Client;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Client {
    //args
    private int port = 2001;
    private String ip = "localhost";
    private String filePath;
    private InetSocketAddress inetSocketAddress;
    private SocketChannel socketChannel;
    private ObjectInputStream objectReader;
    private ObjectOutputStream objectWriter;


    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void run() {
        try {
            boolean processingStatus = true;
            while (processingStatus) {
                try {
                    connectToServer();
                    processingStatus = processingStatus;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connectToServer() throws IOException {
        try {
            inetSocketAddress = new InetSocketAddress(ip,port);
            socketChannel = SocketChannel.open(inetSocketAddress);
            objectReader = new ObjectInputStream(socketChannel.socket().getInputStream());
            objectWriter = new ObjectOutputStream(socketChannel.socket().getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean processRequest() {
        return false;
    }

}
