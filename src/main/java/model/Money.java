package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal amount;

    public Money(Double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void deposit(BigDecimal amount) {
        this.amount = this.amount.add( amount );
    }

    public void withdraw(BigDecimal amount) {
        this.amount = this.amount.subtract( amount );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Money money = (Money) obj;
        return amount.equals( money.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
