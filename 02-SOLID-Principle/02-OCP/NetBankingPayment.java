public class NetBankingPayment implements PaymentMethod{
    @Override 
    public void pay(double amount){
        System.out.println("Processing Net Banking payment:"+amount);
    }
    
}
