package com.skaczmarek.matchmakerappbackend.domain.game;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String gameName;
    @Column
    private Long level;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> playersRank;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> gameTypes;

    public Game() {
    }

    public Game(long id, String gameName, Long level, List<String> playersRank, List<String> gameType) {
        this.gameName = gameName;
        this.level = level;
        this.playersRank = playersRank;
        this.gameTypes = gameType;
    }

    public Game(GameDTO gameDTO){
        this.gameName = gameDTO.getGameName();
        this.level = gameDTO.getLevel();
        this.playersRank = gameDTO.getPlayersRank();
        this.gameTypes = gameDTO.getGameTypes();
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

    public void setGameTypes(List<String> gameType) {
        this.gameTypes = gameType;
    }
}
