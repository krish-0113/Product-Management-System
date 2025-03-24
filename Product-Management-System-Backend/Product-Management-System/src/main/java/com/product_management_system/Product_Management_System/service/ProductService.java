package com.product_management_system.Product_Management_System.service;

import com.product_management_system.Product_Management_System.entity.Product;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ProductService {
    ResponseEntity<List<Product>> getAllProducts();
    ResponseEntity<Product> getProduct(int id);
    ResponseEntity<String> addProduct(Product product);
    ResponseEntity<String> updateProduct(int id, Product product);
    ResponseEntity<String> deleteProduct(int id);
}
