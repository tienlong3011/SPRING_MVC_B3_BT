package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone X", 100, "New", "Apple"));
        products.put(2, new Product(2, "Iphone Xs", 150, "LikeNew", "Apple"));
        products.put(3, new Product(3, "Iphone 11", 200, "New", "Apple"));
        products.put(4, new Product(4, "Iphone 13", 500, "LikeNew", "Apple"));
        products.put(5, new Product(5, "SamSung Note 20", 400, "New", "SamSung"));
        products.put(6, new Product(6, "SamSung Galaxy S21 Ultra", 800, "LikeNew", "SamSung"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
