package com.movies.springboot.reviewservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movies.springboot.reviewservice.model.Review;
import com.movies.springboot.reviewservice.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Review review) {
		Review createdReview = reviewService.saveReview(review);
		return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
	}

	@GetMapping("/movie/{movieId}")
	public ResponseEntity<List<Review>> getReviewsByMovie(@PathVariable Long movieId) {
		List<Review> reviews = reviewService.getReviewsByMovie(movieId);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Long userId) {
		List<Review> reviews = reviewService.getReviewsByUser(userId);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
		Review updatedReview = reviewService.updateReview(id, reviewDetails);
		return new ResponseEntity<>(updatedReview, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
		return ResponseEntity.noContent().build();
	}
}
