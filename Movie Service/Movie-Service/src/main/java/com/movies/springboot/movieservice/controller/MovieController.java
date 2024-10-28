package com.movies.springboot.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.springboot.movieservice.model.Movie;
import com.movies.springboot.movieservice.service.MovieService;

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
	    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
	        return ResponseEntity.ok(movieService.getMovieById(id));
	    }
}
