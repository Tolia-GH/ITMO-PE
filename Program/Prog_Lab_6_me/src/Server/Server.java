package Server;

import Exceptions.ConnectionErrorException;
import Manager.Manager;
import Tools.Tools;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {

    private int soTimeout;
    private int port;//the port
    private ServerSocket serverSocket;

    public Server(int port, int soTimeout) {
        this.port = port;
    }

    public void setUp() {
        openServerSocket();
        boolean processingStatus = true;
        while (true) {
            try {
                Socket clientSocket = connectToClient();
                processClientRequest();
            } catch (ConnectionErrorException e) {
                Tools.MessageL("Error: Connect to Client failed!");
                break;
            }
        }
    }

    private void openServerSocket() {
        try {
            Tools.MessageL("Server: Setting up Server...");
            serverSocket = new ServerSocket(port);
            Tools.MessageL("Server: Listening to port: " + port);
            //serverSocket.setSoTimeout(soTimeout);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket connectToClient() throws ConnectionErrorException{

        try {
            Socket clientSocket = serverSocket.accept();
            Tools.MessageL("Server: Client connected successful!");
            return clientSocket;
        } catch (SocketTimeoutException e) {
            Tools.MessageL("Error: Time out when waiting for connection");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        throw new ConnectionErrorException();
    }

    private void processClientRequest() {

    }
}
