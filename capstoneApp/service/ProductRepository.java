package capstoneApp.service;

import capstoneApp.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ProductRepository {
    private final Map<Integer, Product> products = new HashMap<>();

    public Map<Integer, Product> getProduct() {
        return products;
    }
    
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    public Optional<Product> findById(int id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}
