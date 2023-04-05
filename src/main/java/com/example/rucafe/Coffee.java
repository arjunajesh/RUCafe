package com.example.rucafe;

import java.util.ArrayList;

/**
 * Class for Coffee Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class Coffee extends MenuItem{
    private String size;
    private int quantity;
    private double price;

    private ArrayList<String> addOns;
    private static final double SHORT_PRICE = 1.89;
    private static final double TALL_PRICE = 2.29;
    private static final double GRANDE_PRICE = 2.69;
    private static final double VENTI_PRICE = 3.09;
    private static final double PRICE_OF_ADD_ON = 0.30;

    public Coffee(String size, int quantity){
        this.size = size;
        this.quantity = quantity;
        this.addOns = new ArrayList<>();
        switch(size){
            case "Short": this.price = SHORT_PRICE;
                break;
            case "Tall": this.price = TALL_PRICE;
                break;
            case "Grande": this.price = GRANDE_PRICE;
                break;
            case "Venti": this.price = VENTI_PRICE;
                break;
        }
    }

    @Override
    public double calculatePrice(){
        return quantity * (price + addOns.size() * PRICE_OF_ADD_ON);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Coffee " + "(" + quantity + ") " + size);
        if(addOns.size() != 0) {
            s.append(" [");
            for (String addOn : addOns) {
                s.append(addOn + ",");
            }
            s.deleteCharAt(s.length() - 1);
            s.append("]");
        }
        return s.toString();
    }

    public void addAddOn(String addon){
        addOns.add(addon);
    }
    public void removeAddOn(String addon){
        addOns.remove(addon);
    }
    public void changeSize(String size){
        this.size = size;
        switch(size){
            case "Short": this.price = SHORT_PRICE;
                break;
            case "Tall": this.price = TALL_PRICE;
                break;
            case "Grande": this.price = GRANDE_PRICE;
                break;
            case "Venti": this.price = VENTI_PRICE;
                break;
        }
    }
    public boolean containsAddOns(String addon){
        return addOns.contains(addon);
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
