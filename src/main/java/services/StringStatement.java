package services;

import persistency.Operations;
import model.Transaction;


public class StringStatement implements Printable {

    public String print(Operations operations) {
        StringBuilder statement = new StringBuilder();
        statement.append( printHeader() );
        statement.append(System.lineSeparator());

        for (Transaction transaction: operations.getTransactions()) {
            statement.append(printLine(transaction));
            statement.append(System.lineSeparator());
        }
        return statement.toString();
    }

    private String printHeader() {
        return "operation | date | amount | balance";
    }

    private String printLine(Transaction transaction) {
        String type = transaction.getType();
        String date = transaction.getDate();
        String amount = transaction.getAmount();
        String balance = transaction.getBalanceString();
        return type + " | " + date + " | " + amount + " | " + balance;
    }
}
