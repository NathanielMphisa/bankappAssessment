package com.bankapp.assessment;


public class SavingsAccount {
    private final double minOpenAmount = 1000.00;
    private final double minAccountBalance = 1000.00;
    // in an ideal setup amount is retrived from the DB - used 2000 for test purposes
    private double userSBalance = 2000;

    public String open(double depositAmount){
        // check deposited amount
        if(depositAmount < minOpenAmount){
            return "The minimun deposit amount is " + minOpenAmount;
        }
        else {
            // proceed to create Account -  eg field submission to db
            return "Savings account has be created successfully";
        }
        // transaction log
    }

    public String deposit(double amount){
        userSBalance += amount;
        // transaction log
        return "Withdraw deposit; New Balanace " + userSBalance;
    }

    public String withdraw(double amount){
        double newAmount = 0;
        //acount has to have a minimum acc balance
        newAmount =  userSBalance - amount;
        if(newAmount < minAccountBalance){
            return "Amount exceeds minimum balance amount";
        }
        else {
            userSBalance = newAmount;
            return "Withdraw Successful; New Balanace " + userSBalance;
            // transaction log
        }
    }
}
