
package model;

import model.Item;
import model.Product;
import java.util.ArrayList;
import java.util.List;


public class Cart {
    private ArrayList<Item> items;
    List<Shipping> shippableItems ;
    
    public Cart(){
        items = new ArrayList<Item>();
        shippableItems = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
    public List<Shipping> getShippableItems() {
        return shippableItems;
    }
    
 
    public void add(Product product, int productQuantity) throws Exception{
       // Product product = ProductDao.getProductByName(productName);
        
            
            if (product.isExpired()) {
                throw new Exception("Cannot add expired product: " + product.getName());
            }
            
            if (product.getProductNum() < productQuantity){
                throw new Exception("Not enough stock for product: " + product.getName());
            }
           
            for(Item item : items){
                    if(item.getProduct().equals(product)){
                        item.setQuantity(item.getQuantity()+productQuantity);
                        product.setProductNum(product.getProductNum() - productQuantity);
                        return;
                     }
            }
        
            Item item = new Item(product,productQuantity);
            items.add(item);
            product.setProductNum(product.getProductNum() - productQuantity);
 
    }
    
    public void add(ShippableProduct product, int productQuantity) throws Exception {
       // Product product = ProductDao.getProductByName(productName);
        
            
            if (product.isExpired()) {
                throw new Exception("Cannot add expired product: " + product.getName());
            }
            if (product.getProductNum() < productQuantity){
                throw new Exception("Not enough stock for product: " + product.getName());
            }
           
            for(Item item : items){
                    if(item.getProduct().equals(product)){
                        item.setQuantity(item.getQuantity()+productQuantity);
                        
                        for(int i = 0; i < productQuantity; i++){
                            shippableItems.add((Shipping) item.getProduct());
                        }
                        product.setProductNum(product.getProductNum() - productQuantity);
                        return;
                     }
            }
        
            Item item = new Item(product,productQuantity);
            items.add(item);
            for(int i = 0; i < productQuantity; i++){
                shippableItems.add((Shipping) item.getProduct());
            }
            product.setProductNum(product.getProductNum() - productQuantity);            
 
    }
   
    public boolean cartIsEmpty(){
        return items.isEmpty();
    }
    
}
