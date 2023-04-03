package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CoffeeController {

    private ObservableList<String> sizesList;
    private ObservableList<String> quantityList;
    @FXML
    private ComboBox<String> coffeeBox;

    @FXML
    private ComboBox<String> numCoffeeBox;

    public void initialize() {
        sizesList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5");

        coffeeBox.setItems(sizesList);
        numCoffeeBox.setItems(quantityList);
    }
}
