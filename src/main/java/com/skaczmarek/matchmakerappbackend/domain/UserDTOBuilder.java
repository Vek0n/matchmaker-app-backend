package com.skaczmarek.matchmakerappbackend.domain;

public class UserDTOBuilder {
    private String username;
    private String password;

    public UserDTOBuilder defaultUser(){
        this.username = "Grzmot";
        this.password = "pass";
        return this;
    }

    public UserDTO build(){
        return new UserDTO(this.username, this.password);
    }
}
