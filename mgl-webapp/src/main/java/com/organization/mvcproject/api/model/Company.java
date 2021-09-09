package com.organization.mvcproject.api.model;

import java.util.List;

import com.organization.mvcproject.model.GameImp;

public interface Company {

	Long getId();

	void setId(Long id);
	
	String getName();

	void setName(String name);
	
	List<GameImp> getGamesMade();

	void setGamesMade(List<GameImp> gamesMade);
}
