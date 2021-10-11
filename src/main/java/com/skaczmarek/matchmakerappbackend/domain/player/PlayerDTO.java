package com.skaczmarek.matchmakerappbackend.domain.player;


public class PlayerDTO {

    private long id;
    private String gameRank;
    private long level;


    public PlayerDTO(String gameRank, long level) {
        this.gameRank = gameRank;
        this.level = level;
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
