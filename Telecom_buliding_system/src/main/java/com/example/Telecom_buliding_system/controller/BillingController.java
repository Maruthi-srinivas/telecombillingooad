package com.example.Telecom_buliding_system.controller;

import com.example.Telecom_buliding_system.entity.Bill;
import com.example.Telecom_buliding_system.repository.BillRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BillingController {

    private final BillRepository billRepository;

    public BillingController (BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    // Display the bills page
    @GetMapping("/bills")
    public String showBills(Model model) {
        // Fetch bills from the database
        List<Bill> bills = billRepository.findAll();
        model.addAttribute("bills", bills);
        return "bills"; // Renders bills.html
    }
}