package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Class for CoffeeController Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class CoffeeController {
    DecimalFormat df = new DecimalFormat("#.##");
    private ObservableList<String> sizesList;
    private ObservableList<String> quantityList;

    private Coffee coffee;
    Order order;
    @FXML
    private ComboBox<String> coffeeBox;

    @FXML
    private ComboBox<String> numCoffeeBox;

    /**
     * Configures the starting layout of the screen
     */
    @FXML
    private CheckBox sweetCream;
    @FXML
    private CheckBox frenchVanilla;
    @FXML
    private CheckBox irishCream;
    @FXML
    private CheckBox caramel;
    @FXML
    private CheckBox mocha;

    @FXML
    private TextField price;


    public void initialize() {
        sizesList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5");

        coffeeBox.setItems(sizesList);
        coffeeBox.getSelectionModel().selectFirst();
        numCoffeeBox.setItems(quantityList);
        numCoffeeBox.getSelectionModel().selectFirst();

        coffee = new Coffee("Short", 1);
        price.setText(df.format(coffee.calculatePrice()));

        order = RUCafeManager.getInstance().getOrder();
    }

    public void checked(ActionEvent e){
        CheckBox c = (CheckBox) e.getSource();
        String addon = c.getText();
        if(coffee.containsAddOns(addon)){
            coffee.removeAddOn(addon);
        }
        else{
            coffee.addAddOn(addon);

        }
        price.setText(df.format(coffee.calculatePrice()));
    }

    public void sizeChange(ActionEvent e){
        coffee.changeSize(coffeeBox.getSelectionModel().getSelectedItem());
        price.setText(df.format(coffee.calculatePrice()));
    }
    public void quantityChange(){
        coffee.setQuantity(numCoffeeBox.getSelectionModel().getSelectedIndex() + 1);
        price.setText(df.format(coffee.calculatePrice()));
    }
    public void addToOrder(ActionEvent e){
        order.addMenuItem(coffee);
        sweetCream.setSelected(false);
        irishCream.setSelected(false);
        frenchVanilla.setSelected(false);
        mocha.setSelected(false);
        caramel.setSelected(false);
        coffeeBox.getSelectionModel().selectFirst();
        numCoffeeBox.getSelectionModel().selectFirst();
        coffee = new Coffee("Short", 1);
        price.setText(df.format(coffee.calculatePrice()));
    }

}
