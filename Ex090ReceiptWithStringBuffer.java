/*
Receipt with StringBuffer   [Build from Scratch | Intermediate]
Build a multi-line receipt incrementally with StringBuffer: header, three items, subtotal and status. Print only 
after the text is complete.
Done when: The final receipt is readable and append operations are correctly chained or sequenced.
*/

public class Ex090ReceiptWithStringBuffer {
    public static void main(String[] args) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("====Receippt====");
        receipt.append("Notebook    x2  = 150.0\n");
        receipt.append("Pen         x2  = 20.0\n");
        receipt.append("Stapler     x1  = 80.0\n");
        receipt.append("-----------------------------\n");
        receipt.append("Subtotal: 250.0\n");
        receipt.append("Status: PAID\n");

        System.out.println(receipt);
    }
}
