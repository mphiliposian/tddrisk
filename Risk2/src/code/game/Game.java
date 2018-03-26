package code.game;

import java.util.ArrayList;
import java.util.Collections;

import code.gui.RiskUI;

public class Game {

	private ArrayList<Player> players;
	private RiskUI ui;
	private int currTurn;
	
	public Game(RiskUI ui) {
		this.players = new ArrayList<Player>();
		this.ui = ui;
		this.currTurn = 0;
	}
	
	public boolean gameIsWon() {
		for (Player player : players){
			if (player.getNumOfTerritories() == 42) {
				return true;
			}
		}
		return false;
	}

	public void addPlayer(Player player) {
		if (players.size() < 6) {
			players.add(player);
		}
	}

	//TODO do we have to test this?
	public void randomizeOrder() {
		Collections.shuffle(players);
	}

	public int numPlayers() {
		return players.size();
	}

	public void createPlayers() {
		int numPlayers = 0;
		while (numPlayers < 3 || numPlayers > 6) {
			numPlayers = ui.playerCountPrompt();
		}
		
		for (int i=0; i<numPlayers; i++) {
			players.add(new Player());
		}
	}
	
	public void initializeReinforcements() {
		int reinforcements = 35;
		switch (players.size()) {
		case 4:
			reinforcements = 30;
			break;
		case 5:
			reinforcements = 25;
			break;
		case 6:
			reinforcements = 20;
			break;
		}
		
		for (Player p : players) {
			p.setReinforcements(reinforcements);
		}
	}

	public int currentTurn() {
		return currTurn;
	}

	public void switchTurn() {
		this.currTurn = (currTurn + 1)%players.size();
		
	}

}
