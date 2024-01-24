package com.intake.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "api.omdb")
public class OmdbApiConfig {

    private String apiKey;
    private String url;
}
