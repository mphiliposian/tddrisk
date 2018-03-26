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

	private List<Player> players;
	private RiskUI ui;
	private int currTurn;
	
	public static void main(String[] args) {
		RiskGUI rG = new RiskGUI();
		Game g = new Game(rG);
		rG.initializeUI(null);
		g.createPlayers();
		g.randomizeOrder();
		g.initializeReinforcements();
		
		PlayerDisplayPanel pDp = new PlayerDisplayPanel(g.players);
		JFrame frame = new JFrame("Players");
		frame.setLayout(new FlowLayout());
		frame.add(pDp.getPanel());
		frame.setSize(800, 200);
		frame.setVisible(true);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		
	}
	
	public Game(RiskUI ui) {
		this.players = new ArrayList<Player>();
		this.ui = ui;
		this.currTurn = 0;
	}
	
	public boolean gameIsWon() {
		for (Player player : players) {
			if (player.getNumOfTerritories() == 42) {
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
		while (numPlayers < 3 || numPlayers > 6) {
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
		this.currTurn = (currTurn + 1)%players.size();
		
	}
	
	public void setup() {
		createPlayers();
		randomizeOrder();
		initializeReinforcements();
		ui.createPlayerDisplay(players);
		ui.updatePlayerDisplay();
	}

	public Player getPlayerByID(int playerID) {
		return players.get(playerID);
	}

}
