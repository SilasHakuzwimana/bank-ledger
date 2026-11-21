public class Displayer {

    public void displayDeposit(String owner, double amount, double balance) {
        System.out.println("\nWelcome to Bank Ledger Services - Deposit");
        System.out.println("Welcome, " + owner);
        System.out.println("You've deposited: " + amount);
        System.out.println("Your balance is now: " + balance);
        System.out.println("\n\nThank you for using Bank Ledger Service!");

    }

    public void displaySavings(String owner, double amount, double balance) {
        System.out.println("\n\nWelcome to Bank Ledger Services - Savings");
        System.out.println("Welcome, " + owner);
        System.out.println("You've saved: " + amount);
        System.out.println("Your savings is now: " + balance);
        System.out.println("\n\nThank you for using Bank Ledger Service!");

    }

    public void displayWithdraw(String owner, double amount, double balance) {
        System.out.println("\n\nWelcome to Bank Ledger Services - Withdrawal");
        System.out.println("Welcome, " + owner);
        System.out.println("You've withdrew: " + amount);
        System.out.println("Your balance is now: " + balance);
        System.out.println("\n\nThank you for using Bank Ledger Service!");

    }
}