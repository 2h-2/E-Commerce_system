
package model;


public class Customer {
    private double balance;
    
    public Customer(double balance) {
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void decreaseBalanse(double amount) throws Exception{
        if(amount<=balance){
            balance -= amount;
        }else{
            throw new Exception("The customer's balance is insufficient. ");
        }
        
    }
    
}
