package com.skaczmarek.matchmakerappbackend.controller;

import com.skaczmarek.matchmakerappbackend.domain.player.Player;
import com.skaczmarek.matchmakerappbackend.domain.player.PlayerDTO;
import com.skaczmarek.matchmakerappbackend.service.GameNotFoundException;
import com.skaczmarek.matchmakerappbackend.service.PlayerService;
import com.skaczmarek.matchmakerappbackend.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping(value = "/players/{userId}")
    public Player createPlayer(@PathVariable long userId, @RequestBody PlayerDTO playerDTO) throws UserNotFoundException {
        return playerService.createPlayer(userId, playerDTO);
    }

    @GetMapping(value = "/players")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }
}
