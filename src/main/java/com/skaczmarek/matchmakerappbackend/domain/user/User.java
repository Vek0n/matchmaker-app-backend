package com.skaczmarek.matchmakerappbackend.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skaczmarek.matchmakerappbackend.domain.game.Game;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

//    @Column
//    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
//    private ArrayList<GameClass> gameList;

    public User() {
    }

    User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    User(long id, String username, String password, ArrayList<Game> games) {
        this.id = id;
        this.username = username;
        this.password = password;
//        this.gameList = games;
    }

//    public void setGameList(ArrayList<GameClass> gameList) {
//        this.gameList = gameList;
//    }

//    public ArrayList<GameClass> getGameList() {
//        return gameList;
//    }

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