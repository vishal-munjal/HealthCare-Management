package com.java.healthcare.repository;

import com.java.healthcare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Find Appointments by Patient ID
    List<Appointment> findByPatientId(Long patientId);

    // Find Appointments by Doctor ID
    List<Appointment> findByDoctorId(Long doctorId);

    // Find Appointments within a specific time range
    List<Appointment> findByAppointmentDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find Appointments by Status
    List<Appointment> findByStatus(Appointment.Status status);
}

