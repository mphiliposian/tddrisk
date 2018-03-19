package code.game;

public class Player {

	private static int nextId = 0;
	public final int ID;
	int numOfTerritories = 0;
	private int reinforcements;
	
	public Player() {
		ID = nextId;
		nextId++;
		reinforcements = 0;
	}
	
	public int getNumOfTerritories() {
		return numOfTerritories;
	}

	public void addTerritory() {
		this.numOfTerritories++;
	}

	public int getReinforcements() {
		return reinforcements;
	}
	
	public void setReinforcements(int numReinforcements) {
		this.reinforcements = numReinforcements;
	}

}
