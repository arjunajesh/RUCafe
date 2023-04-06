package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class for DonutController Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class DonutController {
    DecimalFormat df = new DecimalFormat("#.##");
    private ObservableList<String> donutsList;
    private ObservableList<String> numbersList;
    private ObservableList<String> yeastFlavors;
    private ObservableList<String> cakeFlavors;
    private ObservableList<String> holeFlavors;
    private RUCafeManager cafeManager;
    private Order order;

    Image yeastDonut;
    Image cakeDonut;
    Image donutHole;

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

    @FXML
    private ImageView donutImage;

    /**
     * Configures the starting layout of the screen
     */
    public void initialize(){
        donutsList = FXCollections.observableArrayList("Yeast", "Cake", "Donut Holes");
        numbersList = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");

        yeastFlavors = FXCollections.observableArrayList("Glazed", "Chocolate Frosted", "Strawberry Frosted", "Cat Piss", "Pickle Juice", "Spaghetti");
        cakeFlavors = FXCollections.observableArrayList("Old Fashioned", "Chocolate", "Lemon");
        holeFlavors = FXCollections.observableArrayList("Glazed", "Plain", "Ice");

        yeastDonut = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/rucafe/yeastdonut.jpg")));
        cakeDonut = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/rucafe/cake.jpeg")));
        donutHole = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/rucafe/donutholes.jpeg")));

        donutImage.setImage(yeastDonut);
        flavorList.setItems(yeastFlavors);

        donutBox.setItems(donutsList);
        donutBox.getSelectionModel().selectFirst();
        numDonutBox.setItems(numbersList);
        numDonutBox.getSelectionModel().selectFirst();

        cafeManager = RUCafeManager.getInstance();
        order = cafeManager.getOrder();
        donuts = new ArrayList<>();
    }

    /**
     * Receives the type of donut the user chooses and updates flavorList accordingly
     * @param e allows access to properties of ActionEvent
     */
    public void donutSelection(ActionEvent e){
        switch(donutBox.getSelectionModel().getSelectedItem()){
            case "Yeast":
                flavorList.setItems(yeastFlavors);
                donutImage.setImage(yeastDonut);
                break;
            case "Cake": flavorList.setItems(cakeFlavors);
                donutImage.setImage(cakeDonut);
                break;
            case "Donut Holes": flavorList.setItems(holeFlavors);
                donutImage.setImage(donutHole);
                break;
        }
    }

    /**
     * Adds type and number of donuts the user selects into donut arrayList
     * Updates the donut order display and shown subtotal accordingly
     * @param e allows access to properties of ActionEvent
     */
    public void addDonut(ActionEvent e){
        if(flavorList.getSelectionModel().getSelectedIndex() == -1){
            throwAlert();
            return;
        }
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

    /**
     * Removes the selected donut order from the donuts arrayList
     * Then updates the donut orders display and shown subtotal accordingly
     */
    public void removeDonut(){
        if(donutDisplay.getSelectionModel().getSelectedIndex() == -1){
            throwAlertRemove();
            return;
        }
        int index = donutDisplay.getSelectionModel().getSelectedIndex();
        donuts.remove(index);
        updateDonutList();
        updateSubTotal();

    }

    /**
     * Shows the most updated list of ordered donuts on the donuts arrayList
     */
    public void updateDonutList(){
        donutDisplay.setItems(FXCollections.observableArrayList(donuts));
    }

    /**
     * Calculates and updates the subtotal of the order to the correct amount
     */
    public void updateSubTotal(){
        double total = 0;
        for(Donut donut : donuts){
            total += donut.calculatePrice();
        }
        subTotal.setText("$" + df.format(total));
    }

    /**
     * Adds all donut orders to the order
     * Clears the list of donut orders
     * Clears the previous subtotal
     * @param e allows access to properties of ActionEvent
     */
    public void addDonutsToOrder(ActionEvent e){
        for(Donut donut: donuts)
        {
            order.addMenuItem(donut);
        }
        donuts.clear();
        updateDonutList();
        subTotal.clear();
    }

    /**
     * Shows user an error if a required choice is not specified when adding/removing an item
     */
    public void throwAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("No flavor selected");
        alert.setContentText("Must select a flavor for donut");
        alert.showAndWait();
    }

    public void throwAlertRemove(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("No donut selected");
        alert.setContentText("Must select a donut to remove");
        alert.showAndWait();
    }
}
