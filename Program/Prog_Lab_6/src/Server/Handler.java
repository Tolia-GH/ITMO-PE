package Server;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Handler {

    private BufferedReader reader;
    private PrintWriter writer;

    public Handler(BufferedReader bufferedReader,PrintWriter printWriter) {
        this.reader = bufferedReader;
        this.writer = printWriter;
    }

    public void handle() {

    }
}
