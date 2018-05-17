package code.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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
	private ArrayList<Card> hand;

	public Player(int id) {
		ID = id;
		reinforcements = 0;
		hand = new ArrayList<Card>();
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
	
	public boolean addCardToHand(Card card) {
		if(hand.size() < 6) {
			hand.add(card);
			return true;
		}
		return false;
	}
	
	public void removeCard(Card card) {
		if(!hand.contains(card)) {
			throw new IllegalArgumentException();
		}
		hand.remove(card);
	}
	
	public List<Card> getHand() {
		return hand;
	}
}
