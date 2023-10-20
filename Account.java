public class Account {

    private int account;
    private int balance;
    
    public Account (int account, int balance) {

        this.account = account;
        this.balance = balance;

    }

    public int getAccount() {

        return this.account;

    }

    public int getBalance() {

        return this.balance;

    }

    public void setBalance(int balance) {

        this.balance = balance;
        
    }
}
