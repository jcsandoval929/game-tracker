package com.sandoval.gametracker.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandoval.gametracker.model.Game;

public interface GameRepo extends JpaRepository<Game, Long> {
	List<Game> findByWantedFalse();
	
	List<Game> findByWantedTrue();

	void deleteGameById(Long id);

	Optional<Game> findGameById(Long id);

}
