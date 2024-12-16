package com.java.healthcare.repository;
import com.java.healthcare.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find Payment by Appointment ID
    Optional<Payment> findByAppointmentId(Long appointmentId);

    // Find Payments by Status
    List<Payment> findByPaymentStatus(Payment.PaymentStatus paymentStatus);
}
