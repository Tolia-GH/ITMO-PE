package com.example.graphicwork;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultPage implements Initializable {

    @FXML
    private Label a1_21;

    @FXML
    private Label a2_12;

    @FXML
    private Label a1_22;

    @FXML
    private Label a2_11;

    @FXML
    private Label a2_33;

    @FXML
    private Label a3_23;

    @FXML
    private Label a2_32;

    @FXML
    private Label a3_22;

    @FXML
    private Label a2_31;

    @FXML
    private Label a3_21;

    @FXML
    private Label equation3;

    @FXML
    private Label result;

    @FXML
    private Label equation2;

    @FXML
    private Label equation1;

    @FXML
    private Label a1_23;

    @FXML
    private Label a2_13;

    @FXML
    private Label a1_32;

    @FXML
    private Label a2_23;

    @FXML
    private Label a3_13;

    @FXML
    private Label a1_11;

    @FXML
    private Label a1_33;

    @FXML
    private Label a2_22;

    @FXML
    private Label a3_12;

    @FXML
    private Label a2_21;

    @FXML
    private Label a3_11;

    @FXML
    private Label a3_33;

    @FXML
    private Label a1_31;

    @FXML
    private Label a3_32;

    @FXML
    private Label a3_31;

    @FXML
    private Label b3_3;

    @FXML
    private Label b2_3;

    @FXML
    private Label b3_2;

    @FXML
    private Label b1_1;

    @FXML
    private Label b1_3;

    @FXML
    private Label b2_2;

    @FXML
    private Label b3_1;

    @FXML
    private Label b1_2;

    @FXML
    private Label b2_1;

    @FXML
    private Label a1_12;

    @FXML
    private Label a1_13;

    String[][] inputMatrix = new String[3][4];
    String[][] firstMatrix = new String[3][4];
    String[][] secondMatrix = new String[3][4];
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setMatrix(inputMatrix, MainPage.matrix.inputMatrix);
        setMatrix(firstMatrix, MainPage.matrix.firstMatrix);
        setMatrix(secondMatrix, MainPage.matrix.secondMatrix);

        printMatrix(inputMatrix);
        printMatrix(firstMatrix);
        printMatrix(secondMatrix);

        equation1.setText(inputMatrix[0][0] + "x" + inputMatrix[0][1] + "y" + inputMatrix[0][2] + "z=" + inputMatrix[0][3]);
        equation2.setText(inputMatrix[1][0] + "x" + inputMatrix[1][1] + "y" + inputMatrix[1][2] + "z=" + inputMatrix[1][3]);
        equation3.setText(inputMatrix[2][0] + "x" + inputMatrix[2][1] + "y" + inputMatrix[2][2] + "z=" + inputMatrix[2][3]);

        //equation1.setAlignment(Pos.CENTER);
        //equation2.setAlignment(Pos.CENTER);
        //equation3.setAlignment(Pos.CENTER);

        a1_11.setText(inputMatrix[0][0]); a1_12.setText(inputMatrix[0][1]); a1_13.setText(inputMatrix[0][2]); b1_1.setText(inputMatrix[0][3]);
        a1_21.setText(inputMatrix[1][0]); a1_22.setText(inputMatrix[1][1]); a1_23.setText(inputMatrix[1][2]); b1_2.setText(inputMatrix[1][3]);
        a1_31.setText(inputMatrix[2][0]); a1_32.setText(inputMatrix[2][1]); a1_33.setText(inputMatrix[2][2]); b1_3.setText(inputMatrix[2][3]);

        a2_11.setText(firstMatrix[0][0]); a2_12.setText(firstMatrix[0][1]); a2_13.setText(firstMatrix[0][2]); b2_1.setText(firstMatrix[0][3]);
        a2_21.setText(firstMatrix[1][0]); a2_22.setText(firstMatrix[1][1]); a2_23.setText(firstMatrix[1][2]); b2_2.setText(firstMatrix[1][3]);
        a2_31.setText(firstMatrix[2][0]); a2_32.setText(firstMatrix[2][1]); a2_33.setText(firstMatrix[2][2]); b2_3.setText(firstMatrix[2][3]);

        a3_11.setText(secondMatrix[0][0]); a3_12.setText(secondMatrix[0][1]); a3_13.setText(secondMatrix[0][2]); b3_1.setText(secondMatrix[0][3]);
        a3_21.setText(secondMatrix[1][0]); a3_22.setText(secondMatrix[1][1]); a3_23.setText(secondMatrix[1][2]); b3_2.setText(secondMatrix[1][3]);
        a3_31.setText(secondMatrix[2][0]); a3_32.setText(secondMatrix[2][1]); a3_33.setText(secondMatrix[2][2]); b3_3.setText(secondMatrix[2][3]);

        result.setText("Result: x=" + String.format("%.2f",MainPage.matrix.getResultX()) +
                ", y=" + String.format("%.2f",MainPage.matrix.getResultY()) +
                ", z=" + String.format("%.2f",MainPage.matrix.getResultZ()));
        //result.setAlignment(Pos.CENTER);
    }

    void setMatrix(String[][] stringMatrix, double[][] doubleMatrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (doubleMatrix[i][j] > 0) {
                    stringMatrix[i][j] = "+" + String.format("%.2f",doubleMatrix[i][j]);
                } else {
                    stringMatrix[i][j] = String.format("%.2f",doubleMatrix[i][j]);
                }
            }
        }
    }

    void printMatrix(String[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
