package com.example.rucafe;

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


}
