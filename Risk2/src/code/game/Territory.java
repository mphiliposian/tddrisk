package code.game;

import java.util.List;

public class Territory {
	private String territoryID;
	private String name;
	private List<String> borderingTerritories;
	private int x;
	private int y;
	private int yield;
	
	public Territory(String territoryID, String name, int yield, List<String> borderingTerritories, int x, int y) {
		this.territoryID = territoryID;
		this.name = name;
		this.borderingTerritories = borderingTerritories;
		this.x = x;
		this.y = y;
	}
	
	public Territory(String territoryID, String name, List<String> borderingTerritories, int x, int y) {
		this(territoryID, name, 0, borderingTerritories, x, y);
	}

	public String getTerritoryID() {
		return this.territoryID;
	}

	public String getName() {
		return this.name;
	}
	
	public int getYield() {
		return this.yield;
	}

	public void setYield(int yield) {
		// TODO
	}

	public List<String> getBorderingTerritories() {
		return this.borderingTerritories;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
