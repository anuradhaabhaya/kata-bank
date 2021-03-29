import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    @Test
    void bank_account_empty_when_creating_new_account() {
        Account account = new Account();
        Assertions.assertEquals( BigDecimal.valueOf(0.0), account.getAmount());
    }
}
