/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class ShippableProduct extends Product implements Shipping{
    private double weight;
    public ShippableProduct(String name, double price, int productNum, Date expiryDate, double weight) {
        super(name, price, productNum,expiryDate);
        this.weight = weight;
    }
    
    public ShippableProduct(String name, double price,int productNum, double weight) {
        super(name, price, productNum); 
        this.weight = weight;
    }
    
    

    @Override
    public double getWeight() {
        return weight;
    }
}
