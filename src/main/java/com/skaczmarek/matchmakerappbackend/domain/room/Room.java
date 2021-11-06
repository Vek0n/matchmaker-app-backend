package com.skaczmarek.matchmakerappbackend.domain.room;
import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import com.skaczmarek.matchmakerappbackend.domain.player.Player;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name="players_in_room",
            joinColumns = @JoinColumn(name="room_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> playersList;

    @ManyToOne
    @JoinColumn(name = "gameId")
    private Game game;

    private int maxPlayers;

    public Room() {
    }

    public Room(long id, RoomDTO roomDTO) {
        this.id = id;
        this.playersList = roomDTO.getPlayersList();
        this.game = roomDTO.getGame();
        this.maxPlayers = roomDTO.getMaxPlayers();
    }

    public Room(RoomDTO roomDTO){
        this.playersList = roomDTO.getPlayersList();
        this.game = roomDTO.getGame();
        this.maxPlayers = roomDTO.getMaxPlayers();
    }

    public Room(List<Player> playerList, Game game, int maxPlayers) {
        this.playersList = playerList;
        this.game = game;
        this.maxPlayers = maxPlayers;
    }

    public Room(long id, List<Player> playerList, Game game, int maxPlayers) {
        this.id = id;
        this.playersList = playerList;
        this.game = game;
        this.maxPlayers = maxPlayers;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
