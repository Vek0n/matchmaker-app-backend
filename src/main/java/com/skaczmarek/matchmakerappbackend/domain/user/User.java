package com.skaczmarek.matchmakerappbackend.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import com.skaczmarek.matchmakerappbackend.domain.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    public User() {
    }

    User(long userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}