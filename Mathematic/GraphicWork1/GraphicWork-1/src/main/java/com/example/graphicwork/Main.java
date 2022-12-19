package com.example.graphicwork;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainPage.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Work1");
        stage.setScene(scene);
        stage.show();
    }
}