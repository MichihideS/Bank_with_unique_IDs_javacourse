import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    
    private ArrayList<Account> bankAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int login;

    public void addAccount() {

        System.out.print("Ange kontonummer: ");
        int account = scanner.nextInt();
        int balance = 0;

        bankAccounts.add(new Account(account, balance));

        System.out.println("funkar det?");
        for (int i = 0; i < bankAccounts.size(); i++) {

            System.out.println(bankAccounts.get(i).getAccount());
            System.out.println(bankAccounts.get(i).getBalance());
            
        }
    }

    public void loginAccount() {

        boolean loggedIn = false;

        System.out.print("Ange kontonummer: ");
        login = scanner.nextInt();
        

        for (int i = 0; i < bankAccounts.size(); i++) {

            if (login == (bankAccounts.get(i).getAccount())) {
                System.out.println("works" + login);
                break;
            }

            else if (!loggedIn) {
                System.out.println("konto finns inte");
            }
            
        }

        
    }

    public void deposit() {

        System.out.println("sätt in pengar" + login);
        int money = scanner.nextInt();

        for (int i = 0; i < bankAccounts.size(); i++) {
    
            if (login == (bankAccounts.get(i).getAccount())) {

              bankAccounts.get(i).setBalance(bankAccounts.get(i).getBalance() + money );

              System.out.println(bankAccounts.get(i).getBalance());

            }
        }
    }

    public int getLogin() {

        return this.login;

    }

    public void setLogin(int login) {

        this.login = login;

    }
}
