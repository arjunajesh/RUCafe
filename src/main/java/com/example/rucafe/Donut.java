package com.example.rucafe;


import java.text.DecimalFormat;

/**
 * Class for Donut Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class Donut extends MenuItem {

    private String type;
    private String flavor;
    private int quantity;
    private static final double YEAST_PRICE = 1.59;
    private static final double CAKE_PRICE = 1.79;
    private static final double DONUT_HOLE_PRICE = 0.39;

    private double price;

    /**
     * Constructor for Donut Class
     * @param type type of donut
     * @param quantity number of desired donuts
     * @param flavor flavor of said donut
     */
    public Donut(String type, int quantity, String flavor){
        this.type = type;
        this.quantity = quantity;
        this.flavor = flavor;
        switch(type){
            case "Yeast": price = YEAST_PRICE;
                break;
            case "Cake": price = CAKE_PRICE;
                break;
            case "Donut Hole": price = DONUT_HOLE_PRICE;
                break;
        }
    }

    /**
     * @return returns flavor and quantity formatted as a string
     */
    @Override
    public String toString(){
        return flavor + "(" + quantity + ")";
    }

    /**
     * @return returns the calculated price of the order
     */
    @Override
    public double calculatePrice(){
        return quantity * price;
    }
}
