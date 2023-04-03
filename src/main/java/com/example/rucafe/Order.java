package com.example.rucafe;
import javafx.scene.control.Menu;

import java.util.ArrayList;

public class Order {
    private static int orderNumber = 0;
    private ArrayList<MenuItem> orderItems = new ArrayList<>();

    public Order(){
        orderNumber += 1;
    }

    public void addMenuItem(MenuItem item){
        orderItems.add(item);
    }
}
