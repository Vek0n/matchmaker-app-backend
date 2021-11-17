package com.skaczmarek.matchmakerappbackend.service;


import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import com.skaczmarek.matchmakerappbackend.domain.player.Player;
import com.skaczmarek.matchmakerappbackend.domain.player.PlayerDTO;
import com.skaczmarek.matchmakerappbackend.domain.room.CreateRoomDTO;
import com.skaczmarek.matchmakerappbackend.domain.room.Room;
import com.skaczmarek.matchmakerappbackend.domain.room.RoomDTO;
import com.skaczmarek.matchmakerappbackend.domain.user.User;
import com.skaczmarek.matchmakerappbackend.repository.GameRepository;
import com.skaczmarek.matchmakerappbackend.repository.PlayerRepository;
import com.skaczmarek.matchmakerappbackend.repository.RoomRepository;
import com.skaczmarek.matchmakerappbackend.repository.UserRepository;
import com.skaczmarek.matchmakerappbackend.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoomService {


    private PlayerRepository playerRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private GameRepository gameRepository;

    @Autowired
    public RoomService(PlayerRepository playerRepository, UserRepository userRepository, RoomRepository roomRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.gameRepository = gameRepository;
    }


    public Room createRoom(CreateRoomDTO createRoomDTO) throws UserNotFoundException, GameNotFoundException {
        long userId = createRoomDTO.getUserId();
        long gameId = createRoomDTO.getGameId();
        int maxPlayers = createRoomDTO.getMaxPlayers();
        PlayerDTO playerDTO = createRoomDTO.getPlayer();
        String gameType = createRoomDTO.getGameType();

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Player player = playerRepository.save(new Player(user, playerDTO));

        Game game = gameRepository
                .findById(gameId)
                .orElseThrow(()-> new GameNotFoundException(gameId));

        return roomRepository.save(new Room(Collections.singletonList(player),game, maxPlayers, gameType));
    }


    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }


    public Room addPlayerToTheRoomUsingUserId(long roomId, long userId, PlayerDTO playerDTO) throws RoomNotFoundException, UserNotFoundException, RoomIsFullException {
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));

        if (room.getMaxPlayers() == room.getPlayersList().size()){
            throw new RoomIsFullException(roomId);
        }

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Player player = playerRepository.save(new Player(user, playerDTO));

        List<Player> playerList = room.getPlayersList();
        playerList.add(player);
        return roomRepository.save(new Room(roomId, playerList, room.getGame(), room.getMaxPlayers(), room.getGameType()));
    }
}
