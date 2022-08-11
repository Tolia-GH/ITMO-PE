/**
 * 8632
 */

package Server;

import Tools.Tools;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {

    private final int port;
    private ServerSocket serverSocket;
    private BufferedReader readFromClient;
    private PrintWriter writeToClient;

    public Server(int port) {
        this.port = port;
    }

    /**
     * Begins server operation.
     */
    public void run() throws IOException {
        serverSocket = new ServerSocket(port);

        Tools.MessageL("Server: Listening at port: " + port);
        Tools.MessageL("Server: Waiting for client connection...");

        while (true) {
            Service();
        }
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8),true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
    }

    public void Service() throws IOException {
        Socket socket = serverSocket.accept();
        Tools.MessageL("Server: New connection accepted from: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

        readFromClient = getReader(socket);
        writeToClient = getWriter(socket);

        //Handler handler = new Handler(readFromClient,writeToClient);
        String messageRead = null;
        while ((messageRead = readFromClient.readLine()) != null) {

        }
    }
}
