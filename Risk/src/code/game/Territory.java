package code.game;

import java.util.List;

public class Territory {
	private String territoryID;
	private String name;
	private List <String> borderingTerritories;
	private double xScale;
	private double yScale;
	private int yield;
	public static final Territory CANCEL_TERRITORY = new Territory("Cancel", "null", 0, null, 0, 0);
	public static final Territory END_TERRITORY = new Territory("End", "null", 0, null, 0, 0);

	public Territory(String territoryID, String name, int yield, List <String> borderingTerritories, double x, double y) {
		this.territoryID = territoryID;
		this.name = name;
		this.borderingTerritories = borderingTerritories;
		this.xScale = x;
		this.yScale = y;
		this.yield = yield;
	}

	public Territory(String territoryID, String name, List <String> borderingTerritories, double x, double y) {
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

	public List <String> getBorderingTerritories() {
		return this.borderingTerritories;
	}

	public double getX() {
		return this.xScale;
	}

	public double getY() {
		return this.yScale;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((territoryID == null) ? 0 : territoryID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Territory other = (Territory) obj;
		if (territoryID == null) {
			if (other.territoryID != null)
			return false;
			} else if (!territoryID.equals(other.territoryID))
				return false;
			return true;
	}
}
