package com.organization.mvcproject.model;

import java.util.List;

import com.organization.mvcproject.api.model.Company;

public class CompanyImp implements Company{

	private Long id;
	private String name;
	
	private List<GameImp> gamesMade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GameImp> getGamesMade() {
		return gamesMade;
	}

	public void setGamesMade(List<GameImp> gamesMade) {
		this.gamesMade = gamesMade;
	}
}