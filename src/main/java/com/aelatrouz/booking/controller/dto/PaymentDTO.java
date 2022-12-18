package com.aelatrouz.booking.controller.dto;


import com.sun.istack.NotNull;

public class PaymentDTO {

    @NotNull
    private Double amount;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String paymentStatus;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

