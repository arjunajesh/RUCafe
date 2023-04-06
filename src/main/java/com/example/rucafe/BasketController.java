package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

/**
 * Class for BasketController Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class BasketController {

    DecimalFormat df = new DecimalFormat("#.##");
    Order order;
    RUCafeManager cafeManager;
    @FXML
    private TextField subTotalField;

    @FXML
    private TextField taxField;

    @FXML
    private TextField totalField;

    @FXML
    private ListView basketView;

    /**
     * Configures the starting layout of the screen
     */
    public void initialize(){

        cafeManager = RUCafeManager.getInstance();
        order = cafeManager.getOrder();
        basketView.setItems(FXCollections.observableArrayList(order.getOrderItems()));
        updatePaymentFields();

    }

    /**
     * Updates payment fields according to user's choices
     */
    public void updatePaymentFields(){
        subTotalField.setText("$" + df.format(order.getSubTotal()));
        taxField.setText("$" + df.format(order.getTax()));
        totalField.setText("$" + df.format(order.getTotalAmount()));
    }

    /**
     * Removes a selected item from the basket
     * @param e allows access to properties of ActionEvent
     */
    public void removeSelectedItem(ActionEvent e){
        if(basketView.getSelectionModel().getSelectedIndex() == -1){
            throwAlert();
            return;
        }
        order.removeMenuItem(basketView.getSelectionModel().getSelectedIndex());
        basketView.setItems(FXCollections.observableArrayList(order.getOrderItems()));
        updatePaymentFields();
    }

    /**
     * Places a user's order and updates appropriate payment fields
     * @param e allows access to properties of ActionEvent
     */
    public void placeOrder(ActionEvent e){
        cafeManager.addToStoreOrders();
        order = cafeManager.getOrder();
        updatePaymentFields();
        basketView.setItems(FXCollections.observableArrayList(order.getOrderItems()));
    }

    /**
     * Shows user an error if a required choice is not specified when adding/removing an item
     */
    public void throwAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("No Item selected");
        alert.setContentText("Must select an item to remove");
        alert.showAndWait();
    }

}
