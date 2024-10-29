package com.movies.springboot.recommendationservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.movies.springboot.recommendationservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.springboot.recommendationservice.model.Recommendation;
import com.movies.springboot.recommendationservice.repo.RecommendationRepository;

@Service
public class RecommendationService {

	private final RecommendationRepository recommendationRepository;

	public RecommendationService(RecommendationRepository recommendationRepository) {
		this.recommendationRepository = recommendationRepository;
	}

	public Recommendation saveRecommendation(Recommendation recommendation) {
		recommendation.setRecommendationDate(LocalDate.now());
		return recommendationRepository.save(recommendation);
	}

	public List<Recommendation> getRecommendationsByUser(Long userId) {
		return recommendationRepository.findByUserId(userId);
	}

	public List<Recommendation> getRecommendationsByGenre(Long userId, String genre) {
		return recommendationRepository.findByUserIdAndGenre(userId, genre);
	}

	public Recommendation updateRecommendation(Long id, Recommendation recommendationDetails) {
		return recommendationRepository.findById(id).map(existingRecommendation -> {
			existingRecommendation.setMovieId(recommendationDetails.getMovieId());
			existingRecommendation.setGenre(recommendationDetails.getGenre());
			existingRecommendation.setRecommendationDate(LocalDate.now());
			return recommendationRepository.save(existingRecommendation);
		}).orElseThrow(() -> new ResourceNotFoundException("Recommendation not found with id " + id));
	}

	public void deleteRecommendation(Long id) {
		recommendationRepository.deleteById(id);
	}

}
