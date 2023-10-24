import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    private ArrayList<Account> bankAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int accountLoggedIn;
    private int accountIndex;
    private int accountChecker;
    private boolean isLoggedIn;
    private String numberChecker;

    //Checks if the input is an integer and moves to the create account method if it is
    public void accountCheck() {
        System.out.print("\nAnge kontonummer: ");
        numberChecker = scanner.nextLine();
        
        try {
            if (isNumber(numberChecker)) {
                accountChecker = Integer.parseInt(numberChecker);
                accountCreate();
            } else {
                errorMessage();
                return;
            }
        } catch (NumberFormatException e) {
            errorMessage();
            return;
        }
    }
       
    //Creates the account if the number isn't taken
    public void accountCreate() {
        double balance = 0;

        if (bankAccounts.isEmpty()) {
            bankAccounts.add(new Account(accountChecker, balance));
            System.out.println("\nOK");
            return;
        }

        for (int i = 0; i < bankAccounts.size(); i++) {
            if (accountChecker == (bankAccounts.get(i).getAccount())){
                System.out.println("\nKontot finns redan.");
                return; 
            }
        }
                
        bankAccounts.add(new Account(accountChecker, balance));
        System.out.println("\nOK");
        return;
    }
    
    //Checks if input is an integer and moves to the login account method is it is
    public void accountCheckLogin() {
        System.out.print("\nAnge kontonummer: ");
        numberChecker = scanner.nextLine();

        try {
            if (isNumber(numberChecker)) {
                accountLoggedIn = Integer.parseInt(numberChecker);
                accountLogin();
            } else {
                errorMessage();
                return;
            }
        } catch (NumberFormatException e) {
            errorMessage();
            return;
        }
    }

    //Checks if the account number exists and if it does "logs in" and saves the index where its stored
    public void accountLogin() {
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (accountLoggedIn == (bankAccounts.get(i).getAccount())) {
                accountIndex = i;

                System.out.println("\nOK");
                isLoggedIn = true;
                return;
            } 
        }

        System.out.println("\nDetta konto existerar inte.");
        isLoggedIn = false;
        return;
    }

    //Sets the balance of the "logged in" accountindex to what you want to deposit + the original balance
    public void accountDeposit() {
        System.out.print("\nAnge belopp: ");
        numberChecker = scanner.nextLine();

        try {
            if (isNumber(numberChecker)) {
                Double moneyDeposit = Double.parseDouble(numberChecker);
                bankAccounts.get(accountIndex).setBalance(bankAccounts.get(accountIndex).getBalance() + moneyDeposit );
                System.out.println("\nOK");
                return;
            } else {
                errorMessage();
                return;
            }
        } catch (NumberFormatException e) {
            errorMessage();
            return;
        }    
    }
  
    //If you have enough money, withdraws it from the "logged in" accountindex balance
    public void accountWithdraw() {
        System.out.print("\nAnge belopp: ");
        numberChecker = scanner.nextLine();

        try {
            if (isNumber(numberChecker)) {
                Double moneyWithdraw = Double.parseDouble(numberChecker);

                if (moneyWithdraw <= bankAccounts.get(accountIndex).getBalance()) {
                    bankAccounts.get(accountIndex).setBalance(bankAccounts.get(accountIndex).getBalance() - moneyWithdraw);
                    System.out.println("\nOK");
                    return;
                } else if (moneyWithdraw > bankAccounts.get(accountIndex).getBalance()) {
                    System.out.println("\nDu har för litet saldo.");
                    return;
                }
            } else {
                errorMessage();
                return;
            }
        } catch (NumberFormatException e) {
            errorMessage();
            return;
        }
    }
    
    //Prints out the balance of the current "logged in" accountindex
    public void accountBalance() {
        DecimalFormat decimal = new DecimalFormat("0.00");
        
        String roundedBalance = decimal.format(bankAccounts.get(accountIndex).getBalance());
        System.out.println("\nDitt saldo är: " + roundedBalance + " kr");
    }

    //Function that checks if the input string is numbers only
    public boolean isNumber(String numberCheck) {
        for (int i = 0; i < numberCheck.length(); i++) {
            if (Character.isDigit(numberCheck.charAt(i)) == true) {
                return true;
            }
        }
            
        return false;
    }

    public void errorMessage() {
        System.out.println("\nFelaktig inmatning, försök igen.");
    }

    //Returns current "logged in" accountindex
    public int getLogin() {
        return this.accountLoggedIn;
    }

    //Returns if currently "logged in" or not
    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }
}
