package bank.models;

public class Savingsaccount extends Bankaccount {

    double interestrate;
    public  Savingsaccount(int accnumb, String accholdername, double balance,double interstrate){
        super(accnumb,accholdername,balance,interstrate);
    }
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= 1000) { // maintain minimum balance
            setBalance(-amount); // deduct amount from balance
            addTransaction("Withdrawn: " + amount + " | Balance: " + getBalance());
            System.out.println("Withdrawn: " + amount + " | Current Balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance! Minimum balance 1000 required.");
            addTransaction("Failed withdrawal attempt: " + amount);
        }
    }


    void addInterst(){
        double interest = getBalance() * interestrate/100;
        setBalance(getBalance() + interest);
        System.out.println("Added interst : " + interest + " " + "Cureent Balance : "+ getBalance());
    }
}
