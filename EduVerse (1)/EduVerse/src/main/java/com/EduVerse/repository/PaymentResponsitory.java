package com.EduVerse.repository;

import com.EduVerse.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentResponsitory extends JpaRepository<Payment, Integer> {
}
