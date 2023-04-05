package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

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
    public void initialize(){
        cafeManager = RUCafeManager.getInstance();
        order = cafeManager.getOrder();
        basketView.setItems(FXCollections.observableArrayList(order.getOrderItems()));
        updatePaymentFields();
    }
    public void updatePaymentFields(){
        subTotalField.setText("$" + df.format(order.getSubTotal()));
        taxField.setText("$" + df.format(order.getTax()));
        totalField.setText("$" + df.format(order.getTotalAmount()));
    }

    public void removeSelectedItem(ActionEvent e){
        if(basketView.getSelectionModel().getSelectedIndex() == -1){
            throwAlert();
            return;
        }
        order.removeMenuItem(basketView.getSelectionModel().getSelectedIndex());
        basketView.setItems(FXCollections.observableArrayList(order.getOrderItems()));
        updatePaymentFields();
    }

    public void placeOrder(ActionEvent e){
        cafeManager.addToStoreOrders();
        order = cafeManager.getOrder();
        updatePaymentFields();
        basketView.setItems(FXCollections.observableArrayList(order.getOrderItems()));
    }
    public void throwAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("No Item selected");
        alert.setContentText("Must select an item to remove");
        alert.showAndWait();
    }

}
