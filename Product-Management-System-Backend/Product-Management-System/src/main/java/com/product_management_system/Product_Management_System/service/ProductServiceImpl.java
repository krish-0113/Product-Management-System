package com.product_management_system.Product_Management_System.service;

import com.product_management_system.Product_Management_System.entity.Product;
import com.product_management_system.Product_Management_System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ Get all products
    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // ✅ Get product by ID
    @Override
    public ResponseEntity<Product> getProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add product with success message
    @Override
    public ResponseEntity<String> addProduct(Product product) {
        productRepository.save(product);
        return new ResponseEntity<>("Product successfully added!", HttpStatus.CREATED);
    }

    // ✅ Update product with success message
    @Override
    public ResponseEntity<String> updateProduct(int id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setProductPrice(product.getProductPrice());
            productRepository.save(existingProduct);
            return new ResponseEntity<>("Product successfully updated!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Delete product with success message
    @Override
    public ResponseEntity<String> deleteProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
    }
}
