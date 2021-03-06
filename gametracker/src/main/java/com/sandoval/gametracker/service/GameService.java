package com.sandoval.gametracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandoval.gametracker.exception.GameNotFoundException;
import com.sandoval.gametracker.model.Game;
import com.sandoval.gametracker.repo.GameRepo;

@Service
@Transactional
public class GameService {
	private final GameRepo gameRepo;

	@Autowired
	public GameService(GameRepo gameRepo) {
		this.gameRepo = gameRepo;
	}

	public Game addGame(Game game) {
		return gameRepo.save(game);
	}

	public List<Game> findAllGames() {
		return gameRepo.findAll();
	}

	public List<Game> findAllLibraryGames() {
		return gameRepo.findByWantedFalse();
	}

	public List<Game> findAllWishlistGames() {
		return gameRepo.findByWantedTrue();
	}

	public Game updateGame(Game game) {
		return gameRepo.save(game);
	}

	public Game findGameById(Long id) {
		return gameRepo.findGameById(id)
				.orElseThrow(() -> new GameNotFoundException("Game by id " + id + " was not found"));
	}

	public void deleteGame(Long id) {
		gameRepo.deleteGameById(id);
	}

}
