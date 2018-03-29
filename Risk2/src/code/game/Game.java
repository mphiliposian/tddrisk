package code.game;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import code.gui.PlayerDisplayPanel;
import code.gui.RiskGUI;
import code.gui.RiskUI;

public class Game {

	private final int MIN_NUM_OF_PLAYERS = 3;
	private final int MAX_NUM_OF_PLAYERS = 6;
	private final int NUM_OF_TERRITORIES = 3;
	
	private List<Player> players;
	private List<Territory> territories;
	private RiskUI ui;
	private int currTurn;

	public Game(RiskUI ui) {
		this.players = new ArrayList<Player>();
		this.territories = new ArrayList<Territory>();
		this.ui = ui;
		this.currTurn = 0;
	}

	public boolean gameIsWon() {
		for (Player player : players) {
			if (player.getNumOfTerritories() == NUM_OF_TERRITORIES) {
				return true;
			}
		}
		return false;
	}

	public void randomizeOrder() {
		Collections.shuffle(players);
	}

	public int numPlayers() {
		return players.size();
	}

	public void createPlayers() {
		players = new ArrayList<>();
		int numPlayers = 0;
		while (numPlayers < MIN_NUM_OF_PLAYERS || numPlayers > MAX_NUM_OF_PLAYERS) {
			numPlayers = ui.playerCountPrompt();
		}

		for (int i=0; i<numPlayers; i++) {
			players.add(new Player(i));
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
		this.currTurn = (currTurn + 1) % players.size();

	}

	public void setup() {
		createPlayers();
		randomizeOrder();
		initializeReinforcements();
		ui.initializeUI(null);
		ui.createPlayerDisplay(players);
		ui.updatePlayerDisplay();
	}

	public Player getPlayerByID(int playerID) {
		return players.get(playerID);
	}
	
	public Territory getTerritoryByID(int territoryID) {
		return territories.get(territoryID);
	}

	public void placeInitialReinforcements() {
		for(int NumOfTurns = 0; NumOfTurns < NUM_OF_TERRITORIES; NumOfTurns++) {
			ui.territoryPrompt("");
			players.get(currTurn).addTerritory();
			switchTurn();
		}
	}

}
