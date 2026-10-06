package capstoneApp.service;

import capstoneApp.model.Cart;
import capstoneApp.model.CartItem;
import capstoneApp.model.Product;
import capstoneApp.exception.CartException;
import capstoneApp.exception.NotFoundException;
import capstoneApp.exception.StockException;

public class CartService {
    private final ProductService productService;

    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public void addItem(Cart cart, int productId, int quantity) {
        Product product = productService.getProduct(productId);

        if (product == null) {
            throw new NotFoundException("Product not found in cart.");
        }

        if (quantity > product.getStock()) {
            throw new StockException("Not enough stock.");
        }

        for (CartItem item: cart.getItems()) {
            if (item.getProduct().getId() == productId) {
                int newQuantity = item.getQuantity() + quantity;

                if (newQuantity > product.getStock()) {
                    throw new StockException("Not enough stock.");
                }

                item.updateQuantity(newQuantity);
                return;
            }
        }

        cart.getItems().add(new CartItem(product, quantity));
    }

    public void updateItem(Cart cart, int productId, int quantity) {
        CartItem item = findItem(cart, productId);

        if (quantity > item.getProduct().getStock()) {
            throw new StockException("Not enough stock.");
        }

        item.updateQuantity(quantity);
    }

    public void removeItem(Cart cart, int productId) {
        CartItem item = findItem(cart, productId);

        cart.getItems().remove(item);
    }

    private CartItem findItem(Cart cart, int productId) {
        return cart.getItems()
        .stream()
        .filter(item -> item.getProduct().getId() == productId)
        .findFirst()
        .orElseThrow(() -> new CartException("Product not found in cart."));
    }
}
