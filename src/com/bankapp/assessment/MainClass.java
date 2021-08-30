package com.bankapp.assessment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter service character");
        System.out.println(" a - Open Savings Acc  \n b - deposit into Savings Acc \n c - withdraw from Savings Acc \n" +
                " d - Open Current Acc  \n e - deposit into Current Acc \n f - withdraw from Current Acc");
        char character = scanner.next().charAt(0);

        switch (character) {
            case 'a':
                openSavingsAcc();
                break;
            case 'b':
                depositSavingsAcc();
                break;
            case 'c':
                withdrawSavingsAcc();
                break;
            case 'd':
                openCurrentAcc();
                break;
            case 'e':
                depositCurrentAcc();
                break;
            case 'f':
                withdrawCurrentAcc();
                break;
            default:
                System.out.println("Invalid selection");
        }

    }

    private static void withdrawCurrentAcc() {
        CurrentAccount currentAccount = new CurrentAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter amount");
        String log = currentAccount.withdraw(scanner.nextDouble());
        savelog(log);
    }

    private static void depositCurrentAcc() {
        CurrentAccount currentAccount = new CurrentAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter amount");
        String log = currentAccount.deposit(scanner.nextDouble());
        savelog(log);
    }

    private static void openCurrentAcc() {
        CurrentAccount currentAccount = new CurrentAccount();
        String log = currentAccount.open();
        savelog(log);
    }

    private static void withdrawSavingsAcc() {
        SavingsAccount savingsAccount = new SavingsAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter amount");
        String log = savingsAccount.withdraw(scanner.nextDouble());
        savelog(log);
    }

    private static void depositSavingsAcc() {
        SavingsAccount savingsAccount = new SavingsAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter amount");
        String log = savingsAccount.open(scanner.nextDouble());
        savelog(log);
    }

    private static void openSavingsAcc() {
        SavingsAccount savingsAccount = new SavingsAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter amount");
        String log = savingsAccount.open(scanner.nextDouble());
        savelog(log);
    }

    // Saving log Method
    public static void savelog(String getWhattoWrite) {
        File file = new File("src/MyFile.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(getWhattoWrite);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
