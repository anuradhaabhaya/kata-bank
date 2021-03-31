package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal amount;

    public Money(Double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }
    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
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

    public Money negate() {
        return new Money (this.amount.negate());
    }

    public Money add(Money amount) {
        return new Money(this.amount.add( amount.getAmount() ));
    }
}
