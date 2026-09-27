/*
Multi-Account Banking System   [Mini Project | Project]
Extend banking to Map<String, Account>, transfer service, account types with polymorphic monthly charges and 
transaction history lists. Use encapsulation and failure-atomic transfers.
Done when: Create/find accounts, deposit, withdraw, transfer, list accounts sorted by balance and produce 
total-bank-balance report.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum AccountType {
    Savings, Current
}

class TransactionFailedException extends Exception {
    public TransactionFailedException(String message) {
        super(message);
    }
}

class Account {
    String id;
    String name;
    double balance;
    AccountType type;
    List<String> transactions;
    double monthlyCharge = 10;
    
    Account(String id, String name, double balance, AccountType type) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.type = type;
        this.transactions = new ArrayList<>();
    }
    
    void showAccount() {
    System.out.println("ID: " + id + "; Name: " + name + "; Balance: $" + balance + "; AccountType: " + type);
    }
    
    void transfer(Account to, double amount) throws TransactionFailedException {
        
        if (amount <= 0) {
            throw new TransactionFailedException("Amount must be positive");
        }
        
        if (balance < amount) {
            throw new TransactionFailedException("Insufficient balance.");
        }
        
        balance -= amount;
        to.balance += amount;
        
        System.out.println("Transaction successfull.");
        System.out.println(id + "(" + name +")" + " transfered $" + amount + " to " + to.id + "(" + to.name + ")");
    }
    
    void chargeMonthlyFee() {
        if (balance > monthlyCharge) {
            balance -= monthlyCharge;
            System.out.println("ID :" + id);
            System.out.println("Monthly charge: -$" + monthlyCharge);
            System.out.println("Current Balance: $" + balance);
        }
    }
}


public class Ex184MultiAccountBankingSystem {
    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();
        accounts.put("A-101", new Account("A-101", "Rayan", 1000, AccountType.Savings));
        accounts.put("A-103", new Account("A-103", "Samiul", 2000, AccountType.Current));
        accounts.put("A-105", new Account("A-105", "Radoan", 4000, AccountType.Savings));
        accounts.put("A-104", new Account("A-104","Abdullah", 3000, AccountType.Current));
        
        Account rayan = accounts.get("A-101");
        Account samiul = accounts.get("A-103");
        Account radoan = accounts.get("A-105");
        Account abdullah = accounts.get("A-104");
        
        try {
        rayan.transfer(samiul, 100);
        }
        catch (TransactionFailedException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        
        System.out.println();
        samiul.showAccount();
        radoan.showAccount();
        
        System.out.println();
        abdullah.chargeMonthlyFee();
    }
}