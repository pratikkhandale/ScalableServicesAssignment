package com.movies.springboot.recommendationservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.springboot.recommendationservice.model.Recommendation;
import com.movies.springboot.recommendationservice.repo.RecommendationRepository;

@Service
public class RecommendationService {
	
	@Autowired
	private RecommendationRepository recommendationRepository;
	

	public List<Recommendation> getRecommendationsForUser(Long userId) {
		// generating recommendations based on user preferences
		Recommendation recommendation = new Recommendation();
		recommendation.setUserId(userId);
		recommendation.setMovieId(recommendation.getMovieId());
		recommendation.setReason("Based on your viewing history");
		recommendationRepository.save(recommendation);
		return new ArrayList<>();
	}

	public List<Long> getRecommendedMoviesForUser(Long userId) {
		// Placeholder for recommendation logic
		return List.of(1L, 2L, 3L);  // Dummy movie IDs
	}

}
