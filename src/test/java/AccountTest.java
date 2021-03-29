import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class AccountTest {

    @Test
    void bank_account_empty_when_creating_new_account() {
        Account account = new Account();
        assertEquals(BigDecimal.valueOf(0), account.getAmount());
    }

    @Test
    void ini () {
        Account account = new Account();
        account.deposit(BigDecimal.valueOf( 100 ));
        assertEquals(BigDecimal.valueOf(100), account.getAmount());
    }
}
