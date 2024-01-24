package com.intake.client;

import com.intake.client.config.OmdbApiConfig;
import com.intake.client.model.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class OmdbApiClient {

    private final OmdbApiConfig apiConfig;
    private final RestTemplate restTemplate;

    public Movie findMovie(String imdbId) {
        String url = apiConfig.getUrl() + "/?i={imdbId}&apikey={apiKey}";
        String apiKey = apiConfig.getApiKey();
        return restTemplate.getForEntity(url, Movie.class, imdbId, apiKey).getBody();
    }
}
