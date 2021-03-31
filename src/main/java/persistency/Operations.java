package persistency;

import model.Money;
import model.Transaction;

import java.util.List;

public interface Operations {
    void deposit(String date, Money amount);
    void withdraw(String date, Money amount);
    List<Transaction> getTransactions();
}
