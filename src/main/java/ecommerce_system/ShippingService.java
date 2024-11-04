
package ecommerce_system;

import java.util.List;
import model.Shipping;


public class ShippingService {
    
    public double getTotalWeight(List<Shipping> items) {
        
        double totalWeight = 0.0;
        
        for (Shipping item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight/1000;
    }
}
