package code.game;

import java.awt.Color;

public class Player {

	public static final Color[] COLORS = {
		Color.red,
		Color.orange,
		Color.yellow,
		Color.green,
		Color.cyan,
		Color.magenta
	};

	public final int ID;
	int numOfTerritories = 0;
	private int reinforcements;

	public Player(int id) {
		ID = id;
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

	public Color getColor() {
		return COLORS[this.ID];
	}
}
