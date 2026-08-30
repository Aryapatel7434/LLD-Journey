
import java.math.BigDecimal;

public abstract class BasePaymentMethod implements PaymentMethod{

    private final String methodName;

    protected BasePaymentMethod(String methodName){
        this.methodName=methodName;
    }
    public String getMethodName(){
        return methodName;
    }
    protected void validateAmount(BigDecimal amount){
        if(amount==null || amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(
                "Payment amount must be positive"
            );
        }
        
    }
    @Override
    public void refund(Payment payment){
        if(payment==null){
            throw new IllegalArgumentException(
                "Payment cannot be null"
            );
        }
        payment.markRefunded();
        System.out.println(methodName+"payment refunded:"+payment.getPaymentId());
    }
}
