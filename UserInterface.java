import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private MyNumber primeObject = new MyNumber();
    private Scanner stringInput = new Scanner(System.in);
    private Scanner integerInput = new Scanner(System.in);

    UserInterface() {
    }

    private void welcomeMessage() {
        System.out.println("\nWelcome to the prime number validator!");
        System.out.println(
                "This program can determine if a number is prime and the number of prime numbers that exist between 2 and the given integer.");
        System.out.println("The program uses the Sieve of Eratosthenes algorithm to calculate the prime numbers.");
        System.out.println("Enter 'Exit' to exit the program or 'Help' to see a list of commands.");
    }

    private void commands() {
        System.out.println("\nThis program supports the following commands:");
        System.out.println(
                "Check Prime: Will ask for a number and check if it is prime as well as how many prime numbers exist from 2 to that number.");
        System.out.println("Welcome: Will reprint the welcomes message.");
        System.out.println("Help: Will output this commands list.");
        System.out.println("Exit: Will exit the program.");
    }

    private void primeCheck(int userInteger) {
        if (userInteger < 2) {
            System.out.println(
                    "User integer cannot be less than two, as 2 is the lowest prime number. Returning to main menu...");
            return;
        }

        this.primeObject.setNumber(userInteger);
        if (this.primeObject.isPrime()) {
            System.out.println("\n" + userInteger + " is prime.");
        } else {
            System.out.println("\n" + userInteger + " is not prime.");
        }
        System.out.println(
                "There are " + this.primeObject.numberOfPrimes() + " prime numbers between 2 and " + userInteger);
        this.primeObject.printPrimeList();
    }

    private void userPrompt() {
        this.welcomeMessage();
        while (true) {
            System.out.print("\nPlease enter a command: ");
            String command = this.stringInput.nextLine();
            if (command.equalsIgnoreCase("exit") | command.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program...");
                System.exit(0);
            } else if (command.equalsIgnoreCase("help") || command.equalsIgnoreCase("commands")) {
                this.commands();
            } else if (command.equalsIgnoreCase("welcome")) {
                this.welcomeMessage();
            } else if (command.equalsIgnoreCase("check prime") || command.equalsIgnoreCase("prime")) {
                while (true) {
                    try {
                        System.out.print("\nPlease enter a number. The number must be 2 or greater: ");
                        int userInteger = this.integerInput.nextInt();
                        this.primeCheck(userInteger);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("This command only accepts integer input. Please try again.");
                        this.integerInput.next();
                    }
                }
            } else {
                System.out.println("\nCommand unknown.");
            }
        }
    }

    public void runInterface() {
        this.userPrompt();
    }
}
