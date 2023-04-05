package com.example.rucafe;

/**
 * Class for Coffee Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class Coffee extends MenuItem{
    private String size;
    private int quantity;
    private double price;
    private static final double SHORT_PRICE = 1.89;
    private static final double TALL_PRICE = 2.29;
    private static final double GRANDE_PRICE = 2.69;
    private static final double VENTI_PRICE = 3.09;

    public Coffee(String size, int quantity){
        this.size = size;
        this.quantity = quantity;
        switch(size){
            case "Short": price = SHORT_PRICE;
                break;
            case "Tall": price = TALL_PRICE;
                break;
            case "Grande": price = GRANDE_PRICE;
                break;
            case "Venti": price = VENTI_PRICE;
                break;
        }
    }

    @Override
    public double calculatePrice(){
        return 0.0;
    }
}
