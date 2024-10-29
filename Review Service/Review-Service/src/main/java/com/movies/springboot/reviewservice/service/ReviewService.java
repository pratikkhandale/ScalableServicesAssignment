package com.movies.springboot.reviewservice.service;

import java.time.LocalDate;
import java.util.List;

import com.movies.springboot.reviewservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.springboot.reviewservice.model.Review;
import com.movies.springboot.reviewservice.repo.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private final ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public Review saveReview(Review review) {
		review.setReviewDate(LocalDate.now());
		return reviewRepository.save(review);
	}

	public List<Review> getReviewsByMovie(Long movieId) {
		return reviewRepository.findByMovieId(movieId);
	}

	public List<Review> getReviewsByUser(Long userId) {
		return reviewRepository.findByUserId(userId);
	}

	public Review updateReview(Long id, Review reviewDetails) {
		return reviewRepository.findById(id).map(existingReview -> {
			existingReview.setRating(reviewDetails.getRating());
			existingReview.setComment(reviewDetails.getComment());
			existingReview.setReviewDate(LocalDate.now());
			return reviewRepository.save(existingReview);
		}).orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
	}

	public void deleteReview(Long id) {
		reviewRepository.deleteById(id);
	}

}
