package com.intake.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intake.controller.request.MovieRateRequestDto;
import com.intake.controller.response.CheckAwardResponseDto;
import com.intake.service.MovieBusinessService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ApiController.class)
public class ApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MovieBusinessService movieBusinessService;
    @Test
    void testCheckAwards_whenValidInput_thenReturns200() throws Exception {
        CheckAwardResponseDto expectedResponseDto = buildMovieResponseDto();

        Mockito.when(movieBusinessService.isAwardWon(Mockito.any())).thenReturn(expectedResponseDto.isWon());


        MvcResult mvcResult =  mockMvc.perform(get("/api/movies/checkAwards?imdbId=123")
                                .contentType("application/json"))
                                .andExpect(status().is2xxSuccessful())
                                .andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("{\"won\":true}", actualResponseBody);
    }
    private CheckAwardResponseDto buildMovieResponseDto() {
        CheckAwardResponseDto responseDto = new CheckAwardResponseDto();
        responseDto.setWon(true);
        return responseDto;
    }


}
