package com.playerPOJO;

public class Player {
	private String name;
	private String country;
	private String role;
	private String price_in_crores;
	
	public Player(String name, String country, String role, String price_in_crores) {
		super();
		this.name = name;
		this.country = country;
		this.role = role;
		this.price_in_crores = price_in_crores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPrice_in_crores() {
		return price_in_crores;
	}

	public void setPrice_in_crores(String price_in_crores) {
		this.price_in_crores = price_in_crores;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", country=" + country + ", role=" + role + ", price_in_crores="
				+ price_in_crores + "]";
	}
	
	
	
}
