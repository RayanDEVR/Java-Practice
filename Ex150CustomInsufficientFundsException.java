/*
Custom InsufficientFundsException   [Build from Scratch | Advanced]
Create a checked custom exception extending Exception, give it a message constructor and use it in 
BankAccount.withdraw.
Done when: The caller either handles or declares the exception, and successful withdrawals still work.
*/

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String massege) {
        super(massege);
    }
}

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientFundsException {
        if(amount <= 0){
            throw new InsufficientFundsException("Withdraw ammount must be positive.");
        }
        
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. You have only " + balance);
        }
        
        System.out.println("Withdraw successful. New balance: " + (balance -= amount));
    }
}

public class Ex150CustomInsufficientFundsException {
    public static void main(String[] args) {
       BankAccount acc = new BankAccount(4000);
        try{
            acc.withdraw(-100);
        }
        catch (InsufficientFundsException e) {
            System.out.println("Withdraw request rejected: " + e.getMessage());
        }

        try{
            acc.withdraw(5000);
        }
        catch (InsufficientFundsException e) {
            System.out.println("Withdraw request rejected: " + e.getMessage());
        }

        try{
            acc.withdraw(2000);
        }
        catch(InsufficientFundsException e){
            System.out.println("Withdraw request rejected: " + e.getMessage());
        } 
    }
}
