import java.util.Scanner;

public class Money {

    private Scanner scanner = new Scanner(System.in);
    private double money;

    public void withdraw() {

        System.out.println("Ange belopp: ");
        double withdrawMoney = scanner.nextDouble();

        if (withdrawMoney > money) {
            System.out.println("För lite pengar på kontot");
        }

        else if (withdrawMoney <= money) {
            System.out.println("OK!");
            money = money - withdrawMoney;
        }
    }

    public void deposit() {

        System.out.println("Ange belopp: ");
        money = scanner.nextDouble();

    }


    
}
