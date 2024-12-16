package com.java.healthcare.controller;

import com.java.healthcare.entity.Availability;
import com.java.healthcare.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    // Create or Update Availability
    @PostMapping
    public ResponseEntity<Availability> saveAvailability(@RequestBody Availability availability) {
        Availability savedAvailability = availabilityService.saveAvailability(availability);
        return ResponseEntity.ok(savedAvailability);
    }

    // Get Availability by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Availability>> getAvailabilityById(@PathVariable Long id) {
        Optional<Availability> availability = availabilityService.getAvailabilityById(id);
        return availability.isPresent() ? ResponseEntity.ok(availability) : ResponseEntity.notFound().build();
    }

    // Get All Availability Slots
    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailability() {
        List<Availability> availabilityList = availabilityService.getAllAvailability();
        return ResponseEntity.ok(availabilityList);
    }

    // Get Availability Slots for a Specific Doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Availability>> getAvailabilityByDoctorId(@PathVariable Long doctorId) {
        List<Availability> availabilityList = availabilityService.getAvailabilityByDoctorId(doctorId);
        return ResponseEntity.ok(availabilityList);
    }

    // Get Availability Slots for a Specific Day of the Week for a Doctor
    @GetMapping("/doctor/{doctorId}/day/{dayOfWeek}")
    public ResponseEntity<List<Availability>> getAvailabilityByDoctorAndDay(@PathVariable Long doctorId,
                                                                            @PathVariable Availability.DayOfWeek dayOfWeek) {
        List<Availability> availabilityList = availabilityService.getAvailabilityByDoctorAndDay(doctorId, dayOfWeek);
        return ResponseEntity.ok(availabilityList);
    }

    // Delete Availability by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailabilityById(@PathVariable Long id) {
        availabilityService.deleteAvailabilityById(id);
        return ResponseEntity.noContent().build();
    }

    // Delete All Availability Slots for a Specific Doctor
    @DeleteMapping("/doctor/{doctorId}")
    public ResponseEntity<Void> deleteAvailabilityByDoctorId(@PathVariable Long doctorId) {
        availabilityService.deleteAvailabilityByDoctorId(doctorId);
        return ResponseEntity.noContent().build();
    }
}