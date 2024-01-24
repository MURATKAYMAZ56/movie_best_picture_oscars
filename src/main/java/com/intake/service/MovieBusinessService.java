package com.intake.service;

import com.intake.client.OmdbApiClient;
import com.intake.client.model.Movie;
import com.intake.controller.response.MovieDataResponse;
import com.intake.controller.response.MovieDto;
import com.intake.enums.AwardCategory;
import com.intake.enums.WonStatus;
import com.intake.service.csv.AcademyAwardsCsvLoader;
import com.intake.service.csv.CsvModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovieBusinessService {
    private final OmdbApiClient omdbApiClient;
    private final AcademyAwardsCsvLoader csvLoader;
    private final MovieService movieService;

    public MovieDataResponse findTopTen() {
        System.out.println("MRT here");
        Page<com.intake.dao.entity.Movie> movies = movieService.findTopTen();

        MovieDataResponse response = new MovieDataResponse();
        response.setData(movies.getContent().stream().map(item -> {
            MovieDto dto = new MovieDto();
            dto.setId(item.getImdbId());
            dto.setTitle(item.getTitle());
            dto.setBoxOfficeValue(item.getBoxOfficeValue());
            return dto;
        }).collect(Collectors.toList()));

        return response;
    }

    public boolean isAwardWon(String imdbId) {

        Movie movie = omdbApiClient.findMovie(imdbId);
        log.info("movie : {}", movie);

        CsvModel csvModel = csvLoader.findById(movie.getYear(), AwardCategory.BEST_PICTURE.getValue(), movie.getTitle());
        log.info("csvModel : {}", csvModel);

        return Optional.ofNullable(csvModel)
                .map((item) -> WonStatus.YES.getValue().equalsIgnoreCase(item.getWon()))
                .orElse(false);
    }

    public void rateMovie(String imdbId, double rate) {

        Movie movieModel = omdbApiClient.findMovie(imdbId);
        com.intake.dao.entity.Movie movie = movieService.findById(imdbId).orElse(new com.intake.dao.entity.Movie());
        movie.setImdbId(imdbId);
        movie.setRate(rate);
        movie.setTitle(movieModel.getTitle());
        movie.setBoxOfficeValue(new BigDecimal(movieModel.getBoxOffice().replaceAll("[,\\$]", "")));

        movieService.save(movie);
    }
}
