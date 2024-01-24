package com.intake.controller;

import com.intake.controller.request.MovieRateRequestDto;
import com.intake.controller.response.CheckAwardResponseDto;
import com.intake.controller.response.MovieDataResponse;
import com.intake.service.MovieBusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/movies")
public class ApiController {

    private final MovieBusinessService movieBusinessService;

    @GetMapping
    public ResponseEntity<MovieDataResponse> findTopTen() {
        return ResponseEntity.ok(movieBusinessService.findTopTen());
    }

    @GetMapping("checkAwards")
    public ResponseEntity<CheckAwardResponseDto> checkAwards(@RequestParam("imdbId") String imdbId) {
        CheckAwardResponseDto responseDto = new CheckAwardResponseDto();
        responseDto.setWon(movieBusinessService.isAwardWon(imdbId));
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping(value = "{imdbId}")
    public ResponseEntity<?> rateMovie(@PathVariable("imdbId") String imdbId, @RequestBody MovieRateRequestDto payload) {
        movieBusinessService.rateMovie(imdbId, payload.getRate());
        return ResponseEntity.ok().build();
    }
}
