package com.example.rucafe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class RUCafeManager {
    private Order newOrder;

    private ArrayList<Order> storeOrders;
    private static RUCafeManager instance = null;

    public RUCafeManager(){
        newOrder = new Order();
        storeOrders = new ArrayList<>();
    }
    public static synchronized RUCafeManager getInstance(){
        if(instance == null){
            instance = new RUCafeManager();
        }
        return instance;
    }

    public Order getOrder(){
        return newOrder;
    }
    public void addToStoreOrders(){
        storeOrders.add(newOrder);
        newOrder = new Order();
    }

    public ArrayList<Order> getStoreOrders(){
        return storeOrders;
    }

    public void exportOrders() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt"));
        int count = 1;
        for (Order order: storeOrders){
            writer.write("Order "  + count + "\n");

            for (MenuItem item: order.getOrderItems()){
                writer.write(item.toString() + "\n");
            }
            count++;
        }
        writer.write("\n");
        writer.close();
    }


}
