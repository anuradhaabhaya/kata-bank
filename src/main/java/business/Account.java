package business;

import model.Money;

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

    public void withdraw(Money money) {
        balance.withdraw(money.getAmount());
    }
}
