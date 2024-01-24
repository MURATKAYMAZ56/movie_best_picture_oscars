package com.intake.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    private String imdbId;

    private String title;

    private double rate;

    private BigDecimal boxOfficeValue;
}
