package com.example.telecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    // Home Page
    @GetMapping("/")
    public String home() {
        return "index"; // Renders index.html
    }

    // Plans Page
    @GetMapping("/plans")
    public String plans(Model model) {
        // Add plans data to the model (mock data for now)
        model.addAttribute("plans", new String[]{"Plan A", "Plan B", "Plan C"});
        return "plans"; // Renders plans.html
    }

    // Bills Page
    @GetMapping("/bills")
    public String bills(Model model) {
        // Add bills data to the model (mock data for now)
        model.addAttribute("bills", new String[]{"Bill 1", "Bill 2", "Bill 3"});
        return "bills"; // Renders bills.html
    }

    // Handle Create Bill Form Submission
    @PostMapping("/bills")
    public String createBill(@RequestParam("userId") String userId,
                             @RequestParam("amount") double amount,
                             @RequestParam("planId") String planId,
                             Model model) {
        // Process the bill creation (mock logic for now)
        model.addAttribute("message", "Bill created successfully for User ID: " + userId);
        return "bills"; // Redirect to bills.html
    }
}