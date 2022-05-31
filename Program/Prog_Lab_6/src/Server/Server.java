/**
 * 8632
 */

package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private int port;
    private ServerSocket serverSocket;



    public Server(int port) {
        this.port = port;
    }

    /**
     * Begins server operation.
     */
    public void run() {
        try {
            openServerSocket();
            while (true) {
                try {
                    Socket clientSocket = connectToClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket connectToClient() throws IOException {

        Socket clientSocket = serverSocket.accept();
        return clientSocket;

    }
}
