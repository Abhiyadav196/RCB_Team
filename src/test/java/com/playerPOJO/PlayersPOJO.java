package com.playerPOJO;

import java.util.ArrayList;

import com.google.gson.Gson;

public class PlayersPOJO implements IJson {
	
	private String name;
	private String location;
	private ArrayList<Player> player;
	
	public PlayersPOJO(String name, String location, ArrayList<Player> player) {
		super();
		this.name = name;
		this.location = location;
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Player> getPlayer() {
		return player;
	}

	public void setPlayer(ArrayList<Player> player) {
		this.player = player;
	}

	
	@Override
	public String toString() {
		return "PlayersPOJO [name=" + name + ", location=" + location + ", player=" + player + "]";
	}

	public String toJson() {
		PlayersPOJO playerDetails = new PlayersPOJO(name, location, player);
		Gson gson = new Gson();
		return gson.toJson(playerDetails);
	}
	
	

}
