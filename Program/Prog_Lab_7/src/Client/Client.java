package Client;

import Exceptions.AbstractException;
import Main.PackageCommand;
import Main.Request;
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
import java.util.Iterator;

/**
 * The type Client.
 */
public class Client {

    private final int port;
    private final String host;
    private String fileName = "Organizations.json";
    private InetSocketAddress inetSocketAddress;
    private SocketChannel socketChannel;
    private Selector selector;
    private Response response;
    private ClientInformation clientInformation;


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

        runAccount();

        socketChannel.connect(inetSocketAddress);
        Tools.MessageL("Client: Connecting to server: " + host + ":" + port);
        if (socketChannel.finishConnect()) {
            Tools.MessageL("Client: Connect to server successfully!");
            //sendAccountInfo();
            messageToServer("Hello Server!");
        }
        //connect to server
    }

    public void runAccount() {
        Tools.Message("Client: input \"login\" to login, input \"register\" to create a new account: ");
        String choice = Tools.Input();
        if (choice.equalsIgnoreCase("login")||choice.equalsIgnoreCase("register")) {
            Tools.Message("Client: Input username: ");
            String userName = Tools.Input();
            Tools.Message("Client: Input password: ");
            String passWord = Tools.Input();
            clientInformation = new ClientInformation(userName, passWord, !choice.equalsIgnoreCase("login"));
        } else {
            Tools.MessageL("Error: Input error!");
            System.exit(3);
        }
    }

    public void sendAccountInfo() throws IOException {
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);

        objectOut.writeObject(clientInformation);
        objectOut.flush();

        byte[] bytes = byteArrayOut.toByteArray();
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        socketChannel.write(byteBuffer);
    }

    /**
     * Run terminal.
     * Accept commands from User and pack the command and send to server and read the response from server then show in the Terminal
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void runTerminal() throws IOException, ClassNotFoundException {

        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);

        CommandManager commandManager = new CommandManager();

        boolean isClientInfoSent = false;



        int numReadyChannel;
        while (true) {
            numReadyChannel = selector.select();

            if (numReadyChannel > 0) {
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (key.isWritable()) {

                        if (!isClientInfoSent) {

                            Request request = new Request(clientInformation);

                            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
                            ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);

                            objectOut.writeObject(request);
                            objectOut.flush();

                            byte[] bytes = byteArrayOut.toByteArray();
                            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

                            socketChannel.write(byteBuffer);
                            Tools.MessageL("Client: Client information sent!");
                            isClientInfoSent = true;

                            key.interestOps(SelectionKey.OP_READ);
                        } else {
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            //commandManager.executeShow();
                            Tools.MessageL("Client: input your command: ");
                            Tools.Message("User: ");
                            String[] commandWithArgs = Tools.Input().split(" ");

                            try {
                                PackageCommand packageCommand = PackageCommand.packCommand(response,commandWithArgs, commandManager, fileName, clientInformation.getUserName());
                                Request request = new Request(packageCommand);

                                ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
                                ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);

                                objectOut.writeObject(request);
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
                        response = (Response) objectIn.readObject();//Attention Here!
                        Tools.MessageL(response.getResponseMessage());
                        if (response.getResponseMessage().contains("Error")) {
                            System.exit(1);
                        }
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
