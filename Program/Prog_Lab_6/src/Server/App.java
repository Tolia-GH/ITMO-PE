package Server;

import Manager.CommandManager;

public class App {

    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        Server server = new Server(2001);
    }
}
