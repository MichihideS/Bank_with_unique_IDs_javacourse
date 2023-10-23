import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    private ArrayList<Account> bankAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int login;
    private int accountIndex;
    private int accountChecker;

    public void listCheck () {
        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println(bankAccounts.get(i).getAccount());
        }
    }

    public void accountCheck() {
        boolean isCreateAccount = true;

        while (isCreateAccount) {
            System.out.print("Ange kontonummer: ");

            if (scanner.hasNextInt()) {
                accountChecker = scanner.nextInt();
                isCreateAccount = false;
                
            } else {
                System.out.println("Felaktig inmatning, försök igen.");
                scanner.next();
            }
        }

        accountCreate();
    }

    public void accountCreate() {
        int balance = 0;

        if (bankAccounts.isEmpty()) {
            bankAccounts.add(new Account(accountChecker, balance));
            System.out.println("OK");
            return;
        }

        for (int i = 0; i < bankAccounts.size(); i++) {
            if (accountChecker == (bankAccounts.get(i).getAccount())){
                System.out.println("Kontot finns redan.");
                return; 
            }
        }
                
        bankAccounts.add(new Account(accountChecker, balance));
        System.out.println("OK");
        return;
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
    }
}
