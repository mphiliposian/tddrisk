package code.game;

import java.util.List;

public class Territory {
	private String territoryID;
	private String name;
	private List<String> borderingTerritories;
	private Double x;
	private Double y;
	private int yield;
	
	public Territory(String territoryID, String name, int yield, List<String> borderingTerritories, Double x2, Double y2) {
		this.territoryID = territoryID;
		this.name = name;
		this.borderingTerritories = borderingTerritories;
		this.x = x2;
		this.y = y2;
	}
	
	public Territory(String territoryID, String name, List<String> borderingTerritories, Double x2, Double y2) {
		this(territoryID, name, 0, borderingTerritories, x2, y2);
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

	public Double getX() {
		return this.x;
	}

	public Double getY() {
		return this.y;
	}

}
