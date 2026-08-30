
import java.math.BigDecimal;

public class BusinessWallet implements Wallet {

    private final String walletId;
    private final String ownerName;
    private BigDecimal balance;

    public BusinessWallet(
            String walletId,
            String ownerName,
            BigDecimal initialBalance) {

        if (initialBalance == null) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be null"
            );
        }

        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative"
            );
        }

        this.walletId = walletId;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(BigDecimal amount) {

        if (amount == null) {
            throw new IllegalArgumentException(
                    "Deposit amount cannot be null"
            );
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be positive"
            );
        }

        balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {

        if (amount == null) {
            throw new IllegalArgumentException(
                    "Withdrawal amount cannot be null"
            );
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be positive"
            );
        }

        BigDecimal minimumBalance =
                new BigDecimal("1000");

        BigDecimal remainingBalance =
                balance.subtract(amount);

        if (remainingBalance.compareTo(minimumBalance) < 0) {
            throw new IllegalStateException(
                    "Minimum balance of 1000 must be maintained"
            );
        }

        balance = remainingBalance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}