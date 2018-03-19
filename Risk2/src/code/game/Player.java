package code.game;

public class Player {

	private static int nextId = 0;
	public final int ID;
	int numOfTerritories = 0;
	
	public Player() {
		ID = nextId;
		nextId++;
	}
	
	public int getNumOfTerritories() {
		return numOfTerritories;
	}

	public void addTerritory() {
		this.numOfTerritories++;
	}

}
