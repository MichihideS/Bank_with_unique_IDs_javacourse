import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Management management = new Management();

    public void mainMenu() {

        boolean runMenuOne = true;
        int choiceOne = 0;

        do {

            System.out.println("***HUVUDMENY***");
            System.out.println("1. Skapa konto");
            System.out.println("2. Administrera konto");
            System.out.println("3. Avsluta");
            System.out.print("Ange menyval: ");

            try {
                
                choiceOne = scanner.nextInt();

            }
            
            catch (InputMismatchException noNumber) {

                System.out.println("Felaktig inmatning, försök igen.");
                scanner = new Scanner(System.in);

           }

            switch (choiceOne) {

                case 1:
                management.addAccount();
                break;

                case 2:
                management.loginAccount();
                menuTwo();
                break;

                case 3:
                runMenuOne = false;
                break;

                default:
                System.out.println("Felaktig inmatning, försök igen.");
                break;

            }
        } 

        while (runMenuOne);

    }

    public void menuTwo() {

         boolean runMenuTwo = true;
         int choiceTwo = 0;

         do {
            
            System.out.println("***KONTOMENY*** " + "Konto: " + management.getLogin());
            System.out.println("1. Ta ut pengar");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Visa saldo");
            System.out.println("4. Avsluta");
            System.out.print("Ange menyval: ");
            
            try {

                choiceTwo = scanner.nextInt();

            }

            catch (InputMismatchException noNumber) {

                System.out.println("Felaktig inmatning, försök igen.");
                scanner = new Scanner(System.in);

            }

            switch (choiceTwo) {

                case 1:
                management.withdraw();
                break;

                case 2:
                management.deposit();
                break;

                case 3:
                management.balance();
                break;

                case 4:
                runMenuTwo = false;
                break;

                default:
                System.out.println("Felaktig inmatning, försök igen.");
                break;

            }
        }

        while (runMenuTwo);

    }
}
