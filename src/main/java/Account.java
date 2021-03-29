
public class Account {
    private Money balance;

    public Account () {
        balance = new Money( 0.0 );
    }

    public Money getBalance() {
        return balance;
    }

    public void deposit(Money money) {
        balance.deposit(money.getAmount());
    }
}
