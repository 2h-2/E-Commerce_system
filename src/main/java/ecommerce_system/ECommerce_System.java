

package ecommerce_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.Cart;
import model.Customer;
import model.Item;
import model.Product;
import model.ShippableProduct;
import model.Shipping;


public class ECommerce_System {
    
    
    
    public static void checkout(Cart cart, Customer customer) throws Exception{
        ShippingService shippingService = new ShippingService();
        ArrayList<Item> items = cart.getItems();
        List<Shipping> shippableItems = cart.getShippableItems();
        double totalWeight = shippingService.getTotalWeight(shippableItems);
        double Subtotal = 0.0;
        int Shipping = 0;
        double Amount = 0.0;
        
        if(cart.cartIsEmpty()){
            System.out.println("Cart is empty.");
        }else{
            System.out.println("** Shipment notice **");
            for(Item item : items) {
                double productWeight = 0.0;
                Iterator<Shipping> iterator = shippableItems.iterator();
                while (iterator.hasNext()){
                    Shipping itemSh = iterator.next();
                if(item.getProduct().getName().equals(itemSh.getName())){
                     productWeight = itemSh.getWeight(); 
                    
                }}
                if (shippableItems.contains(item.getProduct())) {
                   System.out.println(item.getQuantity()+"x " + item.getProduct().getName() + "\t" + (productWeight*item.getQuantity())+ "g");
                } 
                
                
            }
            System.out.println("Total package weight "+totalWeight+"kg");
            System.out.println("\n");
            System.out.println("** Checkout receipt **");
            for(Item item : items) {
            System.out.println(item.getQuantity()+"x " + item.getProduct().getName() + "\t" + (item.getProduct().getPrice()*item.getQuantity()));
            Subtotal += item.getProduct().getPrice()*item.getQuantity();
            }
            
            Shipping =  (int) Math.ceil(27.27*totalWeight);
            Amount = Subtotal + Shipping; 
            customer.decreaseBalanse(Amount);
            
                System.out.println("----------------------");
                System.out.println("Subtotal \t"+Subtotal);
                System.out.println("Shipping \t"+Shipping);
                System.out.println("Amount   \t"+Amount);
                System.out.println("Customer's current balance   \t"+customer.getBalance()+"\n");
                System.out.println("**************************************************************************************************************\n");
           
        }
     
    }
   
    public static void main(String[] args) throws Exception {
        
        ShippableProduct Cheese = new ShippableProduct("Cheese",100,5,new Date(System.currentTimeMillis() + 86400000),200);
        ShippableProduct Biscuits = new ShippableProduct("Biscuits",150,9,new Date(System.currentTimeMillis() + 86400000),700);
        ShippableProduct Chocolate = new ShippableProduct("Chocolate",80,8,new Date(System.currentTimeMillis() - 86400000),250);

        
        ShippableProduct TV = new ShippableProduct("TV",100,8,700);
        Product scratchCard = new Product("scratchCard",50,3);
        
        Customer customer1 = new Customer(100);
        Customer customer2 = new Customer(5000);
        Customer customer3 = new Customer(1000);
        
        
        // Test1
       
        Cart cart1 = new Cart();
        cart1.add(Biscuits, 1);
        cart1.add(Cheese, 2);
        
        // In the case of the customer1, an exception error will occur: The customer's balance is insufficient.
       //like this ---> checkout(cart,customer1);
       checkout(cart1,customer2);
       
       
        
              
       //***************************************************************************************************************
        // Test2
        
        Cart cart2 = new Cart();
        cart2.add(TV, 3);
        cart2.add(scratchCard, 1);
        
        checkout(cart2,customer3);
    
    
    
       //***************************************************************************************************************
       // Test3
        
        Cart cart3 = new Cart();
        
        // In the case , Chocolate is Expired.
        // an exception error -> (Cannot add expired product: Chocolate)
        //cart3.add(Chocolate, 4);
        //checkout(cart3,customer3);
    
    
    }
}
