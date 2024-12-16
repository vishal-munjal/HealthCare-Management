package com.java.healthcare.controller;

import com.java.healthcare.entity.Payment;
import com.java.healthcare.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create or Update Payment
    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savePayment(payment);
        return ResponseEntity.ok(savedPayment);
    }

    // Get Payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.isPresent() ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }

    // Get Payment by Appointment ID
    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<Optional<Payment>> getPaymentByAppointmentId(@PathVariable Long appointmentId) {
        Optional<Payment> payment = paymentService.getPaymentByAppointmentId(appointmentId);
        return payment.isPresent() ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }

    // Get Payments by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Payment>> getPaymentsByStatus(@PathVariable Payment.PaymentStatus status) {
        List<Payment> payments = paymentService.getPaymentsByStatus(status);
        return ResponseEntity.ok(payments);
    }

    // Get All Payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    // Delete Payment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
        return ResponseEntity.noContent().build();
    }
}
