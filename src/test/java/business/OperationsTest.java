package business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Money;
import model.History;
import org.junit.jupiter.api.Test;

public class OperationsTest {

    @Test
    void bank_account_empty_when_creating_new_account() {
        Account account = new Account(new History());
        Money expectedBalanceOf0 = new Money( 0.0 );

        assertEquals( expectedBalanceOf0, account.getBalance() );
    }

    @Test
    void balance_is_100_when_deposit_of_100_on_account () {
        Account account = new Account(new History());
        Money expectedBalanceOf100 = new Money( 100.0 );

        when_depositing_money( account, 100.0 );

        assertEquals( expectedBalanceOf100, account.getBalance() );
    }

    @Test
    void balance_is_123_50_when_successive_deposits_on_account() {
        Account account = new Account(new History());
        Money expectedBalanceOf222 = new Money( 123.50 );

        when_depositing_money( account, 100.50 );
        when_depositing_money( account, 23.0 );

        assertEquals( expectedBalanceOf222, account.getBalance() );
    }

    @Test
    void balance_is_0_when_withdrawal_of_100() {
        Account account = new Account(new History());

        Money expectedBalanceOf0 = new Money( 0.0 );
        Money expectedBalanceOf100 = new Money( 100.0 );

        when_depositing_money( account, 100.0 );
        assertEquals( expectedBalanceOf100, account.getBalance() );
        when_withdrawing_money( account, 100.0 );
        assertEquals( expectedBalanceOf0, account.getBalance() );
    }

    @Test
    void balance_is_200_when_withdrawal_of_152() {
        Account account = new Account(new History());

        Money expectedBalanceOf352 = new Money( 352.0 );
        Money expectedBalanceOf200 = new Money( 200.0 );

        when_depositing_money( account, 352.0 );
        assertEquals( expectedBalanceOf352, account.getBalance() );
        when_withdrawing_money( account, 152.0 );
        assertEquals( expectedBalanceOf200, account.getBalance() );
    }

    @Test
    void display_account_history() {
        Account account = new Account(new History());

        String expected = "operation | date | amount | balance" + System.lineSeparator()
                        + "deposit | 2021-03-30 | 200.0 | 200.0" + System.lineSeparator()
                        + "withdrawal | 2021-03-30 | -156.5 | 43.5" + System.lineSeparator();

        when_depositing_money( account, 200.0 );
        when_withdrawing_money( account,  156.50);
        assertEquals( expected, account.getStatement(new Statement()) );
    }

    private void when_depositing_money(Account account, Double amount) {
        account.deposit( "2021-03-30", new Money( amount ) );
    }

    private void when_withdrawing_money(Account account, Double amount) {
        account.withdraw( "2021-03-30", new Money( amount ) );
    }



}
