package com.intake.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class MovieDataResponse {
    private List<MovieDto> data;
}
