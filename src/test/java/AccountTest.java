import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    // Using a "mock" or dummy displayer to swallow the prints during tests
    Displayer silentDisplayer = new Displayer() {
        @Override
        public void displayDeposit(String owner, double amount, double balance) {
            /* Do nothing */ }

        @Override
        public void displayWithdraw(String owner, double amount, double balance) {
            /* Do nothing */ }
    };

    @Test
    public void testCheckingAccountDeposit() {
        CheckingAccount account = new CheckingAccount("Silas", silentDisplayer);
        account.deposit(5000);
        assertEquals(5000.0, account.getBalance(), "Balance should increase by deposit amount");
    }

    @Test
    public void testCheckingAccountWithdrawSuccess() {
        CheckingAccount account = new CheckingAccount("Silas", silentDisplayer);
        account.deposit(5000);
        account.withdraw(2000);
        assertEquals(3000.0, account.getBalance(), "Withdraw must succeed");
    }

    @Test
    public void testWithdrawExactlyBalance() {
        CheckingAccount account = new CheckingAccount("Silas", silentDisplayer);
        account.deposit(1000);
        account.withdraw(1000); // Should succeed
        assertEquals(0.0, account.getBalance(), "The account remain with balance of 0.0");
    }

    @Test
    public void testDepositNegativeAmount() {
        CheckingAccount account = new CheckingAccount("Silas", silentDisplayer);
        account.deposit(-500); // Should be rejected
        assertEquals(0.0, account.getBalance(), "Balance should not change on invalid deposit");
    }

    @Test
    public void testSavingNegativeAmount() {
        SavingsAccount savingAccount = new SavingsAccount("Silas", silentDisplayer);
        savingAccount.deposit(-500); // Should be rejected
        assertEquals(0.0, savingAccount.getBalance(), "Balance should not change on invalid deposit");
    }

    @Test
    public void testSavingZeroAmount() {
        SavingsAccount savingAccount = new SavingsAccount("Silas", silentDisplayer);
        savingAccount.deposit(0.0); // Should be rejected
        assertEquals(0.0, savingAccount.getBalance(), "Balance should not change on invalid deposit");
    }

    @Test
    public void testWithdrawingMoreAmount() {
        SavingsAccount savingAccount = new SavingsAccount("Silas", silentDisplayer);
        savingAccount.deposit(3000.0);
        savingAccount.withdraw(1000.0); // Should be rejected
        assertEquals(2000.0, savingAccount.getBalance(), "Withdraw amount should not exceed the balance");

    }
}