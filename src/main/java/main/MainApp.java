/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/form-bmi.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("Kalkulator BMI - OOP dan GUI");
        stage.setScene(scene);
        stage.setMinWidth(460);
        stage.setMinHeight(610);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}