package com.intake.service;

import com.intake.dao.entity.Movie;
import com.intake.dao.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void testSaveMovie(){
        Mockito.when(movieRepository.save(Mockito.any())).thenReturn(buildEntity());

        Movie result = movieService.save(buildEntity());
        Assertions.assertNotNull(result);
    }

    private Movie buildEntity() {
        Movie entity = new Movie();
        entity.setImdbId("tt123");
        entity.setTitle("test");
        entity.setRate(1.1);
        entity.setBoxOfficeValue(BigDecimal.ONE);
        return entity;
    }
}
