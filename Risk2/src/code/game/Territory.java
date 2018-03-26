package code.game;

import java.util.List;

public class Territory {
	private String territoryID;
	private String name;
	private List<String> borderingTerritories;
	private Double x;
	private Double y;
	private int yield;
	
	/** 
	 * @param territoryID
	 * 		A value that uniquely determines a territory.
	 * @param name
	 * 		The name of the territory.
	 * @param yield
	 * 		The number of army units a territory contains.
	 * @param borderingTerritories
	 * 		A list of territoryIDs for which the territory borders.
	 * @param x
	 * 		The x-position in which a territory lies on the map.
	 * @param y
	 * 		The y-position in which a territory lies on the map.
	 */
	public Territory(String territoryID, String name, int yield, List<String> borderingTerritories, Double x, Double y) {
		this.territoryID = territoryID;
		this.name = name;
		this.borderingTerritories = borderingTerritories;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Builds the constructor with no army units.
	 * @param territoryID
	 * @param name
	 * @param borderingTerritories
	 * @param x
	 * @param y
	 */
	public Territory(String territoryID, String name, List<String> borderingTerritories, Double x, Double y) {
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

	public Double getX() {
		return this.x;
	}

	public Double getY() {
		return this.y;
	}

}
