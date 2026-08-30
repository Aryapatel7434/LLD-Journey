import java.math.BigDecimal;

public class Payment {

    // Encapsulated state
    private final String paymentId;
    private final User user;
    private final BigDecimal amount;

    private PaymentStatus status;

    public Payment(
            String paymentId,
            User user,
            BigDecimal amount
    ) {

        // Validate payment ID
        if (paymentId == null || paymentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Payment ID cannot be empty"
            );
        }

        // Validate user
        if (user == null) {
            throw new IllegalArgumentException(
                    "User cannot be null"
            );
        }

        // Validate amount
        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "Payment amount must be positive"
            );
        }

        // Initialize object state
        this.paymentId = paymentId;
        this.user = user;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void markSuccess() {
        status = PaymentStatus.SUCCESS;
    }

    public void markFailed() {
        status = PaymentStatus.FAILED;
    }

    // Business rule
    public void markRefunded() {

        if (status != PaymentStatus.SUCCESS) {
            throw new IllegalStateException(
                    "Only successful payments can be refunded"
            );
        }

        status = PaymentStatus.REFUNDED;
    }
}