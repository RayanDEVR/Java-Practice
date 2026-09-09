/*
Failure-Atomic Transfer   [Scenario-Based | Advanced]
Transfer money between two accounts. Validate amount and source balance before changing either account; 
throw a custom TransferException on failure.
Done when: Either both balances change correctly or neither changes.
*/

class TransferException extends Exception {
    public TransferException(String message) {
        super(message);
    }
}

class Account {
    double balance;

    Account(double balance) {
        this.balance = balance;
    }

}

public class Ex158FailureAtomicTransfer {
    static void transfer(Account from, Account to, double transferedBalance) throws TransferException {
        if (transferedBalance <= 0)
            throw new TransferException("Amount must be positive.");
        if (transferedBalance > from.balance)
            throw new TransferException("Insufficient balance in source account.");

        from.balance -= transferedBalance;
        to.balance += transferedBalance;
    }

    public static void main(String[] args) {
        Account a = new Account(1000);
        Account b = new Account(2000);

        System.out.println("Before transition: A = " + a.balance + ", B = " + b.balance);

        try{
            transfer(a, b, 100);
            System.out.println("After transition: A = " + a.balance + ", B = " + b.balance);

            transfer(a, b, 20000);
            System.out.println("After transition: A = " + a.balance + ", B = " + b.balance);

        }
        catch (TransferException e) {
            System.out.println("Transition failed: " + e.getMessage());
        }
    }
}
