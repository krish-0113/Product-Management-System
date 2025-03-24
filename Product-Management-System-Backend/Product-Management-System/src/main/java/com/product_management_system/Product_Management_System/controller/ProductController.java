package com.product_management_system.Product_Management_System.controller;

import com.product_management_system.Product_Management_System.entity.Product;
import com.product_management_system.Product_Management_System.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ✅ Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return productService.getAllProducts();
    }

    // ✅ Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    // ✅ Add product
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // ✅ Update product
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // ✅ Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
