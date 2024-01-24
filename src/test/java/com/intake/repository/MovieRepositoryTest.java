package com.intake.repository;

import com.intake.dao.entity.Movie;
import com.intake.dao.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Sql("findTopTen.sql")
    void testFindTopTen() {
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("boxOfficeValue").descending());
        Page<Movie> result = movieRepository.findTopTen(pageRequest);

        Assertions.assertNotNull(result);
        Assertions.assertFalse(CollectionUtils.isEmpty(result.getContent()));
        Assertions.assertEquals(0, BigDecimal.valueOf(515.11).compareTo(result.getContent().get(0).getBoxOfficeValue()));
        Assertions.assertEquals(0, BigDecimal.valueOf(313.11).compareTo(result.getContent().get(2).getBoxOfficeValue()));
    }
}
