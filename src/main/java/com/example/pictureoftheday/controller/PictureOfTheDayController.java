package com.example.pictureoftheday.controller;

import com.example.pictureoftheday.service.PictureOfTheDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PictureOfTheDayController {

    private final PictureOfTheDayService service;

    @GetMapping(value = "/")
    public ResponseEntity getPictureOfTheDay(){

        return service.getPictureOfTheDay();
    }
}
