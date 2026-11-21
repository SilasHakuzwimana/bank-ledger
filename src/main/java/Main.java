public class Main {
    public static void main(String[] args) {
        Displayer disp = new Displayer();
        Account checkAccount = new CheckingAccount("Silas", disp);
        checkAccount.deposit(5000);
        checkAccount.withdraw(2000);

        Account savings = new SavingsAccount("Silas", disp);
        savings.deposit(1000);
    }



}