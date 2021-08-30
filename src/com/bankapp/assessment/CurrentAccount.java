package com.bankapp.assessment;

public class CurrentAccount {
    private final double maxOverdraftLimit = -100000.00;
    // in an ideal setup userOverdraft and userCBalance should be retrieved from the DB
    private double userCBalance = 50000.00;
    private double userOverdraft = 0;

    public String open(){
        //proceed to submit form fields
        return "Account opened successfully";
    }

    public String deposit(double amount){
        userCBalance += amount;
        return "Amount deposited successfully - New Balance " + userCBalance;
    }

    public String withdraw(double amount){

        double tempoAmount = userCBalance - amount;
        if(amount > 0){
            userCBalance -= amount; // need to write value into DB
            return "Withdraw successful - new Account balance \" + userCBalance";

        }else {
            //test if amount has not exceeded max overdraft
            if(tempoAmount < 0 && tempoAmount > maxOverdraftLimit){
                userCBalance = tempoAmount; // need to write value into DB
                userOverdraft = userCBalance; // need to write value into DB
                return " Withdraw successful - Overdraft " + userOverdraft;
            }
            else return " Amount exceeds max Overdraft limit";
        }
    }
}
