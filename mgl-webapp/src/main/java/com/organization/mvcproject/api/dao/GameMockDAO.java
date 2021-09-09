package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.model.GameImp;

public interface GameMockDAO {
	
	public List<GameImp> retrieveAll();

	public GameImp saveGame(GameImp game);
	
	public GameImp getGame(Long id);
	
	public Boolean deleteGame(Long id);
	

}
