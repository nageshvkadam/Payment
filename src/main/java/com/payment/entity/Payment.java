package com.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String name;
private double amount;
private String orderId;
private String PaymentId;
private String status;
}

