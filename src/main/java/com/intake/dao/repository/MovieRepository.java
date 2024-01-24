package com.intake.dao.repository;

import com.intake.dao.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, String>, PagingAndSortingRepository<Movie, String> {

    @Query("select a from Movie a")
    Page<Movie> findTopTen(Pageable pageable);
}
