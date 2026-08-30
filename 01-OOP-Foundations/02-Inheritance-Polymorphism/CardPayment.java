
import java.math.BigDecimal;

public class CardPayment extends BasePaymentMethod{

    private static final BigDecimal MAX_LIMIT = new BigDecimal("500000");

    public CardPayment(){
        super("Credit Card");
    }
    @Override
    public void pay(Payment Payment){
        validateAmount(Payment.getAmount());

        if(Payment.getAmount().compareTo(MAX_LIMIT) > 0){
            Payment.markFailed();

            throw new IllegalArgumentException(
                "Credit card payment limit is 500000"
            );
        }
        Payment.markSuccess();

        System.out.println("Credit Card payment successful:"+Payment.getAmount());

    }
    @Override
    public BigDecimal getMaximumLimit(){
        return MAX_LIMIT;
    }
    public static String getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }
    
}
