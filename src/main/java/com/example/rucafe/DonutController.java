package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DonutController {
    DecimalFormat df = new DecimalFormat("#.##");
    private ObservableList<String> donutsList;
    private ObservableList<String> numbersList;
    private ObservableList<String> yeastFlavors;
    private ObservableList<String> cakeFlavors;
    private ObservableList<String> holeFlavors;
    private RUCafeManager cafeManager;
    private Order order;


    private ArrayList<Donut> donuts;

    @FXML
    private ComboBox<String> donutBox;

    @FXML
    private ComboBox<String> numDonutBox;
    @FXML
    private ListView flavorList;

    @FXML
    private ListView donutDisplay;
    @FXML
    private TextField subTotal;

    public void initialize(){
        donutsList = FXCollections.observableArrayList("Yeast", "Cake", "Donut Holes");
        numbersList = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");

        yeastFlavors = FXCollections.observableArrayList("Glazed", "Chocolate Frosted", "Strawberry Frosted", "Cat Piss", "Pickle Juice", "Spaghetti");
        cakeFlavors = FXCollections.observableArrayList("Old Fashioned", "Chocolate", "Lemon");
        holeFlavors = FXCollections.observableArrayList("Glazed", "Plain", "Ice");

        flavorList.setItems(yeastFlavors);

        donutBox.setItems(donutsList);
        donutBox.getSelectionModel().selectFirst();
        numDonutBox.setItems(numbersList);
        numDonutBox.getSelectionModel().selectFirst();

        cafeManager = RUCafeManager.getInstance();
        order = cafeManager.getOrder();
        donuts = new ArrayList<>();
    }

    public void donutSelection(ActionEvent e){
        switch(donutBox.getSelectionModel().getSelectedItem()){
            case "Yeast":
                flavorList.setItems(yeastFlavors);
                break;
            case "Cake": flavorList.setItems(cakeFlavors);
                break;
            case "Donut Holes": flavorList.setItems(holeFlavors);
                break;
        }
    }

    public void addDonut(ActionEvent e){
        int quantity =  numDonutBox.getSelectionModel().getSelectedIndex() + 1;
        String flavor = (String) flavorList.getSelectionModel().getSelectedItem();
        switch(donutBox.getSelectionModel().getSelectedItem()){
            case "Yeast": donuts.add(new Donut("Yeast",quantity, flavor));
                break;
            case "Cake": donuts.add(new Donut("Cake", quantity, flavor));
                break;
            case "Donut Holes": donuts.add(new Donut("Donut Hole", quantity, flavor));
                break;
        }
        updateDonutList();
        updateSubTotal();
    }

    public void removeDonut(){
        int index = donutDisplay.getSelectionModel().getSelectedIndex();
        donuts.remove(index);
        updateDonutList();
        updateSubTotal();

    }

    public void updateDonutList(){
        donutDisplay.setItems(FXCollections.observableArrayList(donuts));
    }

    public void updateSubTotal(){
        double total = 0;
        for(Donut donut : donuts){
            total += donut.calculatePrice();
        }
        subTotal.setText("$" + df.format(total));
    }

    public void addDonutsToOrder(ActionEvent e){
        for(Donut donut: donuts)
        {
            order.addMenuItem(donut);
        }
        donuts.clear();
        updateDonutList();
        subTotal.clear();
    }
}
