
import java.math.BigDecimal;

interface Wallet {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    BigDecimal getBalance();
}

public class PersonalWallet implements Wallet {

    private final String walletId;
    private final String ownerName;
    private BigDecimal balance;

    public PersonalWallet(
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

        if (amount.compareTo(balance) > 0) {
            throw new IllegalStateException(
                    "Insufficient balance"
            );
        }

        balance = balance.subtract(amount);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}