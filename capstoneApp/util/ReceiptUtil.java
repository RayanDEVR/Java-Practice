package capstoneApp.util;

import capstoneApp.model.Order;
import capstoneApp.model.OrderItem;

public class ReceiptUtil {
    public static String createReceipt(Order order) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("\n--- Receipt --- \n")
                .append("Order ID: ")
                .append(order.getId())
                .append("\n");

        receipt.append("Customer ID: ")
                .append(order.getCustomerId())
                .append("\n");

        receipt.append("---------------------------");

        for (OrderItem item : order.getItems()) {
            receipt.append(item.getProductName())
                    .append(" x ")
                    .append(item.getQuantity())
                    .append(" = ")
                    .append(item.getTotal());
        }

        receipt.append("---------------------------");

        receipt.append("Subtotal: ")
                .append(order.getSubtotal())
                .append("\n");

        receipt.append("Discount: ")
                .append(order.getDiscount())
                .append("\n");

        receipt.append("Tax: ")
                .append(order.getTax())
                .append("\n");

        receipt.append("Final Total: ")
                .append(order.getFinalTotal())
                .append("\n");

        receipt.append("Payment: ")
                .append(order.getPaymentStatus())
                .append("\n");

        receipt.append("Status: ")
                .append(order.getPaymentStatus())
                .append("\n");

        receipt.append("============================");

        return receipt.toString();
    }
}
