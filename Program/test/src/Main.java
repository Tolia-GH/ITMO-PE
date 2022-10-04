

import com.sun.corba.se.impl.orbutil.HexOutputStream;

import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(0,4);
        list.add(1);
        list.remove(3);

    }

    public void method() {

        JFrame widget = new JFrame("The Phantom Menace");
        widget.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
            }
        });
        Function<String, Integer> function = (String s) -> s.length();

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(0,4);
        list.add(1);
        list.remove(3);

        Stream.of("ir", "cri", "arcr","ics")
                .limit(3)
                .sorted()
                .forEachOrdered(System.out::print);
    }


}
