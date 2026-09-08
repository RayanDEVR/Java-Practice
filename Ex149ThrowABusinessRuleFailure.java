/*
Throw a Business Rule Failure   [Scenario-Based | Advanced]
In withdraw, explicitly throw an exception when amount is non-positive or exceeds balance. Ensure no balance 
mutation occurs before validation.
Done when: Failed withdrawals preserve the original balance and messages name the violated rule.
*/

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws IllegalAccessException {
        if(amount <= 0){
            throw new IllegalAccessException("Withdraw ammount must be positive.");
        }
        
        if (amount > balance) {
            throw new IllegalAccessException("Insufficient balance.");
        }
        
        System.out.println("Withdraw successful. New balance: " + (balance -= amount));
    }
}

public class Ex149ThrowABusinessRuleFailure {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(4000);
        try{
            acc.withdraw(-100);
        }
        catch (IllegalAccessException e) {
            System.out.println("Withdraw request rejected: " + e.getMessage());
        }

        try{
            acc.withdraw(5000);
        }
        catch (IllegalAccessException e) {
            System.out.println("Withdraw request rejected: " + e.getMessage());
        }

        try{
            acc.withdraw(2000);
        }
        catch(IllegalAccessException e){
            System.out.println("Withdraw request rejected: " + e.getMessage());
        }
    }
}
