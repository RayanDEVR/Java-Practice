/*
Package-Level Access Design   [Scenario-Based | Advanced]
Design model, service and app packages for a bank simulation. Decide which constructors/methods are public, 
which helper is package-private and which fields remain private.
Done when: The public surface is minimal while app can perform required use cases.
*/

class Account {
    private double balance;
    private String name;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void getInformation() {
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    public void applyInterest(double rate) {
        balance += balance * rate;
        System.out.println("Balance after applying interest: " + balance);
    }
}

public class Ex139PackageLevelAccessDesign {
    public static void main(String[] args) {
        Account account = new Account("Rayan", 10000);
        account.getInformation();
        account.applyInterest(0.05);
    }
}
