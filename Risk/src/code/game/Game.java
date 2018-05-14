package code.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import code.gui.RiskUI;

public class Game {
	
	private final String TERRITORY_MAP_FILE = Messages.getString("Game.FileName");
	private final int MIN_NUM_OF_PLAYERS = 3;
	private final int MAX_NUM_OF_PLAYERS = 6;
	private final int NUM_OF_TERRITORIES = 42;
	private List <Player> players;
	private List <Territory> territories;
	private Map <Player, Set <Territory>> playersTerritories;
	private RiskUI ui;
	private int currTurn;
	private Map <String, Set <Territory>> continents;
	private Map <String, Integer> continentValues;
	private Random rand;

	public Game(RiskUI ui) {
		this.players = new ArrayList <Player> ();
		this.ui = ui;
		this.currTurn = 0;
		continents = new TerritoryReader().readTerritories(TERRITORY_MAP_FILE);
		territories = new ArrayList <> ();
		territories = continents.values().stream().collect(ArrayList::new, List::addAll, List::addAll);
		continentValues = intializeContinentValues();
		playersTerritories = new HashMap <> ();
		rand = new Random();
 	}

	public Game(RiskUI ui, ArrayList <Player> players, Map <Player, Set <Territory>> playerTerritories) {
		this.players = players;
		this.ui = ui;
		this.currTurn = 0;
		continents = new TerritoryReader().readTerritories(TERRITORY_MAP_FILE);
		territories = new ArrayList <> ();
		territories = continents.values().stream().collect(ArrayList::new, List::addAll, List::addAll);
		continentValues = intializeContinentValues();
		playersTerritories = playerTerritories;
		rand = new Random();
	}

	public Game(RiskUI ui, ArrayList <Player> players, Map <Player, Set <Territory>> playerTerritories, int selectedRandom) {
		this.players = players;
		this.ui = ui;
		this.currTurn = 0;
		continents = new TerritoryReader().readTerritories(TERRITORY_MAP_FILE);
		territories = new ArrayList <> ();
		territories = continents.values().stream().collect(ArrayList::new, List::addAll, List::addAll);
		continentValues = intializeContinentValues();
		playersTerritories = playerTerritories;
		rand = new Random(selectedRandom);
	}

	public boolean gameIsWon() {
		for (Player player: players) {
			if (player.getNumOfTerritories() == NUM_OF_TERRITORIES) {
				return true;
			}
		}
		return false;
	}

	public int numPlayers() {
		return players.size();
	}

	public void createPlayers() {
		players = new ArrayList <> ();
		int numPlayers = 0;
		while (numPlayers <MIN_NUM_OF_PLAYERS || numPlayers> MAX_NUM_OF_PLAYERS) {
			numPlayers = ui.playerCountPrompt();
		}
		Player player;
		for (int i = 0; i <numPlayers; i++) {
			player = new Player(i);
			players.add(player);
			playersTerritories.put(player, new HashSet <Territory> ());
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
		for (Player p: players) {
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
		initializeReinforcements();
		ui.initializeUI(territories);
		ui.createMapDisplay(territories);
		ui.createPlayerDisplay(players);
		ui.updatePlayerDisplay(0);
		placeInitialReinforcements();
	}

	public Player getPlayerByID(int playerID) {
		return players.get(playerID);
	}


	public void placeInitialReinforcements() {
		claimTerritories();
		reinforceTerritories();
	}

	public void reinforceTerritories() {
		int totalReinforcements = 0;
		for (Player player: players) {
			totalReinforcements = totalReinforcements + player.getReinforcements();
		}
		for (int NumOfTurns = 0; NumOfTurns <totalReinforcements; NumOfTurns++) {
			boolean ownedByPlayer = false;
			while (!ownedByPlayer) {
				Territory territory = ui.territoryPrompt(Messages.getString("Game.SelectTerritory"));
				if (playerOwnsTerritory(territory)) {
					placeOneUnit(territory);
					switchTurn();
					ui.updatePlayerDisplay(currTurn);
					ownedByPlayer = true;
				}
			}
		}
	}

	public boolean playerOwnsTerritory(Territory territory) {
		Set <Territory> ownedTerritories = playersTerritories.get(players.get(currTurn));
		return ownedTerritories.contains(territory);
	}

	public void placeOneUnit(Territory territory) {
		Player curPlayer = players.get(currTurn);
		territory.setYield(territory.getYield() + 1);
		ui.updateTerritoryDisplay(territory, curPlayer.getColor());
		curPlayer.setReinforcements(curPlayer.getReinforcements() - 1);
		curPlayer.addTerritory();
	}

	public void claimTerritories() {
		for (int NumOfTurns = 0; NumOfTurns <NUM_OF_TERRITORIES; NumOfTurns++) {
			boolean uniqueTerritory = false;
			while (!uniqueTerritory) {
				Territory territory = ui.territoryPrompt(Messages.getString("Game.SelectTerritory"));
				if (territory.getYield() == 0) {
					placeOneUnit(territory);
					Set <Territory> ownedTerritories = playersTerritories.get(players.get(currTurn));
					ownedTerritories.add(territory);
					playersTerritories.put(players.get(currTurn), ownedTerritories);
					uniqueTerritory = true;
					switchTurn();
					ui.updatePlayerDisplay(currTurn);
				}
			}
		}
	}

	private Map <String, Integer> intializeContinentValues() {
		Map <String, Integer> continentVals = new HashMap <> ();
		continentVals.put("NA", 5);
		continentVals.put("SA", 2);
		continentVals.put("EU", 5);
		continentVals.put("AF", 3);
		continentVals.put("AS", 7);
		continentVals.put("AU", 2);
		return continentVals;
	}

	public int getReinforcementsFromContinents() {
		Player currPlayer = getPlayerByID(currTurn);
		Set <Territory> currPlayersTerritories = playersTerritories.get(currPlayer);
		int reinforcements = 0;
		for (String continentName: continents.keySet()) {
			if (currPlayersTerritories.containsAll(continents.get(continentName))) {
				reinforcements = reinforcements + continentValues.get(continentName);
			}
		}
		return reinforcements;
	}


	public boolean canAttack(Territory attackingTerritory, Territory defendingTerritory) {
		Player curPlayer = players.get(currTurn);
		if (attackingTerritory.getYield() <2) {
			return false;
		}
		Set <Territory> curPlayersOwnedTerritories = playersTerritories.get(curPlayer);
		if (!curPlayersOwnedTerritories.contains(attackingTerritory)) {
			return false;
		}
		if (curPlayersOwnedTerritories.contains(defendingTerritory)) {
			return false;
		}
		List <String> connectedTerritories = attackingTerritory.getBorderingTerritories();
		return connectedTerritories.contains(defendingTerritory.getTerritoryID());
	}

	public void battle() {
		Territory attackingTerritory = ui.territoryPrompt("Select one of your territories to attack with");
		Territory defendingTerritory = ui.territoryPrompt("Select an enemy territories to attack");
		if (canAttack(attackingTerritory, defendingTerritory)) {
			List <Integer> attackingPlayerRolls = new ArrayList <Integer> ();
			List <Integer> defendingPlayerRolls = new ArrayList <Integer> ();
			int attackingDiceRolls = Math.min(attackingTerritory.getYield(), 3);
			for (int currRoll = 0; currRoll <attackingDiceRolls; currRoll++) {
				attackingPlayerRolls.add(rollDice());
			}
			int defendingDiceRolls = Math.min(defendingTerritory.getYield(), 2);
			for (int currRoll = 0; currRoll <defendingDiceRolls; currRoll++) {
				defendingPlayerRolls.add(rollDice());
			}

			for (int rolls = 0; rolls <defendingDiceRolls; rolls++) {
				int maxAttack = Collections.max(attackingPlayerRolls);
				int maxDefend = Collections.max(defendingPlayerRolls);
				if (maxAttack> maxDefend) {
					defendingTerritory.setYield(defendingTerritory.getYield() - 1);
				} else {
					attackingTerritory.setYield(attackingTerritory.getYield() - 1);
				}
				int idMaxAtk = attackingPlayerRolls.indexOf(maxAttack);
				int idMaxDef = defendingPlayerRolls.indexOf(maxDefend);
				attackingPlayerRolls.remove(idMaxAtk);
				defendingPlayerRolls.remove(idMaxDef);
			}
		}
	}

	public int rollDice() {
		return rand.nextInt(6) + 1;
	}
}