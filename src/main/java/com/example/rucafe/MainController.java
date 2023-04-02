package com.example.rucafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void displayDonutsScreen() {
        Stage donutScene = new Stage();
        BorderPane root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("donut.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500,400);
            donutScene.setScene(scene);
            donutScene.show();
            //DonutController donutController = loader.getController();
            //donutController.setMainController(this);
        }
        catch(IOException e){

        }

    }
}