package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.model.Review;
import com.organization.mvcproject.service.GameService;

@RestController
@RequestMapping(value = "/game")
public class GameController {

	@Autowired
	private GameService gameService;

	/**
	 * TODO 2.0 (Separation of concerns) consider moving all controller endpoints that return a ResponseEntity into a @RestController.
	 */
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}