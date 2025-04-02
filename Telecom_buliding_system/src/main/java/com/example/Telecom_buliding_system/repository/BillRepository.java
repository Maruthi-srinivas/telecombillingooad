package com.example.Telecom_buliding_system.repository;

import com.example.Telecom_buliding_system.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}