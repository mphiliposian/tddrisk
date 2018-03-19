package code.game;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
		
	public Game() {
		this.players = new ArrayList<Player>();
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

}
