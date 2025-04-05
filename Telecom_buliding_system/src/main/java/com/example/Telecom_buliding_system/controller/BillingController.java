package com.example.Telecom_buliding_system.controller;

import com.example.Telecom_buliding_system.entity.Bill;
import com.example.Telecom_buliding_system.entity.Plan;
import com.example.Telecom_buliding_system.entity.User;
import com.example.Telecom_buliding_system.repository.PlanRepository;
import com.example.Telecom_buliding_system.repository.UserRepository;
import com.example.Telecom_buliding_system.service.BillingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/bills")
public class BillingController {

    private final BillingService billingService;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    public BillingController(BillingService billingService, UserRepository userRepository, PlanRepository planRepository) {
        this.billingService = billingService;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    @PostMapping
    public String createBill(@RequestParam("userId") Long userId,
            @RequestParam("amount") Double amount,
            @RequestParam("planId") Long planId,
            Model model) {
        // Fetch User and Plan from the database
        Optional<User> user = userRepository.findById(userId);
        Optional<Plan> plan = planRepository.findById(planId);

        if (user.isPresent() && plan.isPresent()) {
            // Create and save the bill
            Bill bill = new Bill();
            bill.setUser(user.get());
            bill.setPlan(plan.get());
            bill.setAmount(amount);
            bill.setStatus("Pending");
            billingService.createBill(bill);
            model.addAttribute("message", "Bill created successfully!");
        } else {
            model.addAttribute("error", "Invalid User ID or Plan ID.");
        }

        // Fetch all bills and pass them to the template
        model.addAttribute("bills", billingService.getAllBills());
        return "bills";
    }

    @GetMapping
    public String getAllBills(Model model) {
        // Fetch all bills from the database
        model.addAttribute("bills", billingService.getAllBills());
        return "bills"; // Render the bills.html template
    }
}
