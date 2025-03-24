package com.product_management_system.Product_Management_System.repository;

import com.product_management_system.Product_Management_System.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
