import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account () {
        balance = BigDecimal.valueOf( 0 );
    }

    public BigDecimal getAmount() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}
