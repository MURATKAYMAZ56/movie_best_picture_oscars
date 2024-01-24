package com.intake.controller.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovieDto {
    private String id;
    private String title;
    private BigDecimal boxOfficeValue;
}
