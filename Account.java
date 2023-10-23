public class Account {
    private int account;
    private double balance;
    
    //Constructor for account number and starter balance
    public Account (int account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    //returns accountnumber
    public int getAccount() {
        return this.account;
    }

    //returns current balance
    public double getBalance() {
        return this.balance;
    }

    //sets the balance value
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
