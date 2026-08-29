/*
Encapsulated Bank Account   [Build from Scratch | Intermediate]
Create BankAccount with private accountNumber, holderName and balance. Provide read methods and 
deposit/withdraw methods that enforce positive amounts and sufficient funds.
Done when: No caller can directly set balance and invalid operations leave state unchanged.
*/

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = (balance >= 0) ? balance : 0;
    }

    public void accountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balace: " + balance);
    }

    public void deposit(double ammount) {
        if (ammount > 0) {
            balance += ammount;
            System.out.println("Deposit successful. " + "New Balance: " + balance);
        }
    }

    public void withdraw(double ammount) {
        if (ammount <= balance && ammount > 0) {
            balance -= ammount;
            System.out.println("Whithdraw accepted. " + "New Balance: " + balance);
        }
        if (ammount < 0) {
            System.out.println("Withdraw rejected: Withdraw Ammount must be positive.");
        }
        if (ammount > balance) 
            System.out.println("Withdraw rejected: Insufficient funds.");
    }
}

public class Ex101EncapsulatedBankAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("12OC4", "Rayan", 1000);
        acc.accountInfo();
        acc.deposit(1500);
        acc.withdraw(200);
        acc.withdraw(-500);
        acc.withdraw(3000);
    }
}
