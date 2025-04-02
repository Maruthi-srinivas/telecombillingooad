package com.example.Telecom_buliding_system.entity;

import jakarta.persistence.*;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String description;

    // Getters and Setters
}