package Client;

import Exceptions.AbstractException;
import Tools.Tools;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ConnectException;

public class ClientRun extends Application {

    public static Stage stage;

    public static void main(String[] args) {

        //Client client = new Client("localhost",2001);
        try {
            Client.run();
            launch(args);
            //Client.runTerminal();
        } catch (ConnectException e) {
            Tools.MessageL("Error: Server not available!");
        } catch (AbstractException e) {
            Tools.MessageL(e.getMessage());
        } catch (Exception e) {
            Tools.MessageL("Error: Something Wrong!");
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("FXML/AccountUI.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Organizations Manager");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/" + fxmlFile));
        stage.getScene().setRoot(root);
    }
}
