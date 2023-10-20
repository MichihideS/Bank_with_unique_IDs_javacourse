import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Management management = new Management();

    public void mainMenu() {
        boolean isMenuOne = true;

        do {
            int choiceOne = 0;

            System.out.println("***HUVUDMENY***");
            System.out.println("1. Skapa konto");
            System.out.println("2. Administrera konto");
            System.out.println("3. Avsluta");
            System.out.print("Ange menyval: ");
            
             if (scanner.hasNextInt()) {
                choiceOne = scanner.nextInt();
            } else {
                scanner.nextLine();
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
                isMenuOne = false;
                break;

                default:
                System.out.println("Felaktig inmatning, försök igen.");
                break;
            }
        } 

        while (isMenuOne);
    }

    public void menuTwo() {

         boolean isMenuTwo = true;

        do {
            int choiceTwo = 0;
            
            System.out.println("***KONTOMENY*** " + "Konto: " + management.getLogin());
            System.out.println("1. Ta ut pengar");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Visa saldo");
            System.out.println("4. Avsluta");
            System.out.print("Ange menyval: ");
     
            if (scanner.hasNextInt()) {
                choiceTwo = scanner.nextInt();
            } else {
                scanner.nextLine();
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
                isMenuTwo = false;
                break;

                default:
                System.out.println("Felaktig inmatning, försök igen.");
                break;
            }
        }
        while (isMenuTwo);
    }
}
