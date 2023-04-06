package com.example.rucafe;
import javafx.scene.control.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class for Order Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class Order {
    private static int index = 0;
    private int orderNumber;
    private ArrayList<MenuItem> orderItems = new ArrayList<>();

    private static final double TAX = 0.06625;

    /**
     *
     */
    public Order(){
        index += 1;
        this.orderNumber = index;
    }

    /**
     * Adds item to the orderItems arrayList
     * @param item object to be added
     */
    public void addMenuItem(MenuItem item){
        orderItems.add(item);

    }

    /**
     * @return returns the arrayList that holds order items
     */
    public ArrayList<MenuItem> getOrderItems(){
        return orderItems;
    }

    /**
     * Removes item at given index of orderItems arraylist
     * @param index index of arrayList to be modified
     */
    public void removeMenuItem(int index){
        orderItems.remove(index);
    }

    /**
     * Calculates the total subtotal of the items in order
     * @return returns the subtotal of order items
     */
    public double getSubTotal(){
        Double subTotal = 0.0;
        for(MenuItem item: orderItems){
            subTotal += item.calculatePrice();
        }
        return subTotal;
    }

    /**
     * Calculates the amount of tax of a subtotal
     * @return returns the total tax according to a subtotal
     */
    public double getTax(){
        double subTotal = getSubTotal();
        return subTotal * TAX;
    }

    /**
     * Calculates the total amount due by adding subtotal and tax
     * @return returns the total amount due for an order
     */
    public double getTotalAmount(){
        return getSubTotal() + getTax();
    }

    public int getOrderNumber(){
        return orderNumber;
    }

}
