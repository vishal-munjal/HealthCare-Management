package com.java.healthcare.repository;

import com.java.healthcare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Find Doctor by User ID
    Optional<Doctor> findByUserId(Long userId);

    // Find Doctors by Specialization
    List<Doctor> findBySpecialization(String specialization);

    // Custom query for available timeslot filtering
    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization AND d.availableTimeslot LIKE %:timeslot%")
    List<Doctor> findAvailableDoctorsBySpecializationAndTimeslot(@Param("specialization") String specialization, @Param("timeslot") String timeslot);
}

