package com.example.rucafe;

/**
 * Abstract Class for Donut and Coffee Classes
 * Allows donuts and coffees to be held in the same container
 * @author Arjun Ajesh
 */
public abstract class MenuItem {

    /**
     * Calculates the prices of a given order
     * @return returns the appropriate price of ordered item(s)
     */
    public abstract double calculatePrice();

}
