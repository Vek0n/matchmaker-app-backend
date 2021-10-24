package com.skaczmarek.matchmakerappbackend.repository;

import com.skaczmarek.matchmakerappbackend.domain.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoomRepository extends JpaRepository<Room, Long> {
}
