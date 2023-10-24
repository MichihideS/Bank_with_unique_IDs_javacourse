import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Management management = new Management();
    private boolean isMenuOne;
    private boolean isMenuTwo;
    private int menuChoiceOne;
    private int menuChoiceTwo;

    //Runs the main menu
    public void menuOne() {
        isMenuOne = true;

        do {
            menuChoiceOne = 0;

            System.out.println("\n***HUVUDMENY***");
            System.out.println("1. Skapa konto");
            System.out.println("2. Administrera konto");
            System.out.println("3. Avsluta");
            System.out.println("\nAnge menyval: ");
        try {
            menuChoiceOne = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }

            switch (menuChoiceOne) {
                case 1:
                management.accountCheck();
                break;

                case 2:
                management.accountCheckLogin();
                if (management.isLoggedIn() == true)  {
                    menuTwo();
                }
                break;

                case 3:
                isMenuOne = false;
                break;

                default:
                System.out.println("\nFelaktig inmatning, försök igen.");
                break;
            }
        } 

        while (isMenuOne);
    }

    //Runs the second menu if "logged in" to an accountindex
    public void menuTwo() {

        isMenuTwo = true;

        do {
            menuChoiceTwo = 0;
            
            System.out.println("\n***KONTOMENY*** " + "Konto: " + management.getLogin());
            System.out.println("1. Ta ut pengar");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Visa saldo");
            System.out.println("4. Avsluta");
            System.out.println("\nAnge menyval: ");
     
            if (scanner.hasNextInt()) {
                menuChoiceTwo = scanner.nextInt();
            } else {
                scanner.nextLine();
            }

            switch (menuChoiceTwo) {
                case 1:
                management.accountWithdraw();
                break;

                case 2:
                management.accountDeposit();
                break;

                case 3:
                management.accountBalance();
                break;

                case 4:
                isMenuTwo = false;
                break;

                default:
                System.out.println("\nFelaktig inmatning, försök igen.");
                break;
            }
        }
        while (isMenuTwo);
    }
}
