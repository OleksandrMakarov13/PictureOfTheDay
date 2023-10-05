package com.example.pictureoftheday.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PictureOfTheDayService {

    private static final String NASA_KEY_VALUE = "eBQUKf4CJvXCb4sKcVWYW0uQT4lKmufdNDPsLwT2";
    private static final String NASA_KEY_NAME = "api_key";
    private static final String URL = "https://api.nasa.gov/planetary/apod";
    RestTemplate restTemplate = new RestTemplate();


    public ResponseEntity<byte[]> getPictureOfTheDay() {
        String url = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam(NASA_KEY_NAME, NASA_KEY_VALUE)
                .toUriString();

        JsonNode json = restTemplate.getForObject(url, JsonNode.class);

        assert json != null;
        JsonNode jsonNode = json.get("hdurl");

        return restTemplate.getForEntity(jsonNode.asText(), byte[].class);
    }
}
