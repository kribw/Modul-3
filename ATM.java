import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    private static boolean mainMenu = true;
    private static boolean secondaryMenu = true;

    public static void main(String[] args) {
        Account accounts = new Account(10, 1000);
        while (mainMenu) {
            accounts.askForId();
            secondaryMenu = true;
            while (secondaryMenu) {
                System.out.println("Menu");
                System.out.println("1: Balance");
                System.out.println("2: Withdraw");
                System.out.println("3: Deposit");
                System.out.println("4: Cancel");

                int choice = accounts.getChoice();
                if (choice == 1) {
                    accounts.printBalance();
                } else if (choice == 2) {
                    accounts.withdraw();
                } else if (choice == 3) {
                    accounts.deposit();
                } else if (choice == 4) {
                    secondaryMenu = false;
                    System.out.println();
                } else {
                    System.out.println("Invalid operation. Please submit a number between 1 and 4.\n");
                }
            }
        }
    }
}

class Account {
    Scanner input = new Scanner(System.in);
    private int currentId;
    private int[] accounts;

    public Account(int accounts, int balance) {
        this.accounts = new int[accounts];
        Arrays.fill(this.accounts, balance);
    }

    public void askForId() {
        boolean loop = true;
        while (loop) {
            System.out.print("Submit account ID: ");
            int accountId = input.nextInt() - 1;
            if (accountId >= 0 && accountId < 10) {
                currentId = accountId;
                loop = false;
                System.out.println();
            } else {
                System.out.println("Please submit an ID between 1 and 10.");
            }
        }
    }

    public int getChoice() {
        System.out.print("What would you like to do? ");
        int choice = input.nextInt();
        return choice;
    }

    public void withdraw() {
        System.out.print("Submit amount to withdraw: ");
        int amount = input.nextInt();
        if (amount <= accounts[currentId]) {
            accounts[currentId] -= amount;
            System.out.printf("Successfully withdrew %d kr from account #%d.\n \n", amount, currentId + 1);
        } else {
            System.out.println("Invalid operation!\n");
        }
    }

    public void deposit() {
        System.out.print("Submit amount to deposit: ");
        int amount = input.nextInt();
        if (amount > 0) {
            accounts[currentId] += amount;
            System.out.printf("Successfully deposited %d kr to account #%d.\n \n", amount, currentId + 1);
        } else {
            System.out.println("Invalid operation!\n");
        }

    }

    public void printBalance() {
        System.out.printf("Balance for account #%d is %d kr.\n \n", currentId + 1, accounts[currentId]);
    }
}