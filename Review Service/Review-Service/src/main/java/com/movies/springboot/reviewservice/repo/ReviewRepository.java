package com.movies.springboot.reviewservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.springboot.reviewservice.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByMovieId(Long movieId);
	List<Review> findByUserId(Long userId);
}
