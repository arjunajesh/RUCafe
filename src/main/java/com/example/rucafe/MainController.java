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

    public void initialize(){

    }
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
        }
        catch(IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading donut.fxml.");
            alert.setContentText("Couldn't load donut.fxml.");
            alert.showAndWait();

        }

    }
    @FXML
    protected void displayCoffeeScreen(){
        Stage coffeeScene = new Stage();
        BorderPane root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("coffee.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            coffeeScene.setScene(scene);
            coffeeScene.show();
        }
        catch(IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading coffee.fxml.");
            alert.setContentText("Couldn't load coffee.fxml.");
            alert.showAndWait();
        }
    }
    @FXML
    protected void displayBasketScreen(){
        Stage basketScene = new Stage();
        BorderPane root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("basket.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            basketScene.setScene(scene);
            basketScene.show();
        }
        catch(IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading basket.fxml.");
            alert.setContentText("Couldn't load basket.fxml.");
            alert.showAndWait();
        }
    }
    @FXML
    protected void displayOrderScreen(){
        Stage ordersScene = new Stage();
        BorderPane root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orders.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            ordersScene.setScene(scene);
            ordersScene.show();
        }
        catch(IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading orders.fxml.");
            alert.setContentText("Couldn't load orders.fxml.");
            alert.showAndWait();
        }
    }

}