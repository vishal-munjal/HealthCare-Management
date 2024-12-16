package com.java.healthcare.service;

import com.java.healthcare.entity.Review;
import com.java.healthcare.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Create or Update Review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get Reviews by Doctor ID
    public List<Review> getReviewsByDoctorId(Long doctorId) {
        return reviewRepository.findByDoctorId(doctorId);
    }

    // Get Reviews by Patient ID
    public List<Review> getReviewsByPatientId(Long patientId) {
        return reviewRepository.findByPatientId(patientId);
    }

    // Get Reviews with Specific Rating
    public List<Review> getReviewsByRating(Integer rating) {
        return reviewRepository.findByRating(rating);
    }

    // Get All Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Delete Review by ID
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}