
package model;

import java.util.Date;


public class Product {
    private int id;
    private String name;
    private double price;
    private int productNum;
    private Date expiryDate;
    
    public Product(String name, double price, int productNum1, Date expiryDate) {
        this.name = name;
        this.price = price;
        this.productNum = productNum1;
        this.expiryDate = expiryDate;
    }
    
    public Product(String name, double price, int productNum1) {
        this.name = name;
        this.price = price;
        this.productNum = productNum1;
        this.expiryDate = null;
    }

   
    public boolean isExpired() {
        if(expiryDate == null){
            return false;
        }
        return new Date().after(expiryDate);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    
}
