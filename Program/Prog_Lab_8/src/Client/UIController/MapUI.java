package Client.UIController;

import Client.Client;
import Client.ClientRun;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MapUI {

    @FXML
    private Label usernameField;

    @FXML
    private Button exitButton;

    @FXML
    private Button tableButton;

    @FXML
    private Canvas mapCanvas;

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void table(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/ManagerUI.fxml"));
            //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            //stage.hide();
            ClientRun.stage.setScene(new Scene(root,1280,800));
            ClientRun.stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
