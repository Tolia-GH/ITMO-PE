package Client;

import Command.AbstractCommand;
import Exceptions.MyException;
import Exceptions.NoSuchCommandException;
import Exceptions.ParaIncorrectException;
import Collection.Organization;
import JSON.JsonReader;
import Main.PackageCommand;
import Main.Response;
import Manager.CommandManager;
import Manager.OrganizationManager;
import Tools.Tools;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Client {
    //args
    private final int port;
    private final String host;
    private String fileName;
    private InetSocketAddress inetSocketAddress;
    private SocketChannel socketChannel;
    private Selector selector;


    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws IOException {

        selector = Selector.open();

        inetSocketAddress = new InetSocketAddress(host,port);
        //setting ip address
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        //create a non-blocking channel

        socketChannel.connect(inetSocketAddress);
        Tools.MessageL("Client: Connecting to server: " + host + ":" + port);
        if (socketChannel.finishConnect()) {
            Tools.MessageL("Client: Connect to server successfully!");

            messageToServer("Hello Server!");
        }
        //connect to server
    }

    public void runTerminal(boolean isSetFromFile, String filePath) throws IOException, ClassNotFoundException {

        this.fileName = filePath;

        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);

        CommandManager commandManager = new CommandManager();

        if (isSetFromFile) {
            ArrayDeque<Organization>set = JsonReader.getCollectionFromFile(filePath);
            PackageCommand OrganizationSet = new PackageCommand(set);

            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);

            objectOut.writeObject(OrganizationSet);
            objectOut.flush();

            byte[] bytes = byteArrayOut.toByteArray();
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

            socketChannel.write(byteBuffer);
            Tools.MessageL("Client: Organization set from file");
        }

        int numReadyChannel;
        while (true) {
            numReadyChannel = selector.select();

            if (numReadyChannel > 0) {
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    /*System.out.println("is Readable:" + key.isReadable());
                    System.out.println("is Writable:" + key.isWritable());
                    System.out.println("is Acceptable:" + key.isAcceptable());
                    System.out.println("is Connectable:" + key.isConnectable());*/

                    if (key.isWritable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        Tools.MessageL("Client: input your command: ");
                        Tools.Message("User: ");
                        String[] commandWithArgs = Tools.Input().split(" ");

                        try {
                            PackageCommand packageCommand = PackageCommand.packCommand(commandWithArgs, commandManager, fileName);

                            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
                            ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);

                            objectOut.writeObject(packageCommand);
                            objectOut.flush();

                            byte[] bytes = byteArrayOut.toByteArray();
                            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

                            socketChannel.write(byteBuffer);
                            objectOut.close();
                            Tools.MessageL("Client: Command sent!");

                            if (commandWithArgs[0].equalsIgnoreCase("exit")) {
                                System.exit(0);
                            }

                            key.interestOps(SelectionKey.OP_READ);
                        } catch (MyException e) {
                            Tools.MessageL(e.getMessage());
                            continue;
                        }
                    } else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        Tools.MessageL("Client: Receiving response from Server:\n");
                        ByteBuffer byteBuffer = ByteBuffer.allocate(102400);
                        byteBuffer.clear();
                        socketChannel.read(byteBuffer);
                        byteBuffer.flip();
                        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(byteBuffer.array());

                        ObjectInputStream objectIn = new ObjectInputStream(byteArrayIn);//
                        Response response = (Response) objectIn.readObject();//Bug Here!
                        Tools.MessageL(response.getResponseMessage());
                        key.interestOps(SelectionKey.OP_WRITE);
                    } else {

                    }
                }
            } else {
                Tools.MessageL("Client: No Channel is Ready");
            }
        }
    }

    public void  messageToServer(String message) throws IOException {
        ByteBuffer  buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(message.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        while (buffer.hasRemaining()) {
            Tools.MessageL("Client: Saying Hello to Server.");
            socketChannel.write(buffer);
        }
    }

    public void receiveFromServer() {

    }


}
