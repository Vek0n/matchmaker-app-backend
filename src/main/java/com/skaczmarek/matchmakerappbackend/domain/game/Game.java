package com.skaczmarek.matchmakerappbackend.domain.game;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;


@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(unique=true, nullable=false)
    private long id;
    @Column
    private String gameName;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> availableRanks;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> gameTypes;

    public Game() {
    }

    public Game(long id, String gameName, List<String> availableRanks, List<String> gameType) {
        this.gameName = gameName;
        this.availableRanks = availableRanks;
        this.gameTypes = gameType;
    }

    public Game(GameDTO gameDTO){
        this.gameName = gameDTO.getGameName();
        this.availableRanks = gameDTO.getAvailableRanks();
        this.gameTypes = gameDTO.getGameTypes();
    }

    public Game(long id, GameDTO gameDTO) {
        this.id = id;
        this.gameName = gameDTO.getGameName();
        this.availableRanks = gameDTO.getAvailableRanks();
        this.gameTypes = gameDTO.getGameTypes();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<String> getAvailableRanks() {
        return availableRanks;
    }

    public void setAvailableRanks(List<String> availableRanks) {
        this.availableRanks = availableRanks;
    }

    public List<String> getGameTypes() {
        return gameTypes;
    }

    public void setGameTypes(List<String> gameType) {
        this.gameTypes = gameType;
    }
}
