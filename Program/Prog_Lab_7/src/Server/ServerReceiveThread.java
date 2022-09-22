package Server;

import Client.ClientInformation;
import Main.PackageCommand;
import Main.Request;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Pack;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerReceiveThread extends Thread {

    private Socket socket;
    private PackageCommand packageCommand;
    private ClientInformation clientInformation;

    public ServerReceiveThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public PackageCommand getPackageCommand() {
        return packageCommand;
    }

    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            Request request = (Request) ois.readObject();

            this.packageCommand = request.getPackageCommand();
            this.clientInformation = request.getClientInformation();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
