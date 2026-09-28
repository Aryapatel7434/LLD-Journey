import java.math.BigDecimal;

public class Transaction {

    private final String transactionId;
    private final String userId;
    private final BigDecimal amount;

    private TransactionStatus status;

    public Transaction(
            String transactionId,
            String userId,
            BigDecimal amount
    ) {

        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;

        this.status = TransactionStatus.PENDING;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void markSuccess() {
        status = TransactionStatus.SUCCESS;
    }

    public void markFailed() {
        status = TransactionStatus.FAILED;
    }
}