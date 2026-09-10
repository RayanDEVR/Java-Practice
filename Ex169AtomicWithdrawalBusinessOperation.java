/*
Atomic Withdrawal Business Operation   [Scenario-Based | Advanced]
Simulate two threads withdrawing from one account. Protect the complete check-and-deduct operation so the 
balance never becomes invalid.
Done when: With limited balance, only allowed withdrawals succeed and check/update occur under one lock.
*/

class Account {
    private double balance;
    private final Object lock = new Object();

    Account(double balance) {
        this.balance = balance;
    }

    boolean withdraw(double amount, String who) {
        synchronized (lock) {
            if (amount > balance) {
                System.out.println(who + " failed to withdraw " + amount + ", (balance: " + balance + ")");
                return false;
            }
            
            balance -= amount;
            System.out.println(who + " withdraw " + amount + ", remaining balance " + balance);
            return true;
        }
    }

    double getBalance() {
        return balance;
    }
}

public class Ex169AtomicWithdrawalBusinessOperation {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);

        Thread t1 = new Thread(() -> account.withdraw(700, "ThreadA"));
        Thread t2 = new Thread(() -> account.withdraw(1700, "ThreadB"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}
