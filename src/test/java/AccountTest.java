import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTest {

    // Create a Mockito instead of manual class
    Displayer mockDisplayer = mock(Displayer.class);

    @Test
    public void testCheckingAccountDeposit() {
        CheckingAccount account = new CheckingAccount("Silas", mockDisplayer);
        account.deposit(5000);

        // Verify state
        assertEquals(5000.0, account.getBalance(), "Balance should increase by deposit amount");

        // Verify interaction
        verify(mockDisplayer).displayDeposit("Silas", 5000.0, 5000.0);
    }

    @Test
    public void testCheckingAccountWithdrawSuccess() {
        CheckingAccount account = new CheckingAccount("Silas", mockDisplayer);
        account.deposit(5000);
        account.withdraw(2000);
        assertEquals(3000.0, account.getBalance(), "Withdraw must succeed");
        verify(mockDisplayer).displayWithdraw("Silas", 2000, 3000);
    }

    @Test
    public void testWithdrawExactlyBalance() {
        CheckingAccount account = new CheckingAccount("Silas", mockDisplayer);
        account.deposit(1000);
        account.withdraw(1000); // Should succeed
        assertEquals(0.0, account.getBalance(), "The account remain with balance of 0.0");
        verify(mockDisplayer).displayWithdraw("Silas", 1000.0, 0.0);
    }

    @Test
    public void testDepositNegativeAmount() {
        CheckingAccount account = new CheckingAccount("Silas", mockDisplayer);
        account.deposit(-500); // Should be rejected
        assertEquals(0.0, account.getBalance(), "Balance should not change on invalid deposit");
    }

    @Test
    public void testSavingNegativeAmount() {
        SavingsAccount savingAccount = new SavingsAccount("Silas", mockDisplayer);
        savingAccount.deposit(-500); // Should be rejected
        assertEquals(0.0, savingAccount.getBalance(), "Balance should not change on invalid deposit");
    }

    @Test
    public void testSavingZeroAmount() {
        SavingsAccount savingAccount = new SavingsAccount("Silas", mockDisplayer);
        savingAccount.deposit(0.0); // Should be rejected
        assertEquals(0.0, savingAccount.getBalance(), "Balance should not change on invalid deposit");
    }

    @Test
    public void testWithdrawingMoreAmount() {
        SavingsAccount savingAccount = new SavingsAccount("Silas", mockDisplayer);
        savingAccount.deposit(3000.0);
        savingAccount.withdraw(1000.0); // Should be rejected
        assertEquals(2000.0, savingAccount.getBalance(), "Withdraw amount should not exceed the balance");

    }

    @Test
    @DisplayName("Cover the missing else-branch in CheckingAccount")
    void testCheckingAccountWithdrawExceedingBalance() {
        CheckingAccount account = new CheckingAccount("Silas", mockDisplayer);
        account.deposit(1000);
        account.withdraw(1500);

        assertEquals(1000.0, account.getBalance(), "Withdraw amount should not exceed balance");
    }

    @Test
    @DisplayName("Cover the missing else-branch in SavingsAccount")
    void testSavingsAccountWithdrawExceedingBalance() {
        SavingsAccount account = new SavingsAccount("Silas", mockDisplayer);
        account.deposit(1000);
        account.withdraw(1500);

        assertEquals(1000.0, account.getBalance(), "Withdraw amount should not exceed balance");
    }

    @Test
    @DisplayName("Cover the successful if-branch in SavingsAccount")
    public void testSavingAccountWithdrawSuccess() {
        SavingsAccount account = new SavingsAccount("Silas", mockDisplayer);
        account.deposit(2000);
        account.withdraw(500);
        assertEquals(1500.0, account.getBalance(), "Withdraw must succeed");
        verify(mockDisplayer).displayWithdraw("Silas", 500.0, 1500.0);
    }

    @Test
    @DisplayName("Cover a negative withdraw attempt")
    public void testWithdrawNegativeAmount() {
        CheckingAccount account = new CheckingAccount("Silas", mockDisplayer);
        account.deposit(1000);
        account.withdraw(-100); // Should be rejected
        assertEquals(1000.0, account.getBalance(), "Negative withdraw should be rejected");
    }

    @Test
    public void testSavingsWithdrawNegativeAmount() {
        SavingsAccount account = new SavingsAccount("Silas", mockDisplayer);
        account.deposit(1000);
        account.withdraw(-100); // amount > 0 is false, short-circuits
        assertEquals(1000.0, account.getBalance());
    }
}