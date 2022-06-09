package Client;


import Collection.Exceptions.ConnectionErrorException;
import Main.Request;
import Main.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    //args
    private int port;
    private String host;
    private String filePath;
    private InetSocketAddress inetSocketAddress;
    private SocketChannel socketChannel;
    private ObjectInputStream objectReader;
    private ObjectOutputStream objectWriter;


    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        try {
            boolean processingStatus = true;
            while (processingStatus) {
                try {
                    connectToServer();
                    processingStatus = processRequest();
                } catch (ConnectionErrorException exception) {
                    if()
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connectToServer() throws IOException {
        try {
            inetSocketAddress = new InetSocketAddress(host,port);
            socketChannel = SocketChannel.open(inetSocketAddress);
            objectReader = new ObjectInputStream(socketChannel.socket().getInputStream());
            objectWriter = new ObjectOutputStream(socketChannel.socket().getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean processRequest() {
        Request requestToServer = null;
        Response serverResponse = null;
        do {
            try {
                requestToServer = serverResponse != null ?

            } catch () {

            }
        } while (!requestToServer.getCommandName().equals("exit"));
        return false;
    }

}
