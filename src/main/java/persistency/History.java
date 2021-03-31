package persistency;

import model.Money;
import model.Transaction;
import model.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class History implements Operations {
    private List<Transaction> transactions;

    public History() {
        transactions = new ArrayList<>();
    }

    public void deposit(String date, Money amount) {
        transactions.add( new Transaction( TransactionType.DEPOSIT, date, amount, getUpdatedBalance(amount) ) );
    }

    public void withdraw(String date, Money amount) {
        transactions.add( new Transaction( TransactionType.WITHDRAWAL, date, amount.negate(), getUpdatedBalance(amount.negate()) ) );
    }

    public Money getBalance() {
        if (transactions.isEmpty()) { return new Money (0.0); }
        return getLastTransactionBalance();
    }

    private Money getLastTransactionBalance() {
        Transaction lastTransaction = transactions.get( transactions.size()-1 );
        return lastTransaction.getBalance();
    }

    private Money getUpdatedBalance(Money amount) {
        return getBalance().add(amount);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
