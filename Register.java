import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    
    private ArrayList<Account> listOfAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addAccount() {

        System.out.print("Ange kontonummer: ");
        int account = scanner.nextInt();

        listOfAccounts.add(new Account(account));

        System.out.println("funkar det?");
        for (int i = 0; i < listOfAccounts.size(); i++) {

            System.out.println(listOfAccounts.get(i).getAccount());
            
        }

    }

    public void loginAccount() {

        boolean loggedIn = false;
        int login;

        System.out.print("Ange kontonummer: ");
        login = scanner.nextInt();

        for (int i = 0; i < listOfAccounts.size(); i++) {

            if (login == (listOfAccounts.get(i).getAccount())) {
                System.out.println("works");
                break;
            }

            else if (!loggedIn) {
                System.out.println("konto finns inte");
            }
            
        }



    }


}
