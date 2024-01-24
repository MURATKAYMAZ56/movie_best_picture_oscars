package com.intake.service;

import com.intake.client.OmdbApiClient;
import com.intake.controller.response.MovieDataResponse;
import com.intake.dao.entity.Movie;
import com.intake.service.csv.AcademyAwardsCsvLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class MovieBusinessServiceTest {
    @Mock
    OmdbApiClient omdbApiClient;
    @Mock
    AcademyAwardsCsvLoader csvLoader;
    @Mock
    MovieService movieService;
    @InjectMocks
    MovieBusinessService movieBusinessService;

    @Test
    public void testFindTopTen() {
        Mockito.when(movieService.findTopTen()).thenReturn(new PageImpl<>(List.of(buildMovieEntity())));

        MovieDataResponse result = movieBusinessService.findTopTen();

        Assertions.assertNotNull(result);
        Assertions.assertFalse(CollectionUtils.isEmpty(result.getData()));
    }

    private Movie buildMovieEntity() {
        Movie movie = new Movie();
        movie.setImdbId("tt111");
        movie.setTitle("test");
        movie.setRate(1.1);
        movie.setBoxOfficeValue(BigDecimal.ONE);
        return movie;
    }
}
