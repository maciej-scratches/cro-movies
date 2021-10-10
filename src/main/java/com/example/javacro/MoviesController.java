package com.example.javacro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
public class MoviesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesController.class);
    private final MovieService movieService;
    private final Random random = new Random();

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    List<MovieDTO> movies() {
        LOGGER.info("Loading movies");
        List<MovieDTO> movies = movieService.movies();
        if (random.nextInt() % 3 == 0) {
            throw new IllegalStateException("something went wrooong");
        }
        return movies;
    }
}
