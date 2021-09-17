package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImp;

@RestController
@RequestMapping(value = "/game")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<GameImp>> fetchAllGames() {
		return new ResponseEntity<List<GameImp>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImp game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateGame(@RequestBody GameImp game) {
		GameImp savedGame = gameService.saveGame(game);
		return new ResponseEntity<>(savedGame, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable(value="id") Long id){
		return new ResponseEntity<>(gameService.deleteGame(id), HttpStatus.OK);
	}
}