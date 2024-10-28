package com.movies.springboot.movieservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movies.springboot.movieservice.model.Movie;
import com.movies.springboot.movieservice.repository.MovieRepository;

@Service
public class MovieService {

	 @Autowired
	    private MovieRepository movieRepository;

	    public Movie createMovie(Movie movie) {
	        return movieRepository.save(movie);
	    }

		public Movie getMovieById(Long id) {
			return movieRepository.findById(id).orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found with id: " + id));
			
		}
}
