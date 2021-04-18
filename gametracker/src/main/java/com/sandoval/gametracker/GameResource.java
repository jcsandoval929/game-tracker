package com.sandoval.gametracker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sandoval.gametracker.model.Game;
import com.sandoval.gametracker.service.GameService;

@RestController
@RequestMapping("/game")
public class GameResource {
	private final GameService gameService;

	public GameResource(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Game>> getAllGames() {
		List<Game> games = gameService.findAllGames();
		return new ResponseEntity<>(games, HttpStatus.OK);
	}

	@GetMapping("/library")
	public ResponseEntity<List<Game>> getAllLibraryGames() {
		List<Game> libraryGames = gameService.findAllLibraryGames();
		return new ResponseEntity<>(libraryGames, HttpStatus.OK);
	}

	@GetMapping("/wishlist")
	public ResponseEntity<List<Game>> getAllWishlistGames() {
		List<Game> wishlistGames = gameService.findAllWishlistGames();
		return new ResponseEntity<>(wishlistGames, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Game> getGameById(@PathVariable("id") Long id) {
		Game game = gameService.findGameById(id);
		return new ResponseEntity<>(game, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Game> addEmployee(@RequestBody Game game) {
		Game newGame = gameService.addGame(game);
		return new ResponseEntity<>(newGame, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Game> updateEmployee(@RequestBody Game game) {
		Game updateGame = gameService.updateGame(game);
		return new ResponseEntity<>(updateGame, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		gameService.deleteGame(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
