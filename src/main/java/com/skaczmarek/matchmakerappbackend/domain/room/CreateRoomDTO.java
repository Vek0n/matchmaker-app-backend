package com.skaczmarek.matchmakerappbackend.domain.room;

public class CreateRoomDTO {
    private long playerId;
    private long gameId;
    private int maxPlayers;

    public CreateRoomDTO() {
    }

    public CreateRoomDTO(long playerId, long gameId, int maxPlayers) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.maxPlayers = maxPlayers;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
