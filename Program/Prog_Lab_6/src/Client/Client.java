package Client;

import Collection.Organization;
import Exceptions.AbstractException;
import JSON.JsonReader;
import Main.PackageCommand;
import Main.Response;
import Manager.CommandManager;
import Tools.Tools;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * The type Client.
 */
public class Client {

    private final int port;
    private final String host;
    private String fileName;
    private InetSocketAddress inetSocketAddress;
    private SocketChannel socketChannel;
    private Selector selector;
    private Response response;


    /**
     * Instantiates a new Client.
     *
     * @param host the host address
     * @param port the port of address
     */
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Run the client process, set up selector and channel and connect to server
     *
     * @throws IOException the io exception
     */
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

    /**
     * Run terminal.
     * Accept commands from User and pack the command and send to server and read the response from server then show in the Terminal
     *
     * @param isSetFromFile check if the Organization Set is build from file
     * @param filePath      the file path of the Organization Set
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void runTerminal(boolean isSetFromFile, String filePath) throws IOException, ClassNotFoundException {

        this.fileName = filePath;

        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);

        CommandManager commandManager = new CommandManager();

        if (isSetFromFile) {
            ArrayDeque<Organization>set = JsonReader.getCollectionFromFile(filePath);
            if (set == null) {

            } else {
                response = new Response(set,null,set.size());
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

        }

        int numReadyChannel;
        while (true) {
            numReadyChannel = selector.select();

            if (numReadyChannel > 0) {
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (key.isWritable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        //commandManager.executeShow();
                        Tools.MessageL("Client: input your command: ");
                        Tools.Message("User: ");
                        String[] commandWithArgs = Tools.Input().split(" ");

                        try {
                            PackageCommand packageCommand = PackageCommand.packCommand(response,commandWithArgs, commandManager, fileName);

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
                        } catch (AbstractException | FileNotFoundException e) {
                            Tools.MessageL(e.getMessage());
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
                        response = (Response) objectIn.readObject();//Bug Here!
                        Tools.MessageL(response.getResponseMessage());
                        key.interestOps(SelectionKey.OP_WRITE);

                        //Tools.MessageL(String.valueOf(response.getAmountSet()));
                    } else {
                        Tools.MessageL("Error: Key is not ready!");
                    }
                }
            } else {
                Tools.MessageL("Client: No Channel is Ready");
            }
        }
    }

    /**
     * Message to server.
     *
     * @param message message that send to server
     * @throws IOException the io exception
     */
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
}
