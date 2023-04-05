package com.example.rucafe;


import java.text.DecimalFormat;

public class Donut extends MenuItem {


    private String type;
    private String flavor;
    private int quantity;
    private static final double YEAST_PRICE = 1.59;
    private static final double CAKE_PRICE = 1.79;
    private static final double DONUT_HOLE_PRICE = 0.39;

    private double price;

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

    @Override
    public String toString(){
        return flavor + "(" + quantity + ")";
    }

    @Override
    public double calculatePrice(){
        return quantity * price;
    }
}
