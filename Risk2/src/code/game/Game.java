package code.game;

import java.util.ArrayList;

import code.gui.RiskUI;

public class Game {

	private ArrayList<Player> players;
	private RiskUI ui;
		
	public Game(RiskUI ui) {
		this.players = new ArrayList<Player>();
		this.ui = ui;
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

}
