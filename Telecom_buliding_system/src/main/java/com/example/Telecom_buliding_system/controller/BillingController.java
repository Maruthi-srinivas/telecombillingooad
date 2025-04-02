package com.example.Telecom_buliding_system.controller;

import com.example.Telecom_buliding_system.entity.Bill;
import com.example.Telecom_buliding_system.service.BillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillingController {
    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return billingService.getAllBills();
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billingService.createBill(bill);
    }
}