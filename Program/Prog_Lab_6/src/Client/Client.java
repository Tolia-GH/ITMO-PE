package Client;


import Collection.Exceptions.NoSuchCommandException;
import Collection.Exceptions.ParaIncorrectException;
import Command.AbstractCommand;
import JSON.Collection.Organization;
import Main.PackageCommand;
import Manager.CommandManager;
import Tools.Tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {
    //args
    private final int port;
    private final String host;
    private String fileName = "Organizations.json";
    private InetSocketAddress inetSocketAddress;
    private SocketChannel socketChannel;
    private Selector selector;
    //ByteArrayOutputStream
    private ObjectInputStream objectReader;
    private ObjectOutputStream objectWriter;


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
        }
        //connect to server
    }

    public void runTerminal() throws IOException {

        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);
        //setting selector to watch if the channel is ready for reading and writing
        ByteBuffer buffer = ByteBuffer.allocate(102400);

        /*boolean print = true;

        int numReadyChannel;
        connect: while ((numReadyChannel = selector.select()) > 0) {
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keySet.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();

                Tools.MessageL("key is Connectable? " + key.isConnectable());
                Tools.MessageL("key is Readable? " + key.isReadable());
                Tools.MessageL("key is Writable? " + key.isWritable());
                Tools.MessageL("key is Acceptable " + key.isAcceptable());

                break connect;
            }
        }*/

        // Original Main

        CommandManager commandManager = new CommandManager();

        Iterator<AbstractCommand> commandIterator;
        int numReadyChannel;
        while (true) {
            numReadyChannel = selector.select();

            if (numReadyChannel > 0) {
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (key.isWritable()) {
                        Tools.MessageL("Client: input your command: ");
                        Tools.Message("User: ");
                        String[] commandWithArgs = Tools.Input().split(" ");

                        PackageCommand packageCommand = packCommand(commandWithArgs, commandManager, fileName);

                    }

                    if (key.isReadable()) {

                    }
                }
            }

            /*AbstractCommand abstractCommand;
            iterator = commandManager.getCommands().iterator();
            //boolean comExist = false;

            Tools.MessageL("Program: Input your command:");
            Tools.Message("User: ");

            try {
                while (iterator.hasNext()) {
                    abstractCommand = iterator.next();
                    if (abstractCommand.getName().equals(command[0])) {
                        //comExist = true;
                        abstractCommand.execute(commandManager, command, "Organizations.json");
                        Tools.Message("\n");
                    }
                }
                if (!commandManager.isCommandExist(command[0])) {
                    throw new NoSuchCommandException("Error: Command [" +command[0] + "] not found!\n");
                }
            } catch (NoSuchCommandException |
                    ParaIncorrectException |
                    NoSuchTypeException |
                    ValueOutOfRangeException |
                    NullValueException |
                    StringLengthOutOfRange |
                    NotInitializedException |
                    IOException exception) {
                Tools.MessageL(exception.getMessage());
            } catch (NumberFormatException numberFormat) {
                Tools.MessageL("Error: Value format error!");
            }*/
        }
    }

    public PackageCommand packCommand(String[] commandWithArgs, CommandManager commandManager, String fileName) {

        AbstractCommand commandToBePacked = commandManager.findCommand(commandWithArgs[0]);
        PackageCommand packageCommand;

        switch (commandToBePacked.getName()) {
            case "add":
            case "add_if_max": {
                if (commandWithArgs.length != 1) {
                    throw new ParaIncorrectException("Error: This command don't accept any parameters!");
                }
                Organization organization = Organization.Create();
                packageCommand = new PackageCommand(commandToBePacked, organization, fileName);
                return packageCommand;
            }
            case "clear": {
                packageCommand = new PackageCommand(commandWithArgs, commandToBePacked, fileName);
                return packageCommand;
            }
            case "execute_script": {

            }
            case "exit": {

            }
            case "filter_less_than_type": {

            }
            case "group_counting_by_id": {

            }
            case "head": {

            }
            case "help": {

            }
            case "info": {

            }
            case "print_field_ascending_annual_turnover": {

            }
            case "remove_by_id": {

            }
            case "remove_head": {

            }
            case "save": {

            }
            case "show": {

            }
            case "update": {

            }
            default: {
                throw new NoSuchCommandException("Error: Command not found!");
            }
        }
    }
}
