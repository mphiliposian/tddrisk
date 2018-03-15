package code;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> p;
		
	public Game() {
		this.p = new ArrayList<Player>();
	}
	
	public boolean gameIsWon() {
		return true;
	}

	public void addPlayer(Player player) {
		if (p.size() < 6) {
			p.add(player);
		}
	}

	public int numPlayers() {
		return p.size();
	}

}
