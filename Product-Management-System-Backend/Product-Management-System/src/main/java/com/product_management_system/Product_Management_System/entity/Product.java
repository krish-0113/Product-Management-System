package com.product_management_system.Product_Management_System.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;




    @Column
    private String productName;

    @Column
    private String productDescription;

    @Column
    private double productPrice;

    @Column
    private String productStatus;

    // ✅ Default Constructor
    public Product() {
    }

    // ✅ Correct Constructor (camelCase variables)
    public Product(int id, String productName, String productDescription, double productPrice, String productStatus) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
    }

    // ✅ Correct Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
