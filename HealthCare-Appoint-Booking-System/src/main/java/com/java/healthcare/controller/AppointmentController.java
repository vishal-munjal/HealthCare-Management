package com.java.healthcare.controller;

import com.java.healthcare.entity.Appointment;
import com.java.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Create or Update an Appointment
    @PostMapping("/saveAppointment")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    // Get Appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Appointment>> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.isPresent() ? ResponseEntity.ok(appointment) : ResponseEntity.notFound().build();
    }

    // Get Appointments by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(appointments);
    }

    // Get Appointments by Doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }

    // Get Appointments within a Date Range
    @GetMapping("/date-range")
    public ResponseEntity<List<Appointment>> getAppointmentsBetweenDates(@RequestParam LocalDateTime startDate,
                                                                         @RequestParam LocalDateTime endDate) {
        List<Appointment> appointments = appointmentService.getAppointmentsBetweenDates(startDate, endDate);
        return ResponseEntity.ok(appointments);
    }

    // Get Appointments by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(@PathVariable Appointment.Status status) {
        List<Appointment> appointments = appointmentService.getAppointmentsByStatus(status);
        return ResponseEntity.ok(appointments);
    }

    // Get All Appointments
    @GetMapping("/getAllAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    // Delete Appointment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.noContent().build();
    }
}
