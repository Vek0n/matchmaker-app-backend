package com.skaczmarek.matchmakerappbackend.domain.game;

import java.util.List;

public class GameDTO {
    private String gameName;
    private Long level;
    private List<String> playersRank;
    private List<String> gameTypes;

    public GameDTO(String gameName, Long level, List<String> playersRank, List<String> gameTypes) {
        this.gameName = gameName;
        this.level = level;
        this.playersRank = playersRank;
        this.gameTypes = gameTypes;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public List<String> getPlayersRank() {
        return playersRank;
    }

    public void setPlayersRank(List<String> playersRank) {
        this.playersRank = playersRank;
    }

    public List<String> getGameTypes() {
        return gameTypes;
    }

    public void setGameTypes(List<String> gameTypes) {
        this.gameTypes = gameTypes;
    }
}
