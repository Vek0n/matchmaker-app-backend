package com.skaczmarek.matchmakerappbackend.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GameNotFoundException extends Exception{
    GameNotFoundException(long id){
        super("Game with id: "+ id + " not found.");
    }
}
