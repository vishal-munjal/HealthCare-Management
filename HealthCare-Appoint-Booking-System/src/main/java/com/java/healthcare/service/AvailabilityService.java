package com.java.healthcare.service;

import com.java.healthcare.entity.Availability;
import com.java.healthcare.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    // Create or Update Availability
    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    // Get Availability by ID
    public Optional<Availability> getAvailabilityById(Long id) {
        return availabilityRepository.findById(id);
    }

    // Get All Availability Slots
    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    // Get Availability Slots for a Specific Doctor
    public List<Availability> getAvailabilityByDoctorId(Long doctorId) {
        return availabilityRepository.findByDoctorId(doctorId);
    }

    // Get Availability Slots for a Specific Day of the Week for a Doctor
    public List<Availability> getAvailabilityByDoctorAndDay(Long doctorId, Availability.DayOfWeek dayOfWeek) {
        return availabilityRepository.findByDoctorIdAndDayOfWeek(doctorId, dayOfWeek);
    }

    // Delete Availability by ID
    public void deleteAvailabilityById(Long id) {
        availabilityRepository.deleteById(id);
    }

    // Delete All Availability Slots for a Specific Doctor
    public void deleteAvailabilityByDoctorId(Long doctorId) {
        List<Availability> slots = availabilityRepository.findByDoctorId(doctorId);
        availabilityRepository.deleteAll(slots);
    }
}

