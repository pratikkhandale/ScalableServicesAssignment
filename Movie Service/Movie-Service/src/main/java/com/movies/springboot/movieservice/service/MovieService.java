package com.movies.springboot.movieservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movies.springboot.movieservice.model.Movie;
import com.movies.springboot.movieservice.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

	 @Autowired
	    private MovieRepository movieRepository;

	    public Movie createMovie(Movie movie) {
	        return movieRepository.save(movie);
	    }

	public Optional<Movie> getMovieById(Long id) {
		return movieRepository.findById(id);
	}

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
}
