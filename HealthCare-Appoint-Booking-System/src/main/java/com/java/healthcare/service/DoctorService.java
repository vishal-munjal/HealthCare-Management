package com.java.healthcare.service;

import com.java.healthcare.entity.Doctor;
import com.java.healthcare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Create or Update Doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Get Doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // Get Doctor by User ID
    public Optional<Doctor> getDoctorByUserId(Long userId) {
        return doctorRepository.findByUserId(userId);
    }

    // Get Doctors by Specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    // Get Available Doctors by Specialization and Timeslot
    public List<Doctor> getAvailableDoctors(String specialization, String timeslot) {
        return doctorRepository.findAvailableDoctorsBySpecializationAndTimeslot(specialization, timeslot);
    }

    // Get All Doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Delete Doctor by ID
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}

