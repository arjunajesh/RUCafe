package com.example.rucafe;

class RUCafeManager {
    private Order newOrder;
    private static RUCafeManager instance = null;

    public RUCafeManager(){
        newOrder = new Order();
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


}
