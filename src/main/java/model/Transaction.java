package model;

public class Transaction {
    private final TransactionType type;
    private String date;
    private Money amount;
    private Money balance;

    public Transaction(TransactionType type, String date, Money amount, Money balance) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String getType() {
        return this.type.label;
    }

    public String getDate() {
        return this.date;
    }

    public Money getBalance() {
        return this.balance;
    }

    public String getBalanceString() {
        return this.balance.getAmount().toString();
    }

    public String getAmount() {
        return this.amount.getAmount().toString();
    }
}
