package com.movies.springboot.recommendationservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.springboot.recommendationservice.model.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long>{

	List<Recommendation> findByUserId(Long userId);
}
