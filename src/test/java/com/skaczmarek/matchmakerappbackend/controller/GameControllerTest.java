package com.skaczmarek.matchmakerappbackend.controller;

import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import com.skaczmarek.matchmakerappbackend.domain.game.GameBuilder;
import com.skaczmarek.matchmakerappbackend.service.GameNotFoundException;
import com.skaczmarek.matchmakerappbackend.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


//@RunWith(SpringRunner.class)
//@WebMvcTest(GameController.class)
//@ComponentScan(basePackages = {"com.skaczmarek.matchmakerappbackend"})
//public class GameControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private GameService gameServiceMock;
//
//    @Test
//    public void shouldGetGame() throws Exception {
//        Game givenGame = new GameBuilder()
//                .defaultGame()
//                .build();
//
//        given(gameServiceMock.getGame(givenGame.getId())).willReturn(givenGame);
//
//        mvc.perform(get("/games/" + givenGame.getId())
//        .contentType(MediaType.ALL))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(givenGame.getId()))
//                .andExpect(jsonPath("$.gameName").value(givenGame.getGameName()));
//    }
//}
