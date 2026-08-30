
import java.math.BigDecimal;

public class UpiPayment extends BasePaymentMethod{

    private static final BigDecimal MAX_LIMIT = new BigDecimal("100000");

    public UpiPayment(){
        super("UPI");
    }
    @Override
    public void pay(Payment payment){
        validateAmount(payment.getAmount());

        if(payment.getAmount().compareTo(MAX_LIMIT) > 0){
            payment.markFailed();
            throw new IllegalArgumentException(
                "UPI payment limit is 100000"
            );
        }
        payment.markSuccess();

        System.out.println(("UPI payment successful:"+payment.getAmount()));
    }
    @Override
    public BigDecimal getMaximumLimit(){
        return MAX_LIMIT;
    }
    
}
