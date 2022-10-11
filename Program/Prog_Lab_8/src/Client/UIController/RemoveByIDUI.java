package Client.UIController;

import Exceptions.AbstractException;
import Exceptions.ValueOutOfRangeException;
import Tools.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoveByIDUI {

    @FXML
    private Button clearButton;

    @FXML
    private TextField IDField;

    @FXML
    private Label errorMessage;

    @FXML
    private Button confirmButton;

    @FXML
    void confirm(ActionEvent event) {
        try {
            String IDText = IDField.getText();
            Long id;
            try {
                id = Long.valueOf(IDText);
            } catch (NumberFormatException e) {
                throw new ValueOutOfRangeException("Error: ID format error!");
            }
            String[] commandWithArgs = new String[]{"remove_by_id", id.toString()};
            Tools.handleCommand(commandWithArgs, null);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.hide();
        } catch (AbstractException e) {
            errorMessage.setText(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.toString());
            alert.showAndWait();
        }
    }

    @FXML
    void clear(ActionEvent event) {
        IDField.clear();
    }

}
