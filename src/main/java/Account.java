public interface Account {
    double deposit(double amount);
    
    void withdraw(double amount);

    double getBalance();
}