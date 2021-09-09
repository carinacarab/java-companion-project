package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.GameMockDAOImpl;
import com.organization.mvcproject.model.GameImp;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameMockDAOImpl mockDAO;
	
	//Retrieve game
	@Override
	public List<GameImp> retrieveAllGames() {
		return mockDAO.retrieveAll();
	}
	//Create and Update game
	@Override
	public GameImp saveGame(GameImp game) {
		return mockDAO.saveGame(game);
	}
	
	//Remove game
	@Override
	public Boolean deleteGame(Long id) {
		return mockDAO.deleteGame(id);
	}
}