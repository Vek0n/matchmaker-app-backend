package com.skaczmarek.matchmakerappbackend.service;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{
    UserNotFoundException(long id){
        super("User with id: "+ id + " not found.");
    }
}