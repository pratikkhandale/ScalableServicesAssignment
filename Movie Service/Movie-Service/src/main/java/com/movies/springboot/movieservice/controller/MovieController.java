package com.movies.springboot.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movies.springboot.movieservice.model.Movie;
import com.movies.springboot.movieservice.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

	 @Autowired
	    private MovieService movieService;

	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(movie));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return ResponseEntity.noContent().build();
	}
}
