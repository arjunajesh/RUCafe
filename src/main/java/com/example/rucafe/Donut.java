package com.example.rucafe;


import java.text.DecimalFormat;

public class Donut extends MenuItem {


    private String type;
    private String flavor;
    private int quantity;

    private double price;

    public Donut(String type, int quantity, String flavor){
        this.type = type;
        this.quantity = quantity;
        this.flavor = flavor;
        switch(type){
            case "Yeast": price = 1.59; /* MAGIC NUMBERS */
                break;
            case "Cake": price = 1.79;
                break;
            case "Donut Hole": price = 0.39;
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
