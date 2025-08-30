package bank.app;

import bank.models.Bankaccount;
import bank.models.Savingsaccount;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Bankaccount> accounts = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Apply Interest");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.println("Choose Account Type:");
                    System.out.println("1. Bank Account");
                    System.out.println("2. Savings Account");
                    System.out.print("Enter choice: ");
                    int type = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    System.out.print("Enter Interest Rate(%): ");
                    double interest = sc.nextDouble();

                    if (type == 1) {
                        Bankaccount newAcc = new Bankaccount(accNum, name, balance,interest);
                        accounts.add(newAcc);
                        System.out.println("Bank Account created successfully!");
                    } else if (type == 2) {
                        System.out.print("Enter Interest Rate (%): ");
                        Savingsaccount newAcc = new Savingsaccount(accNum, name, balance, interest);
                        accounts.add(newAcc);
                        System.out.println("Savings Account created successfully!");
                    } else {
                        System.out.println("Invalid account type!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();
                    Bankaccount dAcc = findAccount(accounts, depAcc);
                    if (dAcc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depAmt = sc.nextDouble();
                        dAcc.deposit(depAmt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withAcc = sc.nextInt();
                    Bankaccount wAcc = findAccount(accounts, withAcc);
                    if (wAcc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withAmt = sc.nextDouble();
                        wAcc.withdraw(withAmt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int histAcc = sc.nextInt();
                    Bankaccount hAcc = findAccount(accounts, histAcc);
                    if (hAcc != null) {
                        hAcc.showHistory();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("\n--- All Accounts ---");
                    for (Bankaccount acc : accounts) {
                        acc.display();
                        System.out.println();
                    }
                    break;
                case 6:
                    sc.nextLine(); // consume newline
                    System.out.println("Choose Account Type for Interest:");
                    System.out.println("1. Bank Account (5% per month)");
                    System.out.println("2. Savings Account (8% per month)");
                    System.out.print("Enter choice: ");
                    int intType = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Account Number: ");
                    int interestAccNum = sc.nextInt();
                    Bankaccount intAcc = findAccount(accounts, interestAccNum);

                    if (intAcc != null) {
                        System.out.print("Enter number of months: ");
                        int months = sc.nextInt();

                        if (intType == 1) { // BankAccount
                            double monthlyInterest = 5; // 5% per month
                            for (int i = 0; i < months; i++) {
                                intAcc.setBalance(intAcc.getBalance() * monthlyInterest / 100); // add 5% of current balance
                                intAcc.addTransaction("Month " + (i + 1) + " interest added: " + (intAcc.getBalance() * monthlyInterest / 100));
                            }
                            System.out.println("Current Balance after " + months + " months: " + intAcc.getBalance());
                        } else if (intType == 2 && intAcc instanceof Savingsaccount) { // SavingsAccount
                            Savingsaccount sAcc = (Savingsaccount) intAcc;
                            double monthlyInterest = 8; // 8% per month
                            for (int i = 0; i < months; i++) {
                                sAcc.addInterest(); // your existing method uses interestrate
                            }
                            System.out.println("Current Balance after " + months + " months: " + sAcc.getBalance());
                        } else {
                            System.out.println("Invalid account type!");
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    // Helper method to find account by account number
    public static Bankaccount findAccount(ArrayList<Bankaccount> accounts, int accNum) {
        for (Bankaccount acc : accounts) {
            if (acc.getAccnumb() == accNum) {
                return acc;
            }
        }
        return null;
    }
}
