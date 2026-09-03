/*
Abstract Account Template   [Build from Scratch | Advanced]
Create abstract Account with common balance behavior and abstract calculateMonthlyCharge. Implement 
SavingsAccount and BusinessAccount.
Done when: Common invariants live in Account while variable policy is supplied by subtypes.
*/

abstract class Account {
    public double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    void deposit(double ammount) {
        if (ammount > 0) {
            balance += ammount;
        }
    }

    abstract double calculateMonthlyCharge();
}

class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    double calculateMonthlyCharge() {
        return 0.0;
    }
}

class BusinessAccount extends Account {
    BusinessAccount(double balance) {
        super(balance);
    }

    @Override
    double calculateMonthlyCharge() {
        return 150.0;
    }
}

public class Ex126AbstractAccountTemplate {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(12000);
        Account bussiness = new BusinessAccount(20000);

        savings.deposit(2000);
        bussiness.deposit(3000);

        System.out.println("Savings balance: " + savings.balance + ", monthly charge: " + savings.calculateMonthlyCharge());
        System.out.println("Bussiness balance: " + bussiness.balance + ", monthly charge: " + bussiness.calculateMonthlyCharge());
    }
}
