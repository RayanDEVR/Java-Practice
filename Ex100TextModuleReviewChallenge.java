/*
Text Module Review Challenge   [Build from Scratch | Intermediate]
Build a console-free InvoiceFormatter class that accepts prepared values and returns a formatted multi-line 
String using StringBuilder. Include customer, item count, subtotal, discount and payable total.
Done when: No input is read inside the formatter and repeated calls do not leak text from previous calls.
*/

class InvoiceFormatter {
    String customerName;
    int itemCount;
    double subtotal;
    double discount;
    
    public InvoiceFormatter(String customerName, int itemCount, double subtotal, double discount) {
        this.customerName = customerName;
        this.itemCount = itemCount;
        this.subtotal = subtotal;
        this.discount = discount;
    }
    
    public void payment() {
        double payableTotal = subtotal - discount;
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name: ").append(customerName + "\n");
        sb.append("Item Count: ").append(itemCount + "\n");
        sb.append("Subtotal: ").append(subtotal + "\n");
        sb.append("Discount: ").append(discount + "\n");
        sb.append("Payable Total: ").append(payableTotal + "\n");

        System.out.println(sb);
    }
    
}
public class Ex100TextModuleReviewChallenge {
    public static void main(String[] args) {
        InvoiceFormatter payment = new InvoiceFormatter("Rayan", 5, 1200, 100);
        payment.payment();
    }
}
