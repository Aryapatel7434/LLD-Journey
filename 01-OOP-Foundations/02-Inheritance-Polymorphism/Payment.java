
import java.math.BigDecimal;

public class Payment{
    
    private static final String PaymentId = null;
    private final String paymentId;
    private final User user;
    private final BigDecimal amount;

    private PaymentStatus status;//this is Encapsulation concept

    public Payment(
        String paymentId,
        User user,
        BigDecimal amount
    ){
        if(PaymentId==null || paymentId.isBlank()){
            throw new IllegalArgumentException("Payment ID cannot be empty");
        }
        if(user==null){
            throw new IllegalArgumentException(
                "User cannot be null"
            );
        }
        if(amount==null || amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException(
                "Payment amount must be positive"
            );
        }
        this.paymentId=paymentId;
        this.user=user;
        this.amount=amount;
        this.status=PaymentStatus.PENDING;
    }
    public String getPaymentId(){
        return paymentId;
    }
    public User getUser(){
        return user;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public PaymentStatus getStatus(){
        return status;
    }
    public void markSuccess(){
        status=PaymentStatus.SUCCESS;
    }
    public void markFailed(){
        status=PaymentStatus.FAILED;
    }
    //Business Logic Hold 
    public void markRefunded(){
        if(status!=PaymentStatus.SUCCESS){
            throw new IllegalStateException(
                "Only successful payments can be refunded"
            );
        }
        status=PaymentStatus.REFUNDED;
    }


}
