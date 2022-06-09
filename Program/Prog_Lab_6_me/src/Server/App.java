package Server;

public class App {

    private static final int PORT = 8632;
    private static final int CONNECTION_TIMEOUT = 60 * 1000;
    public static void main(String[] args) {
        Server server = new Server(PORT,CONNECTION_TIMEOUT);
        server.setUp();
    }
}
