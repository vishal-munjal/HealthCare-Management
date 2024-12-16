package com.java.healthcare.service;

import com.java.healthcare.entity.Payment;
import com.java.healthcare.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
   private PaymentRepository paymentRepository;

    // Create or Update Payment
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get Payment by ID
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Get Payment by Appointment ID
    public Optional<Payment> getPaymentByAppointmentId(Long appointmentId) {
        return paymentRepository.findByAppointmentId(appointmentId);
    }

    // Get Payments by Status
    public List<Payment> getPaymentsByStatus(Payment.PaymentStatus status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    // Get All Payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Delete Payment by ID
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}

