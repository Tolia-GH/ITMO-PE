/**
 * 8632
 */

package Server;

import Tools.Tools;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {

    String filePath;
    int port = 2022;
    Handler handler;

    byte[] buffer = new byte[1024];
    int messageSize = 0;
    InputStream input;
    OutputStream output;
    BufferedReader reader;
    BufferedWriter writer;

    private void setArgs(String[] args) {
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

    public Server(int port) {
        try {
            Tools.Message("Server: Creating ServerSocket...");
            ServerSocket serverSocket = new ServerSocket(port);//new ServerSocket;
            Tools.MessageL("successful!");
            Tools.MessageL("Server: Server Socket created at port: " + serverSocket.getLocalPort());
            Tools.MessageL("Server: Waiting for client connection...");
            Socket socket = serverSocket.accept();

            handler = new Handler(socket);
            SocketAddress clientAddress = socket.getRemoteSocketAddress();
            Tools.MessageL("Server: Client connected successfully from: " + handler.getClientInfo());
            input = socket.getInputStream();
            output = socket.getOutputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            writer = new BufferedWriter(new OutputStreamWriter(output));
            handler.read();
            handler.read();

            int i = 0;
            Tools.MessageL("Writing to Client");
            handler.write("I'm " + i++ + "-th information from server");


            //Socket socket = serverSocket.accept();//new Socket


            //handler = new Handler(socket);



            while (true) {

            }

        } catch (Exception e) {
            Tools.MessageL("Error: Something went wrong while setting server!");
            e.printStackTrace();
        }
    }

    private class Handler {
        final private Socket socket;

        public Handler(Socket client) {
            socket = client;
        }

        private String getClientInfo() {
            return socket.getInetAddress() + ":" + socket.getPort();
        }

        private void read() {
            try {
                String message = reader.readLine();
                Tools.MessageL("Message from Client:" + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void write(String message) {
            try {
                writer.write(message);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
                Tools.MessageL("Error while writing data!");
            }
        }
    }
}
