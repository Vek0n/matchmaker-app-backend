package com.skaczmarek.matchmakerappbackend.domain.player;


import com.skaczmarek.matchmakerappbackend.domain.user.User;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    private String gameRank;

    private long level;

    public Player() {
    }

    public Player(User user, PlayerDTO playerDTO) {
        this.user = user;
        this.gameRank = playerDTO.getGameRank();
        this.level = playerDTO.getLevel();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getGameRank() {
        return gameRank;
    }

    public void setGameRank(String gameRank) {
        this.gameRank = gameRank;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }
}