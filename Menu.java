import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Management management = new Management();

    public void mainMenu() {

        boolean runMenuOne = true;

        do {

            System.out.println("***HUVUDMENY***");
            System.out.println("1. Skapa konto");
            System.out.println("2. Administrera konto");
            System.out.println("3. Avsluta");
            System.out.print("Ange menyval: ");
            int choiceOne = scanner.nextInt();

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

            }
        } 

        while (runMenuOne);

    }

    public void menuTwo() {

         boolean runMenuTwo = true;

         do {
            
            System.out.println("***KONTOMENY*** " + "Konto: " + management.getLogin());
            System.out.println("1. Ta ut pengar");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Visa saldo");
            System.out.println("4. Avsluta");
            System.out.println("Ange menyval: ");
            int choiceTwo = scanner.nextInt();

            switch (choiceTwo) {

                case 1:
                //bankAccount.withdraw();
                break;

                case 2:
                management.deposit();
                break;

                case 3:
                //bankAccount.balance();
                break;

                case 4:
                runMenuTwo = false;
                break;

            }
        }

        while (runMenuTwo);

    }
}
