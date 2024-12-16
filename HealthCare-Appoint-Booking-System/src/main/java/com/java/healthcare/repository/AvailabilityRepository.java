package com.java.healthcare.repository;
import com.java.healthcare.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    // Find Availability by Doctor ID
    List<Availability> findByDoctorId(Long doctorId);

    // Find Availability by Day of the Week
    List<Availability> findByDoctorIdAndDayOfWeek(Long doctorId, Availability.DayOfWeek dayOfWeek);
}
