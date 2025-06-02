package com.EduVerse.model;

import jakarta.persistence.*;
@Entity

@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(name = "payment_amount",nullable = false)
    private int paymentAmount;

    @Column(name = "payment_no",nullable = false)
    private String paymentNo;

    public Payment(int paymentId, int paymentAmount, String paymentNo) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentNo = paymentNo;
    }

    public Payment() {
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDaNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }
}
