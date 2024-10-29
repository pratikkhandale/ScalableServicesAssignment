package com.movies.springboot.recommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.movies.springboot.recommendationservice.model.Recommendation;
import com.movies.springboot.recommendationservice.service.RecommendationService;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
	private final RecommendationService recommendationService;

	public RecommendationController(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}

	@PostMapping
	public ResponseEntity<Recommendation> createRecommendation(@RequestBody Recommendation recommendation) {
		Recommendation createdRecommendation = recommendationService.saveRecommendation(recommendation);
		return new ResponseEntity<>(createdRecommendation, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Recommendation>> getRecommendationsByUser(@PathVariable Long userId) {
		List<Recommendation> recommendations = recommendationService.getRecommendationsByUser(userId);
		return new ResponseEntity<>(recommendations, HttpStatus.OK);
	}

	@GetMapping("/{userId}/genre/{genre}")
	public ResponseEntity<List<Recommendation>> getRecommendationsByGenre(@PathVariable Long userId, @PathVariable String genre) {
		List<Recommendation> recommendations = recommendationService.getRecommendationsByGenre(userId, genre);
		return new ResponseEntity<>(recommendations, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Recommendation> updateRecommendation(@PathVariable Long id, @RequestBody Recommendation recommendation) {
		Recommendation updatedRecommendation = recommendationService.updateRecommendation(id, recommendation);
		return new ResponseEntity<>(updatedRecommendation, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecommendation(@PathVariable Long id) {
		recommendationService.deleteRecommendation(id);
		return ResponseEntity.noContent().build();
	}
}
