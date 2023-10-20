import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    private ArrayList<Account> bankAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int login;
    private int accountIndex;

    //sjajasjsaklda
    public void addAccount() {
        int account = 0;
        int balance = 0;

        System.out.print("Ange kontonummer: ");
        account = scanner.nextInt();
        
        bankAccounts.add(new Account(account, balance));

        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println(bankAccounts.get(i).getAccount());
        }
    }

    public void loginAccount() {
        System.out.print("Ange kontonummer: ");
        login = scanner.nextInt();
        
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (login == (bankAccounts.get(i).getAccount())) {
                accountIndex = i;
                System.out.println("OK");
                return;
            } 
        }

        System.out.println("Detta konto existerar inte.");
    }

    public void deposit() {
        System.out.print("Ange belopp: ");
        int depositMoney = scanner.nextInt();

        bankAccounts.get(accountIndex).setBalance(bankAccounts.get(accountIndex).getBalance() + depositMoney );
        System.out.println("OK");
    }

    public void withdraw() {
        System.out.print("Ange belopp: ");

        int moneyWithdraw = scanner.nextInt();

        if (moneyWithdraw <= bankAccounts.get(accountIndex).getBalance()) {
            bankAccounts.get(accountIndex).setBalance(bankAccounts.get(accountIndex).getBalance() - moneyWithdraw);
            System.out.println("OK");
        } else if (moneyWithdraw > bankAccounts.get(accountIndex).getBalance()) {
            System.out.println("Du har för litet saldo.");
        }
    }

    public void balance() {
        System.out.println("Ditt saldo är: " + bankAccounts.get(accountIndex).getBalance());
    }

    public int getLogin() {
        return this.login;
        //return bankAccounts.get(accountIndex).getAccount();
    }

    public void setLogin(int login) {
        this.login = login;
    }
}
