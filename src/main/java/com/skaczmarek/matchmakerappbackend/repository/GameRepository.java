package com.skaczmarek.matchmakerappbackend.repository;

import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
