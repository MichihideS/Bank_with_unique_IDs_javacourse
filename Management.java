import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    
    private ArrayList<Account> bankAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int login;
    private int i;

    public void addAccount() {

        System.out.print("Ange kontonummer: ");
        int account = scanner.nextInt();
        int balance = 0;

        bankAccounts.add(new Account(account, balance));

    }

    public void loginAccount() {

        boolean loggedIn = false;

        System.out.print("Ange kontonummer: ");
        login = scanner.nextInt();
        

        for (i = 0; i < bankAccounts.size(); i++) {

            if (login == (bankAccounts.get(i).getAccount())) {
                System.out.println("OK");
                break;
            }

            else if (!loggedIn) {
                System.out.println("Detta konto existerar inte.");
            }
        }
    }

    public void deposit() {

        System.out.print("Ange belopp: ");
        int depositMoney = scanner.nextInt();

        bankAccounts.get(i).setBalance(bankAccounts.get(i).getBalance() + depositMoney );
        System.out.println("OK");
            
    }

    public void withdraw() {

        System.out.print("Ange belopp: ");
        int moneyWithdraw = scanner.nextInt();

        if (moneyWithdraw <= bankAccounts.get(i).getBalance()) {

            bankAccounts.get(i).setBalance(bankAccounts.get(i).getBalance() - moneyWithdraw);
            System.out.println("OK");

        }

        else if (moneyWithdraw > bankAccounts.get(i).getBalance()) {

            System.out.println("Du har för litet saldo.");

        }
    }

    public void balance() {

        System.out.println("Ditt saldo är: " + bankAccounts.get(i).getBalance());

    }

    public int getLogin() {

        return this.login;

    }

    public void setLogin(int login) {

        this.login = login;

    }
}
