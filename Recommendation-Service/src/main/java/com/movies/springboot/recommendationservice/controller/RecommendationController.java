package com.movies.springboot.recommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movies.springboot.recommendationservice.model.Recommendation;
import com.movies.springboot.recommendationservice.service.RecommendationService;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
	private final RestTemplate restTemplate;

	public RecommendationController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Autowired
	private RecommendationService recommendationService;

	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getRecommendations(@PathVariable Long userId) {
		return ResponseEntity.ok(restTemplate.getForObject("http://User-service/users/"+ userId, Object.class));
	}

}
