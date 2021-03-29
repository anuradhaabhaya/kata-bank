import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void bank_account_empty_when_creating_new_account() {
        Account account = new Account();
        Money expectedBalanceOf0 = new Money( 0.0 );

        assertEquals( expectedBalanceOf0, account.getBalance() );
    }

    @Test
    void balance_is_100_when_deposit_of_100_on_account () {
        Account account = new Account();
        Money expectedBalanceOf100 = new Money( 100.0 );

        account.deposit( new Money( 100.0 ) );

        assertEquals( expectedBalanceOf100, account.getBalance() );
    }

    @Test
    void balance_is_123_50_when_successive_deposits_on_account() {
        Account account = new Account();
        Money expectedBalanceOf222 = new Money( 123.50 );

        account.deposit( new Money(100.50) );
        account.deposit( new Money( 23.0 ) );

        assertEquals( expectedBalanceOf222, account.getBalance() );
    }
}
