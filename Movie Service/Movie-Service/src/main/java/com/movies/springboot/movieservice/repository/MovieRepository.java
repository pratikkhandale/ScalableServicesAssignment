package com.movies.springboot.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.springboot.movieservice.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	 List<Movie> findByGenre(String genre);
}
