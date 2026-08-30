
import java.math.BigDecimal;

public interface Wallet {

    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);

    BigDecimal getBalance();
}