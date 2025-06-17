package day_1;

import java.util.Scanner;

public class Banking_Code {
    static double amount = 5000; // Account balance
    static Scanner src = new Scanner(System.in);

    public static void main(String[] args) {
        int[] pins = {1234, 5678, 9111};

        System.out.print("Enter your PIN: ");
        int pin = src.nextInt();

        if (!checkPin(pin, pins)) {
            System.out.println("Invalid PIN. Access Denied.");
            return;
        }

        System.out.println("Welcome! Choose the task:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Change PIN");

        int task = src.nextInt();

        switch (task) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                changePin(pins, pin);
                break;
            default:
                System.out.println("Invalid task selected. Try again.");
        }
    }

    // Check if the entered PIN is valid
    public static boolean checkPin(int pin, int[] pins) {
        for (int p : pins) {
            if (pin == p) {
                return true;
            }
        }
        return false;
    }

    // Withdraw money
    public static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = src.nextDouble();
        if (withdrawAmount > amount) {
            System.out.println("Insufficient Balance.");
        } else {
            amount -= withdrawAmount;
            System.out.println("Withdrawn: ₹" + withdrawAmount);
            System.out.println("Remaining Balance: ₹" + amount);
        }
    }

    // Deposit money
    public static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = src.nextDouble();
        amount += depositAmount;
        System.out.println("Deposited: ₹" + depositAmount);
        System.out.println("New Balance: ₹" + amount);
    }

    // Check account balance
    public static void checkBalance() {
        System.out.println("Your current balance is: ₹" + amount);
    }

    // Change PIN
    public static void changePin(int[] pins, int oldPin) {
        System.out.print("Enter new PIN: ");
        int newPin = src.nextInt();
        for (int i = 0; i < pins.length; i++) {
            if (pins[i] == oldPin) {
                pins[i] = newPin;
                System.out.println("PIN changed successfully.");
                return;
            }
        }
        System.out.println("PIN change failed.");
    }
}
