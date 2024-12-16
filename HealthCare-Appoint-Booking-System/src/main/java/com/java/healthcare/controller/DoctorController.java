package com.java.healthcare.controller;

import com.java.healthcare.entity.Doctor;
import com.java.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Create or Update Doctor
    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    // Get Doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        return doctor.isPresent() ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    // Get Doctor by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<Doctor>> getDoctorByUserId(@PathVariable Long userId) {
        Optional<Doctor> doctor = doctorService.getDoctorByUserId(userId);
        return doctor.isPresent() ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    // Get Doctors by Specialization
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) {
        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
        return ResponseEntity.ok(doctors);
    }

    // Get Available Doctors by Specialization and Timeslot
    @GetMapping("/availability")
    public ResponseEntity<List<Doctor>> getAvailableDoctors(@RequestParam String specialization,
                                                            @RequestParam String timeslot) {
        List<Doctor> doctors = doctorService.getAvailableDoctors(specialization, timeslot);
        return ResponseEntity.ok(doctors);
    }

    // Get All Doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    // Delete Doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }
}