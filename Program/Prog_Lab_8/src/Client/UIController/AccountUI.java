package Client.UIController;

import Client.Client;
import Client.ClientInformation;
import Client.ClientRun;
import Main.Request;
import Main.Response;
import Manager.CommandManager;
import Tools.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

public class AccountUI {

    @FXML
    private TextField usernameField;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorMassage;

    @FXML
    private PasswordField passwordField;

    @FXML
    void login(ActionEvent event) {
        String userName = usernameField.getText();
        String password = passwordField.getText();

        ClientInformation clientInformation = new ClientInformation(userName, password, false);
        Client.clientInformation = clientInformation;

        if (userName.equals("") || password.equals("")) {
            errorMassage.setText("Error: Username or Password is empty!");
        } else {
            checkUser(clientInformation);
        }
    }

    private void checkUser(ClientInformation clientInformation) {
        try {
            Client.socketChannel.register(Client.selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);

            CommandManager commandManager = new CommandManager();

            int numReadyChannel;
            loop: while (true) {
                numReadyChannel = Client.selector.select();

                if (numReadyChannel > 0) {
                    Iterator<SelectionKey> keyIterator = Client.selector.selectedKeys().iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();
                        keyIterator.remove();

                        if (key.isWritable()) {
                            Request request = new Request(clientInformation);

                            Tools.sendObject(request,Client.socketChannel);

                            key.interestOps(SelectionKey.OP_READ);
                        }
                        if (key.isReadable()) {
                            Client.response = (Response) Tools.readObject(key);//Attention Here!

                            if (Client.response.getResponseMessage().contains("Error")) {
                                errorMassage.setText(Client.response.getResponseMessage());
                                return;
                            } else if (Client.response.getResponseMessage().contains("Welcome")) {
                                errorMassage.setText(Client.response.getResponseMessage());
                                ResourceBundle bundle = ResourceBundle.getBundle("Client/FXML/labels",ClientRun.locale);
                                Parent root = FXMLLoader.load(getClass().getResource("../FXML/ManagerUI.fxml"),bundle);
                                ClientRun.stage.setScene(new Scene(root, 1280, 800));
                                ClientRun.stage.show();


                                return;
                            } else {
                                errorMassage.setText("Something wrong!");
                                return;
                            }
                        }
                    }
                }
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void register(ActionEvent event) {
        String userName = usernameField.getText();
        String password = passwordField.getText();

        ClientInformation clientInformation = new ClientInformation(userName, password, true);
        Client.clientInformation = clientInformation;

        checkUser(clientInformation);
    }

    @FXML
    void setRu(ActionEvent event) throws IOException {
        ClientRun.locale = new Locale("ru", "RU");

        ResourceBundle bundle = ResourceBundle.getBundle("Client/FXML/labels", ClientRun.locale);
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/AccountUI.fxml"),bundle);
        //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //stage.hide();
        ClientRun.stage.setScene(new Scene(root));
        ClientRun.stage.show();
    }

    @FXML
    void setEt(ActionEvent event) throws IOException {
        ClientRun.locale = new Locale("et", "EE");

        ResourceBundle bundle = ResourceBundle.getBundle("Client/FXML/labels", ClientRun.locale);
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/AccountUI.fxml"),bundle);
        //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //stage.hide();
        ClientRun.stage.setScene(new Scene(root));
        ClientRun.stage.show();
    }

    @FXML
    void setHr(ActionEvent event) throws IOException {
        ClientRun.locale = new Locale("en", "US");

        ResourceBundle bundle = ResourceBundle.getBundle("Client/FXML/labels", ClientRun.locale);
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/AccountUI.fxml"),bundle);
        //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //stage.hide();
        ClientRun.stage.setScene(new Scene(root));
        ClientRun.stage.show();
    }

    @FXML
    void setEs(ActionEvent event) throws IOException {
        ClientRun.locale = new Locale("es", "CO");

        ResourceBundle bundle = ResourceBundle.getBundle("Client/FXML/labels", ClientRun.locale);
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/AccountUI.fxml"),bundle);
        //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //stage.hide();
        ClientRun.stage.setScene(new Scene(root));
        ClientRun.stage.show();
    }
}

