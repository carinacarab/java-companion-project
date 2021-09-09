package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.model.GameImp;

public interface GameService {

	List<GameImp> retrieveAllGames();

	GameImp saveGame(GameImp game);

	Boolean deleteGame(Long id);

}
