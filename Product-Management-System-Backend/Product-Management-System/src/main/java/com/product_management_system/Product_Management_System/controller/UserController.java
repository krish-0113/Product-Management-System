package com.product_management_system.Product_Management_System.controller;

import com.product_management_system.Product_Management_System.entity.User;
import com.product_management_system.Product_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Signup Endpoint with Proper Response Handling
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok().body("{\"message\": \"Signup successful!\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"message\": \"Signup failed: " + e.getMessage() + "\"}");
        }
    }

    // ✅ Login Endpoint with Proper Response Handling
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            User loggedInUser = userService.loginUser(email, password);
            return ResponseEntity.ok().body("{\"message\": \"Login successful!\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"message\": \"Login failed: " + e.getMessage() + "\"}");
        }
    }
}
