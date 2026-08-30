
import java.math.BigDecimal;

public class WalletPayment extends BasePaymentMethod{
    private BigDecimal walletBalance;

    public WalletPayment(BigDecimal walletBalance){
        super("Wallet");

        if(walletBalance==null || walletBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException(
                "Wallet balance cannot be negative"
            );
        }
        this.walletBalance=walletBalance;
    }
    @Override
    public void pay(Payment payment){
        validateAmount(payment.getAmount());

        if(payment.getAmount().compareTo(walletBalance) > 0){
            payment.markFailed();

            throw new IllegalStateException(
                "Insufficient wallet balance"
            );
        }
        walletBalance=walletBalance.subtract(payment.getAmount());

        payment.markSuccess();
        
        System.out.println("Wallet payment successful:"+payment.getAmount());
    }
    @Override
    public BigDecimal getMaximumLimit(){
        return walletBalance;
    }
    public BigDecimal getWalletBalance(){
        return walletBalance;
    }
    
}
