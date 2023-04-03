package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;

public class DonutController {

    private ObservableList<String> donutsList;
    private ObservableList<String> numbersList;

    @FXML
    private ComboBox<String> donutBox;

    @FXML
    private ComboBox<String> numDonutBox;

    public void initialize(){
        donutsList = FXCollections.observableArrayList("Yeast", "Cake", "Donut Holes");
        numbersList = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");

        donutBox.setItems(donutsList);
        numDonutBox.setItems(numbersList);
    }
}
