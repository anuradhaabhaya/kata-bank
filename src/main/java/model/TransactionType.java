package model;

public enum TransactionType {
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal");

    public final String label;

    TransactionType(String label) {
        this.label = label;
    }
}
