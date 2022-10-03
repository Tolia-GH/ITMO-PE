

import com.sun.corba.se.impl.orbutil.HexOutputStream;

import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Locale locale = new Locale("it_IT");
        ResourceBundle bundle = ResourceBundle.getBundle("hello", locale);
        String hello = bundle.getString("hello");
        String world = bundle.getString("world");
        System. out. println(hello + " " + world);
    }

    public void method() {
        Consumer<Integer> supplier = (Integer i) -> i.toString();
    }
}
