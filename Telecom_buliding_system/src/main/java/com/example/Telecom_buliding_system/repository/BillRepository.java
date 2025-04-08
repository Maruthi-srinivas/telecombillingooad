package com.example.Telecom_buliding_system.repository;

import com.example.Telecom_buliding_system.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByUserId(Long userId); // Fetch bills by user ID
}
