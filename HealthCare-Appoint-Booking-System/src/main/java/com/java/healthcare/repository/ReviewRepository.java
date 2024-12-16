package com.java.healthcare.repository;

import com.java.healthcare.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Find Reviews by Doctor ID
    List<Review> findByDoctorId(Long doctorId);

    // Find Reviews by Patient ID
    List<Review> findByPatientId(Long patientId);

    // Find Reviews with a specific rating
    List<Review> findByRating(Integer rating);
}

