package com.intake.service;

import com.intake.dao.entity.Movie;
import com.intake.dao.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public Page<Movie> findTopTen() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("boxOfficeValue").descending());
        return movieRepository.findTopTen(pageRequest);
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> findById(String id) {
        return movieRepository.findById(id);
    }
}
