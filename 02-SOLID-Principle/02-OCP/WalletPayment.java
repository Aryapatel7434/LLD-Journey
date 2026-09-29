public class WalletPayment implements  PaymentMethod{
    @Override 
    public void pay(double amount){
        System.out.println("Processing Walllet Payment:"+amount);
    }
    
}
