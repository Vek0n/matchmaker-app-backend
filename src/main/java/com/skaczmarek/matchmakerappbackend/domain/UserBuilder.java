package com.skaczmarek.matchmakerappbackend.domain;

public class UserBuilder {
    private long id;
    private String username;
    private String password;

    public UserBuilder() {
    }

    public UserBuilder defaultUser(){
        this.id = 1;
        this.username = "Grzmot";
        this.password = "pass";
        return this;
    }

    public User build(){
        return new User(id,username, password);
    }

}
