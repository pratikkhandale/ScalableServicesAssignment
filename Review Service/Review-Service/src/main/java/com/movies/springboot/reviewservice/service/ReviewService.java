package com.movies.springboot.reviewservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.springboot.reviewservice.model.Review;
import com.movies.springboot.reviewservice.repo.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public Review createReview(Review review) {
		return reviewRepository.save(review);
	}

	public List<Review> getReviewsByMovie(Long movieId) {
		return reviewRepository.findByMovieId(movieId);
	}

}
