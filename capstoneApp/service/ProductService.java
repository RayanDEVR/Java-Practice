package capstoneApp.service;

import capstoneApp.model.Product;
import capstoneApp.exception.DuplicateException;
import capstoneApp.exception.NotFoundException;

import java.util.Comparator;
import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        if (repository.findById(product.getId()).isPresent()) {
            throw new DuplicateException("Product ID already exists.");
        }

        repository.save(product);
    }

    public Product getProduct(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found."));

    }

    public void updateProduct(int id, String name, double price) throws NotFoundException {
        Product product = getProduct(id);

        product.update(name, price);
    }

    public void stockIn(int id, int quantity) {
        Product product = getProduct(id);

        product.addStock(quantity);
    }

    public List<Product> listProducts() {
        return repository.findAll();
    }

    public List<Product> filterByPrice(double maxPrice) {
        return repository.findAll()
                .stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .toList();
    }

    public List<Product> sortByPrice() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toList();
    }

    public List<Product> sortByName() {
        return repository.findAll()
                .stream()
                .sorted()
                .toList();
    }
}
