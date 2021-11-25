package com.skaczmarek.matchmakerappbackend.service;


import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import com.skaczmarek.matchmakerappbackend.domain.player.Player;
import com.skaczmarek.matchmakerappbackend.domain.player.PlayerDTO;
import com.skaczmarek.matchmakerappbackend.domain.room.CreateRoomDTO;
import com.skaczmarek.matchmakerappbackend.domain.room.Room;
import com.skaczmarek.matchmakerappbackend.domain.user.User;
import com.skaczmarek.matchmakerappbackend.repository.GameRepository;
import com.skaczmarek.matchmakerappbackend.repository.PlayerRepository;
import com.skaczmarek.matchmakerappbackend.repository.RoomRepository;
import com.skaczmarek.matchmakerappbackend.repository.UserRepository;
import com.skaczmarek.matchmakerappbackend.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
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


    public List<Room> getAllRoomsWithUser(long userId) {
        List<Room> allRooms = roomRepository.findAll();
        List<Room> roomsWithPlayer = new LinkedList<>();
        boolean foundUser = false;
        for (Room r : allRooms){
            for (Player p : r.getPlayersList()){
                if (p.getUser().getUserId() == userId){
                    foundUser = true;
                }
            }
            if (foundUser){
                roomsWithPlayer.add(r);
            }
            foundUser = false;
        }
        return roomsWithPlayer;
    }
    

    public List<Room> getAllRoomsWithoutUser(long userId) {
        List<Room> allRooms = roomRepository.findAll();
        List<Room> roomsWithoutUser = new LinkedList<>();
        boolean foundUser = false;
        for (Room r : allRooms){
            for (Player p : r.getPlayersList()){
                if (p.getUser().getUserId() == userId){
                    foundUser = true;
                }
            }
            if (!foundUser){
                roomsWithoutUser.add(r);
            }
            foundUser = false;
        }
        return roomsWithoutUser;
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

        return roomRepository.save(new Room(room, playerList));
    }


    public boolean deleteRoom(long roomId) throws RoomNotFoundException {
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
        roomRepository.delete(room);
        return true;
    }


    public Room removeUserFromRoom(long roomId, long userId) throws RoomNotFoundException, PlayerNotFoundException {
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));

        List<Player> playerList = room.getPlayersList();

        if (playerList.size() == 1){
            roomRepository.delete(room);
            return null;
        }

        playerList.removeIf(player -> player
                .getUser()
                .getUserId() == userId);

        return roomRepository.save(new Room(room, playerList));

    }

    public Room getRoom(long roomId) throws RoomNotFoundException {
        return roomRepository
                .findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
    }
}
