
import java.math.BigDecimal;

public class PaymentDemo {
        private static final Payment CardPayment = null;

        public static void main(String[]args) throws IllegalAccessException{
            User user=new User("U101", "Arya");
            Payment upiPayment=new Payment("P101", user, new BigDecimal("5000"));
            PaymentMethod upi=new UpiPayment();

            upi.pay(upiPayment);

            System.out.println("UPI Status:"+upiPayment.getStatus());

            PaymentMethod card = new CardPayment();

            card.pay(CardPayment);

            System.out.println("Card Status:"+CardPayment.getStatus());

            Payment walletPayment=new Payment("P103", user,new BigDecimal("3000"));

            PaymentMethod wallet=new WalletPayment(new BigDecimal("10000"));

            wallet.pay(walletPayment);

            System.out.println("Wallet Status:"+walletPayment.getStatus());

            System.out.println("Remaining Wallet Balance:"+((WalletPayment)wallet).getWalletBalance());

            Payment cardPayment = null;
            card.refund(cardPayment);

            System.out.println("Card Status After Refund:"+cardPayment.getStatus());

            try{
                Payment largPayment=new Payment("P104", user, new BigDecimal("200000"));
                upi.pay(largPayment);
            }
            catch(IllegalArgumentException e){
                System.out.println("Payment Rejected: "+e.getMessage());
            }
            
        }
}
