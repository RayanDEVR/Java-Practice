/*
Interface Segregation Exercise   [Refactoring | Advanced]
A giant OfficeMachine interface forces PrinterOnly to implement scan and fax.
Split it into small capabilities and update multifunction and print-only devices.
Done when: Each class implements only behavior it truly supports.
*/

// interface OfficeMachine {    //before
//     void print();
//     void scan();
//     void fax();
// }


interface Printer { void print(); }
interface Scanner { void scan(); }
interface Fax { void fax(); }

class PrinterOnlyDevice implements Printer {
    @Override
    public void print() {
        System.out.println("Printing Documents...");
    }
}

class MultifunctionDevice implements Printer, Scanner, Fax {
    @Override 
    public void print() {
        System.out.println("Printing...");
    }
    @Override 
    public void scan() {
        System.out.println("Scanning...");
    }
    @Override 
    public void fax() {
        System.out.println("Faxing...");
    }
}

public class Ex138InterfaceSegregationExercise {
    public static void main(String[] args) {
        PrinterOnlyDevice p = new PrinterOnlyDevice();
        p.print();
        
        MultifunctionDevice mul = new MultifunctionDevice();
        mul.print();
        mul.scan();
        mul.fax();
    }
}
