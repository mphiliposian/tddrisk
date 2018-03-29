package code.game;

import java.util.List;

public class Territory {
	private String territoryID;
	private String name;
	private List<String> borderingTerritories;
	private double xScale;
	private double yScale;
	private int yield;
	
	public Territory(String territoryID, String name, int yield, List<String> borderingTerritories, double x, double y) {
		this.territoryID = territoryID;
		this.name = name;
		this.borderingTerritories = borderingTerritories;
		this.xScale = x;
		this.yScale = y;
	}
	
	public Territory(String territoryID, String name, List<String> borderingTerritories, double x, double y) {
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
		this.yield = yield;
	}

	public List<String> getBorderingTerritories() {
		return this.borderingTerritories;
	}

	public double getX() {
		return this.xScale;
	}

	public double getY() {
		return this.yScale;
	}

}
