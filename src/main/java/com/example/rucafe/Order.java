package com.example.rucafe;
import javafx.scene.control.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Order {
    private static int orderNumber = 0;
    private ArrayList<MenuItem> orderItems = new ArrayList<>();

    private static final double TAX = 0.06625;

    public Order(){
        orderNumber += 1;
    }

    public void addMenuItem(MenuItem item){
        orderItems.add(item);
    }
    public ArrayList<MenuItem> getOrderItems(){
        return orderItems;
    }
    public void removeMenuItem(int index){
        orderItems.remove(index);
    }
    public double getSubTotal(){
        Double subTotal = 0.0;
        for(MenuItem item: orderItems){
            subTotal += item.calculatePrice();
        }
        return subTotal;
    }
    public double getTax(){
        double subTotal = getSubTotal();
        return subTotal * TAX;
    }

    public double getTotalAmount(){
        return getSubTotal() + getTax();
    }

}
