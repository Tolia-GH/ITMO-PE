package com.example.graphicwork;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainPage {

    @FXML
    private TextField a11;

    @FXML
    private TextField a22;

    @FXML
    private TextField a33;

    @FXML
    private TextField a21;

    @FXML
    private TextField a32;

    @FXML
    private TextField a13;

    @FXML
    private TextField a12;

    @FXML
    private TextField a23;

    @FXML
    private Button buttonRun;

    @FXML
    private Button buttonClear;

    @FXML
    private TextField b1;

    @FXML
    private TextField b2;

    @FXML
    private TextField b3;

    @FXML
    private TextField a31;

    public static Matrix matrix;

    @FXML
    void run(ActionEvent event) {
        try {
            matrix = getMatrix();

            matrix.getResultByGauss();
            System.out.println("Matrix got!");

            Stage stage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResultPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            stage.setTitle("Result");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Exception caught!");
            alert.setContentText("Input numbers only");
            alert.showAndWait();
        }
    }

    @FXML
    void clear() {
        a11.clear(); a12.clear(); a13.clear(); b1.clear();
        a21.clear(); a22.clear(); a23.clear(); b2.clear();
        a31.clear(); a32.clear(); a33.clear(); b3.clear();
    }

    Matrix getMatrix() {

        return new Matrix(
                getElement(a11), getElement(a12), getElement(a13), getElement(b1),
                getElement(a21), getElement(a22), getElement(a23), getElement(b2),
                getElement(a31), getElement(a32), getElement(a33), getElement(b3)
        );
    }

    double getElement(TextField element) {
        if (element.getText().trim().equals("")) {
             return 0L;
        } else {
            return Double.parseDouble(element.getText());
        }
    }
}

