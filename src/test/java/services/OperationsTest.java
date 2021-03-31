package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Money;
import persistency.History;
import org.junit.jupiter.api.Test;

public class OperationsTest {

    @Test
    void bank_account_empty_when_creating_new_account() {
        Account account = givenAnAccount();

        assertEquals( expectedBalanceOf(0.0), account.getBalance() );
    }

    @Test
    void balance_is_100_when_deposit_of_100_on_account () {
        Account account = givenAnAccount();

        when_depositing_money( account, "2021-03-30", 100.0 );

        assertEquals( expectedBalanceOf(100.0), account.getBalance() );
    }

    @Test
    void balance_is_123_50_when_successive_deposits_on_account() {
        Account account = givenAnAccount();

        when_depositing_money( account, "2021-03-30", 100.50 );
        when_depositing_money( account, "2021-03-30", 23.0 );

        assertEquals( expectedBalanceOf(123.50), account.getBalance() );
    }

    @Test
    void balance_is_0_when_withdrawal_of_100() {
        Account account = givenAnAccount();

        when_depositing_money( account, "2021-03-30", 100.0 );
        assertEquals( expectedBalanceOf(100.0), account.getBalance() );

        when_withdrawing_money( account, "2021-03-30", 100.0 );
        assertEquals( expectedBalanceOf(0.0), account.getBalance() );
    }

    @Test
    void balance_is_200_when_withdrawal_of_152() {
        Account account = givenAnAccount();

        when_depositing_money( account, "2021-03-30", 352.0 );
        assertEquals( expectedBalanceOf(352.0), account.getBalance() );
        when_withdrawing_money( account, "2021-03-30", 152.0 );
        assertEquals( expectedBalanceOf(200.0), account.getBalance() );
    }

    @Test
    void display_account_history() {
        String expectedStatement = "operation | date | amount | balance" + System.lineSeparator()
                        + "deposit | 2021-03-30 | 200.0 | 200.0" + System.lineSeparator()
                        + "withdrawal | 2021-03-30 | -156.5 | 43.5" + System.lineSeparator();

        Account account = givenAnAccount();

        when_depositing_money( account, "2021-03-30", 200.0 );
        when_withdrawing_money( account, "2021-03-30", 156.50);
        assertEquals( expectedStatement, account.getStatement(new StringStatement()) );
    }

    @Test
    void display_other_account_history_with_different_dates() {
        String expectedStatement = "operation | date | amount | balance" + System.lineSeparator()
                + "deposit | 2019-05-15 | 123.9 | 123.9" + System.lineSeparator()
                + "deposit | 2021-02-01 | 987.46 | 1111.36" + System.lineSeparator()
                + "withdrawal | 2021-03-31 | -456.78 | 654.58" + System.lineSeparator();

        Account account = givenAnAccount();

        when_depositing_money( account, "2019-05-15", 123.90 );
        when_depositing_money( account, "2021-02-01", 987.46 );
        when_withdrawing_money( account, "2021-03-31",  456.78);
        assertEquals( expectedStatement, account.getStatement(new StringStatement()));
    }

    private Account givenAnAccount() {
        return new Account( new History() );
    }

    private void when_depositing_money(Account account, String date, Double amount) {
        account.deposit( date, new Money( amount ) );
    }

    private void when_withdrawing_money(Account account, String date, Double amount) {
        account.withdraw( date, new Money( amount ) );
    }

    private Money expectedBalanceOf(Double amount) {
        return new Money( amount );
    }



}
