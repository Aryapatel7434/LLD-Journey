
import java.math.BigDecimal;

public interface PaymentMethod {
    
    void pay(Payment payment);

    void refund(Payment payment);

    BigDecimal getMaximumLimit();
}
