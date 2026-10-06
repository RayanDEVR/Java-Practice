package capstoneApp.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final int userID;
    private final List<CartItem> items = new ArrayList<>();

    public Cart(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid User ID.");
        }

        this.userID = userId;
    }

    public int getUserId() {
        return userID;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return items.stream()
        .map(CartItem::getTotal)
        .reduce(0.0, Double::sum);
    }

    public void clear() {
        items.clear();
    }
}
