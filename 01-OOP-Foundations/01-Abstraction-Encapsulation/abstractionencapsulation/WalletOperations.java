
import java.math.BigDecimal;

public interface WalletOperations {

    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);

    BigDecimal getBalance();
}