package com.product_management_system.Product_Management_System.service;
import com.product_management_system.Product_Management_System.entity.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email,String password);
}
