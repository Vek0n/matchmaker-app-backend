package com.skaczmarek.matchmakerappbackend.controller;


import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import com.skaczmarek.matchmakerappbackend.domain.game.GameDTO;
import com.skaczmarek.matchmakerappbackend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(value = "/games")
    public List<Game> getAllCars(){
        return gameService.getAllGames();
    }

    @PostMapping(value = "/games")
    public Game addGame(@RequestBody GameDTO gameDTO){
        return gameService.addGame(gameDTO);
    }


}
