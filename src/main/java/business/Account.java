package business;

import model.Money;
import model.History;

public class Account {
    private History history;

    public Account (History history) {
        this.history = history;
    }

    public Money getBalance() {
        return history.getBalance();
    }

    public void deposit(String date, Money amount) {
        history.deposit(date, amount);
    }

    public void withdraw(String date, Money amount) {
        history.withdraw(date, amount);
    }

    public String getStatement(Statement statement) {
        return statement.print(history);
    }
}
