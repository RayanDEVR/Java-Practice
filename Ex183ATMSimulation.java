/*
ATM Simulation   [Mini Project | Project]
Model Account and TransactionType enum. Implement login attempt limit, balance inquiry, deposit, withdrawal 
and mini statement in memory. Use custom exceptions for invalid amount/insufficient funds.
Done when: Balance never becomes negative, failed operations do not create success records, and the menu 
survives bad input.
*/

import java.util.Scanner;

enum TransactionType {
    Deposit, Withdrawal
}

@FunctionalInterface
interface Transaction {
    void action(TransactionType type, double amount);
}

class Account implements Transaction {
    private String name;
    private double balance;
    private int pin;  
    private int loginAttempts = 0;
    private boolean locked = false;
    
    Account(String name, double balance, int pin) {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }
    
    int getPin() {
        return pin;
    }
    
    void showAccount() {
        System.out.println("Name: " + name + "; Balance: " + balance);
    }
    
    boolean login(int enterPin) {
        if (locked) {
            System.out.println("Account is locked.");
            return false;
        }
        
        if (enterPin == pin) {
            loginAttempts = 0;
            System.out.println("Login successful.");
            
            return true;
        }
        
        else {
            loginAttempts++;
            System.out.println("Wrong PIN. Attempts left: " + (3 - loginAttempts));
        }
        
        if (loginAttempts >= 3) {
            locked = true;
            System.out.println("Account is locked due to 3 failed login attempts.");
        }
            return false;
        
    }
    
    public void action(TransactionType type, double amount) {
        if (amount > 0) {
        switch(type) {
            case Deposit -> { 
                balance += amount;
                System.out.println("Deposit success: " + amount + "; New balance: " + balance);
            }
            case Withdrawal -> { 
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdraw success: " + amount + "; New balance: " + balance);
                }
                else 
                    System.out.println("Withdrawal rejected. Insufficient balance.");
        }
        }
        }
        
        else 
            System.out.println(type + " Rejected. Amount must be positive. " + amount + " is invalid.");
    }
}

public class Ex183ATMSimulation {
    public static void main(String[] args) {
        boolean logedIn;
        Account acc = new Account("Rayan", 2000, 1111);
        
        System.out.println("Enter your PIN: ");
        Scanner sc = new Scanner(System.in);
        int Pin = sc.nextInt();
        
        if (acc.login(Pin)) {
        acc.showAccount();
        acc.action(TransactionType.Deposit, 200);
        acc.action(TransactionType.Withdrawal, 100);
        acc.action(TransactionType.Deposit, -200);
        acc.action(TransactionType.Withdrawal, -100);
        acc.action(TransactionType.Withdrawal, 10000);
        }
    }
}