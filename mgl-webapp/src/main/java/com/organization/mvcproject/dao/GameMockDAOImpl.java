package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.dao.GameMockDAO;
import com.organization.mvcproject.model.GameImp;

//all CRUD operations: create, retrieve, update and delete
@Repository
public class GameMockDAOImpl implements GameMockDAO {
	
	private static Long gameId = 0l;
	private static List<GameImp> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImp> populateGames() {

		GameImp game1 = new GameImp();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImp game2 = new GameImp();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImp game3 = new GameImp();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	@Override
	public List<GameImp> retrieveAll() {
		return games;
	}

	@Override
	public GameImp saveGame(GameImp game) {
		if(game.getId() != null) {
			GameImp foundGame = getGame(game.getId());
			if(foundGame != null) {
				//this stream uses .map() to replace existing game with foundGame's id with foundGame
				games = games.stream()
							.map(g -> g.getId().equals(foundGame.getId()) ? foundGame : g)
							.collect(Collectors.toList());
				return foundGame;
			} else {
				//if foundGame is null, this means that this ID we have does not correspond
				//to an existing game in the games list, so we have to simply add it to games
				games.add(game);
				
				return game;
			}
		}
		//if this game imported has literally no id, we want to save this id to game and add game to games	
		game.setId(++gameId);
		games.add(game);
		
		return game;
	}

	@Override
	public GameImp getGame(Long id) {
		return games.stream()
				.filter(g -> id.equals(g.getId()))
				.findAny()
				.orElse(null);
	}

	@Override
	public Boolean deleteGame(Long id) {
		return games.removeIf(ga -> ga.getId().equals(id));
		
	}

}
