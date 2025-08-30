package bank.models;

import java.util.ArrayList;
import java.util.List;

public class Bankaccount {

    private int accnumb;
    private String accholdername;
    private double balance;
    private double binterest;
    protected int value = 10;

    // Inside Bankaccount class
    private List<String> transactionHistory = new ArrayList<>();

    public void addTransaction(String detail) {
        transactionHistory.add(detail);
    }
    public int getAccnumb() {
        return accnumb;
    }

    public String getAccholdername() {
        return accholdername;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newbalance) {
        this.balance += newbalance;
    }

    // Constructors
    public Bankaccount(int accnumb, String accholdername, double balance, double binterest) {
        this.accnumb = accnumb;
        this.accholdername = accholdername;
        this.balance = balance;
        this.binterest = binterest;
        transactionHistory.add("Account created with balance: " + balance);
    }




    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String record = "Deposited: " + amount + " | Balance: " + balance;
            transactionHistory.add(record);
            System.out.println(record);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (balance - amount >= 1000) {
            balance -= amount;
            String record = "Withdrawn: " + amount + " | Balance: " + balance;
            transactionHistory.add(record);
            System.out.println(record);
        } else {
            System.out.println("Minimum balance required!");
        }
    }

    // Interest
    public void addInterest() {
        double interest = balance * binterest / 100;
        balance += interest;
        String record = "Interest added: " + interest + " | Balance: " + balance;
        transactionHistory.add(record);
        System.out.println(record);
    }

    // Show history
    public void showHistory() {
        System.out.println("\n--- Transaction History for Account " + accnumb + " ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    public void display() {
        System.out.print("Account Number: " + accnumb +
                " | Account Holder: " + accholdername +
                " | Balance: " + balance);
    }

    @Override
    public String toString() {
        return "Balance: " + balance;
    }
}
