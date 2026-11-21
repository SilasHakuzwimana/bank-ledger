public class SavingsAccount implements Account {
    private double balance;
    private final String accountOwner;
    private final Displayer disp;

    public SavingsAccount(String owner, Displayer disp) {
        this.accountOwner = owner;
        this.balance = 0.0;
        this.disp = disp;
    }

    @Override
    public double deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return balance;
        }
        balance += amount;
        disp.displaySavings(accountOwner, amount, balance);
        return balance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            disp.displayWithdraw(accountOwner, amount, balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}