package com.skaczmarek.matchmakerappbackend.controller;


import com.skaczmarek.matchmakerappbackend.domain.room.CreateRoomDTO;
import com.skaczmarek.matchmakerappbackend.domain.room.Room;
import com.skaczmarek.matchmakerappbackend.service.RoomService;
import com.skaczmarek.matchmakerappbackend.service.exceptions.GameNotFoundException;
import com.skaczmarek.matchmakerappbackend.service.exceptions.PlayerNotFoundException;
import com.skaczmarek.matchmakerappbackend.service.exceptions.RoomNotFoundException;
import com.skaczmarek.matchmakerappbackend.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping(value = "/room")
    public Room createRoom(@RequestBody CreateRoomDTO createRoomDTO) throws UserNotFoundException, GameNotFoundException {
        return roomService.createRoom(createRoomDTO);
    }


    @GetMapping(value = "/room")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping(value = "/room/{roomId}")
    public Room addPlayerToRoom(@PathVariable long roomId, @RequestParam long playerId) throws PlayerNotFoundException, RoomNotFoundException {
        return roomService.addPlayerToTheRoom(roomId, playerId);
    }
}
