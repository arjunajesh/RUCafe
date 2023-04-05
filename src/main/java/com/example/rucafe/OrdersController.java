package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrdersController {

    DecimalFormat df = new DecimalFormat("#.##");
    RUCafeManager cafeManager;
    ArrayList<Order> storeOrders;
    private ObservableList<String> nums;
    @FXML
    private ComboBox orderBox;

    @FXML
    private ListView orderItems;
    @FXML
    private TextField totalAmount;

    public void initialize(){
        cafeManager = RUCafeManager.getInstance();
        storeOrders = cafeManager.getStoreOrders();
        nums= FXCollections.observableArrayList();
        updateOrderBox();
    }

    public void updateOrderBox(){
        nums = FXCollections.observableArrayList();
        for(int i = 0; i < storeOrders.size(); i++){
            nums.add(String.valueOf(i + 1));
        }
        orderBox.setItems(nums);
    }

    public void changeSelectedOrder(ActionEvent e){
        if(orderBox.getSelectionModel().getSelectedIndex() == -1) return;
        Order selectedOrder = storeOrders.get(orderBox.getSelectionModel().getSelectedIndex());
        orderItems.setItems(FXCollections.observableArrayList(selectedOrder.getOrderItems()));
        totalAmount.setText("$" + df.format(selectedOrder.getTotalAmount()));
    }

    public void cancelOrder(ActionEvent e){
        if(orderBox.getSelectionModel().getSelectedIndex() == -1) {
            throwAlert();
            return;
        }
        System.out.println(orderBox.getSelectionModel().getSelectedIndex());
        storeOrders.remove(orderBox.getSelectionModel().getSelectedIndex());
        updateOrderBox();
        orderItems.setItems(FXCollections.observableArrayList());
        totalAmount.setText("");
    }

    public void exportOrders(ActionEvent e){
        try {
            cafeManager.exportOrders();
        }
        catch(IOException er){

        }
    }
    public void throwAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Please select an order");
        alert.setContentText("Must select an order to cancel");
        alert.showAndWait();
    }
}
