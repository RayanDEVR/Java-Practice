/*
Multiple Behavior Through Interfaces   [Build from Scratch | Advanced]
Create Payable and Printable interfaces. Invoice implements both; EmployeePayment implements Payable. Write 
methods that depend only on the needed interface.
Done when: Callers can process different Payable implementations without knowing concrete classes.
*/

interface Payable {
    void getAmmount();
}

interface Printable {
    void print();
}

class Invoice implements Payable, Printable {
    String invoiceId;
    double ammount;

    public Invoice(String invoiceId, double ammount) {
        this.invoiceId = invoiceId;
        this.ammount = ammount;
    }

    @Override
    public void getAmmount() {
        System.out.println(ammount);
    }

    @Override
    public void print() {
        System.out.println("Invoice " + invoiceId + ": " + ammount);
    }
}

class EmployeePayment implements Payable {
    String employeeId;
    double ammount;

    public EmployeePayment(String employeeId, double ammount) {
        this.employeeId = employeeId;
        this.ammount = ammount;
    }

    @Override
    public void getAmmount() {
        System.out.println("Employee " + employeeId + ": " + ammount);
    }
}

public class Ex124MultipleBehaviorThroughInterfaces {
    public static void main(String[] args) {
        Invoice i1 = new Invoice("INV-1", 1200);
        EmployeePayment e1 = new EmployeePayment("EMP-1", 1500);

        i1.print();
        e1.getAmmount();
    }
}
