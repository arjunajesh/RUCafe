package com.example.rucafe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for RUCafeManager Object
 * @author Arjun Ajesh, Nathan Roh
 */
class RUCafeManager {
    private Order newOrder;

    private ArrayList<Order> storeOrders;
    private static RUCafeManager instance = null;

    /**
     * Constructor for RUCafeManager Object
     */
    public RUCafeManager(){
        newOrder = new Order();
        storeOrders = new ArrayList<>();
    }

    /**
     * Creates a singleton instance of the RUCafeManager
     * @return returns said instance
     */
    public static synchronized RUCafeManager getInstance(){
        if(instance == null){
            instance = new RUCafeManager();
        }
        return instance;
    }

    /**
     *
     * @return
     */
    public Order getOrder(){
        return newOrder;
    }

    /**
     *
     */
    public void addToStoreOrders(){
        storeOrders.add(newOrder);
        newOrder = new Order();
    }

    /**
     *
     * @return
     */
    public ArrayList<Order> getStoreOrders(){
        return storeOrders;
    }

    /**
     * Prints all the placed orders to a text file
     * @throws IOException
     */
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
