package Server;

import Tools.Tools;

import java.io.IOException;
import java.net.Socket;

public class ServerSendThread extends Thread{

    private Object object;
    private Socket socket;

    public ServerSendThread(Object object, Socket socket) {
        this.object = object;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Tools.sendObject(object,socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
