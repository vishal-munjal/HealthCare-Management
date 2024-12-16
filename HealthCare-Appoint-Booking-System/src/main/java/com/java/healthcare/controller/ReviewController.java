package com.java.healthcare.controller;

import com.java.healthcare.entity.Review;
import com.java.healthcare.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Create or Update Review
    @PostMapping("/saveReview")
    public ResponseEntity<Review> saveReview(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        return ResponseEntity.ok(savedReview);
    }

    // Get Reviews by Doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Review>> getReviewsByDoctorId(@PathVariable Long doctorId) {
        List<Review> reviews = reviewService.getReviewsByDoctorId(doctorId);
        return ResponseEntity.ok(reviews);
    }

    // Get Reviews by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Review>> getReviewsByPatientId(@PathVariable Long patientId) {
        List<Review> reviews = reviewService.getReviewsByPatientId(patientId);
        return ResponseEntity.ok(reviews);
    }

    // Get Reviews with Specific Rating
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Review>> getReviewsByRating(@PathVariable Integer rating) {
        List<Review> reviews = reviewService.getReviewsByRating(rating);
        return ResponseEntity.ok(reviews);
    }

    // Get All Reviews
    @GetMapping("/getAllReviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    // Delete Review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }
}
