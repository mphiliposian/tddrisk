package code.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import javax.swing.JOptionPane;

import org.easymock.EasyMock;
import code.gui.RiskUI;

public class Game {

	private static final boolean DEBUG = false;
	public final Deck deck;
	private final String TERRITORY_MAP_FILE = Messages.getString("Game.FileName"); //$NON-NLS-1$

	private final int MIN_NUM_OF_PLAYERS = 3;
	private final int MAX_NUM_OF_PLAYERS = 6;
	private final int NUM_OF_TERRITORIES = 42;
	private final int MIN_NUM_OF_UNITS_PER_TURN = 3;

	private List<Player> players;
	private List<Territory> territories;
	private Map<Player, Set<Territory>> playersTerritories;
	private RiskUI ui;
	private int currTurn;
	private Map <String, Set <Territory>> continents;
	private Map <String, Integer> continentValues;
	private Random rand;
	public int redeemedSets = 0;

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
		deck = new Deck(territories, rand);
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
		deck = new Deck(territories, rand);
	}

	public Game(RiskUI ui, ArrayList <Player> players, Map <Player, Set <Territory>> playerTerritories, int seed) {
		this.players = players;
		this.ui = ui;
		this.currTurn = 0;
		continents = new TerritoryReader().readTerritories(TERRITORY_MAP_FILE);
		territories = new ArrayList <> ();
		territories = continents.values().stream().collect(ArrayList::new, List::addAll, List::addAll);
		continentValues = intializeContinentValues();
		playersTerritories = playerTerritories;
		rand = new Random(seed);
		deck = new Deck(territories, rand);
	}


	public boolean gameIsWon() {
		for (Player player: players) {
			Set<Territory> ownedTerritoriesByPlayer = playersTerritories.get(player);
			if (ownedTerritoriesByPlayer.size() == NUM_OF_TERRITORIES) {
				ui.displayMessage(Messages.getString("Game.1") + (player.ID + 1) + Messages.getString("Game.2")); //$NON-NLS-1$ //$NON-NLS-2$
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

	public void turn() {
		ui.setPhaseText(Messages.getString("Game.3")); //$NON-NLS-1$
		allocatePhase();
		ui.setPhaseText(Messages.getString("Game.4")); //$NON-NLS-1$
		battlePhase();
		ui.setPhaseText(Messages.getString("Game.5")); //$NON-NLS-1$
		fortify();
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
		playGame();
	}

	public void playGame() {
		while(!this.gameIsWon()) {
			Player curplayer = players.get(currTurn);
			if (playerHasATerritory(curplayer)) {
				turn();
			}
			this.switchTurn();
		}
	}

	private boolean playerHasATerritory(Player curplayer) {
		return playersTerritories.get(curplayer).size() > 0;
	}

	public Player getPlayerByID(int playerID) {
		return players.get(playerID);
	}


	public void placeInitialReinforcements() {
		if (DEBUG) {
			autoClaim();
			autoReinforce();
		} else {
			claimTerritories();
			reinforceTerritories();
		}

	}

	public void reinforceTerritories() {
		int totalReinforcements = 0;
		for (Player player: players) {
			totalReinforcements = totalReinforcements + player.getReinforcements();
		}

		for (int NumOfTurns = 0; NumOfTurns < totalReinforcements; NumOfTurns++) {
			boolean ownedByPlayer = false;
			while (!ownedByPlayer) {
				Territory territory = ui.territoryPrompt(Messages.getString("Game.SelectTerritory")); //$NON-NLS-1$
				if (playerOwnsTerritory(territory)) {
					placeOneUnit(territory);
					switchTurn();
					ui.updatePlayerDisplay(currTurn);
					ownedByPlayer = true;
				}
			}
		}
	}

	public boolean verifyCards(List<Card> cards) {
		if (cards != null) {
			Card card1 = cards.get(0);
			Card card2 = cards.get(1);
			Card card3 = cards.get(2);

			if (containsWildCard(card1, card2, card3)) {
				return true;
			}
			
			if (allSameCardType(card1,card2,card3)) {
				return true;
			}
			
			if (allUniqueCards(card1,card2,card3)) {
				return true;
			}
		}
		return false;
	}

	private boolean containsWildCard(Card card1, Card card2, Card card3) {
		return card1.getCardType().equals(Card.CardType.WILD) || card2.getCardType().equals(Card.CardType.WILD) || card3.getCardType().equals(Card.CardType.WILD);
	}

	private boolean allUniqueCards(Card card1, Card card2, Card card3) {
		return (!card1.getCardType().equals(card2.getCardType()) && !card2.getCardType().equals(card3.getCardType()) && !card1.getCardType().equals(card3.getCardType()));
	}



	private boolean allSameCardType(Card card1, Card card2, Card card3) {
		return (card1.getCardType().equals(card2.getCardType()) && card2.getCardType().equals(card3.getCardType()));
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
				Territory territory = ui.territoryPrompt(Messages.getString("Game.SelectTerritory")); //$NON-NLS-1$
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
		continentVals.put(Messages.getString("Game.8"), 5); //$NON-NLS-1$
		continentVals.put(Messages.getString("Game.9"), 2); //$NON-NLS-1$
		continentVals.put(Messages.getString("Game.10"), 5); //$NON-NLS-1$
		continentVals.put(Messages.getString("Game.11"), 3); //$NON-NLS-1$
		continentVals.put(Messages.getString("Game.12"), 7); //$NON-NLS-1$
		continentVals.put(Messages.getString("Game.13"), 2); //$NON-NLS-1$
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

	public int getReinforcementsFromTerritories() {
		Player currPlayer = getPlayerByID(currTurn);
		Set<Territory> ownedTerritories = playersTerritories.get(currPlayer);
		int reinforcements = (int)(ownedTerritories.size() / 3);
		if (MIN_NUM_OF_UNITS_PER_TURN > reinforcements) {
			return MIN_NUM_OF_UNITS_PER_TURN;
		}
		return reinforcements;
	}



	public int getTotalReinforcements() {
		return getReinforcementsFromContinents() 
				+ getReinforcementsFromTerritories();
	}

	public void allocatePhase() {
		ui.updatePlayerDisplay(currTurn);
		boolean cardsVerified = false;
		Player curPlayer = players.get(currTurn);
		List<Card> redeemedCards = new ArrayList<>();
		while(redeemedCards != null && !cardsVerified) {
			redeemedCards = ui.selectCards(currTurn, curPlayer.getHand());
			cardsVerified = this.verifyCards(redeemedCards);
		}
		
		if (redeemedCards != null){
			int setValue = this.redeemCards(curPlayer, redeemedCards);
			curPlayer.setReinforcements(curPlayer.getReinforcements() + setValue);
		}

		int initialReinforcements = curPlayer.getReinforcements() 
				+ this.getTotalReinforcements();
		curPlayer.setReinforcements(initialReinforcements);
		while(curPlayer.getReinforcements() > 0) {
			Territory territory = ui.territoryPrompt(Messages.getString("Game.14")); //$NON-NLS-1$
			if (playerOwnsTerritory(territory)) {
				placeOneUnit(territory);
				ui.updatePlayerDisplay(currTurn);
			}
		}	
	}
	
	public void forceRedeem() {
		boolean cardsVerified = false;
		Player curPlayer = players.get(currTurn);
		List<Card> redeemedCards = new ArrayList<>();
		while(!cardsVerified) {
			redeemedCards = ui.selectCards(currTurn, curPlayer.getHand());
			cardsVerified = this.verifyCards(redeemedCards);
		}
		
		if (redeemedCards != null){
			int setValue = this.redeemCards(curPlayer, redeemedCards);
			curPlayer.setReinforcements(curPlayer.getReinforcements() + setValue);
		}
		
		while(curPlayer.getReinforcements() > 0) {
			Territory territory = ui.territoryPrompt(Messages.getString("Game.14")); //$NON-NLS-1$
			if (playerOwnsTerritory(territory)) {
				placeOneUnit(territory);
				ui.updatePlayerDisplay(currTurn);
			}
		}
	}
	
	public int redeemCards(Player player, List<Card> redeemedCards) {
		int setValue = 0;
		for (Card card : redeemedCards) {
			player.removeCard(card);
			deck.discard(card);
		}
		setValue = calculateSetValue(redeemedSets);
		redeemedSets += 1;
		ui.setCardValue(calculateSetValue(redeemedSets));
		
		boolean ownsCardTerritory = false;
		for (Card card : redeemedCards) {
			if (this.playerOwnsTerritory(card.getTerritory())) {
				ownsCardTerritory = true;
			}
		}
		if (ownsCardTerritory) {
			setValue += 2;
		}
		
		return setValue;
	}
	
	public int calculateSetValue(int redeemedSets) {
		if (redeemedSets == 0) {
			return 4;
		} else if(redeemedSets < 6){
			return 2 + redeemedSets*2;
		} else {
			return 15 + (redeemedSets - 6)*5;
		}
	}

	public boolean canAttack(Territory attackingTerritory) {
		Player curPlayer = players.get(currTurn);

		if (attackingTerritory.getYield() < 2) {
			return false;
		}

		Set <Territory> curPlayersOwnedTerritories = playersTerritories.get(curPlayer);
		if (!curPlayersOwnedTerritories.contains(attackingTerritory)) {
			return false;
		}

		return true;
	}

	public boolean attackable(Territory attackingTerritory, Territory defendingTerritory) {
		Player curPlayer = players.get(currTurn);
		Set <Territory> curPlayersOwnedTerritories = playersTerritories.get(curPlayer);

		if (curPlayersOwnedTerritories.contains(defendingTerritory)) {
			return false;
		}
		List <String> connectedTerritories = attackingTerritory.getBorderingTerritories();
		return connectedTerritories.contains(defendingTerritory.getTerritoryID());
	}

	public void battlePhase() {
		String message = Messages.getString("Game.15"); //$NON-NLS-1$
		ui.setEndPhaseButtonVisible(true);
		Player curPlayer = players.get(currTurn); 
		int numOfOwnedTerritories = playersTerritories.get(curPlayer).size();
		while(true) {
			ui.setCancelButtonVisible(false);
			Territory attacker = ui.territoryPrompt(message);
			if (attacker.equals(Territory.END_TERRITORY)){
				break;
			}
			if (!canAttack(attacker)) {
				message = Messages.getString("Game.16"); //$NON-NLS-1$
				continue;
			}
			ui.setCancelButtonVisible(true);
			Territory defender = ui.territoryPrompt(Messages.getString("Game.17")); //$NON-NLS-1$
			if (defender.equals(Territory.CANCEL_TERRITORY)){
				continue;
			}
			if (defender.equals(Territory.END_TERRITORY)){
				break;
			}
			if (attackable(attacker, defender)) {
				battle(attacker, defender);
			}
			else {
				message = Messages.getString("Game.18"); //$NON-NLS-1$
			}
		}

		if (numOfOwnedTerritories < playersTerritories.get(curPlayer).size()) {
			curPlayer.addCardToHand(deck.drawCard());
		}

	}

	public boolean battle(Territory attacker, Territory defender) {
		Player defendingPlayer;
		List <Integer> attackingPlayerRolls = new ArrayList <Integer> ();
		List <Integer> defendingPlayerRolls = new ArrayList <Integer> ();
		int maxUnits = Math.min(attacker.getYield()-1, 3);
		int selectedAttackingUnits = ui.reinforcementCountPrompt(maxUnits, Messages.getString("Game.19"), Messages.getString("Game.20"), JOptionPane.OK_CANCEL_OPTION);    //$NON-NLS-1$ //$NON-NLS-2$
		if (selectedAttackingUnits < 1) {
			ui.displayMessage(Messages.getString("Game.21")); //$NON-NLS-1$
			return false;
		}
		int attackingDiceRolls = Math.min(selectedAttackingUnits, 3);
		for (int currRoll = 0; currRoll < attackingDiceRolls; currRoll++) {
			attackingPlayerRolls.add(rollDice());
		}
		int defendingDiceRolls = Math.min(defender.getYield(), 2);
		for (int currRoll = 0; currRoll < defendingDiceRolls; currRoll++) {
			defendingPlayerRolls.add(rollDice());
		}
		//System.out.println(attackingPlayerRolls);
		//System.out.println(defendingPlayerRolls);
		int minRolls = Math.min(attackingDiceRolls,defendingDiceRolls);
		for (int rolls = 0; rolls < minRolls; rolls++) {
			int maxAttack = Collections.max(attackingPlayerRolls);
			int maxDefend = Collections.max(defendingPlayerRolls);
			if (maxAttack> maxDefend) {
				defender.setYield(defender.getYield() - 1);
			} else {
				attacker.setYield(attacker.getYield() - 1);
			}
			int idMaxAtk = attackingPlayerRolls.indexOf(maxAttack);
			int idMaxDef = defendingPlayerRolls.indexOf(maxDefend);
			attackingPlayerRolls.remove(idMaxAtk);
			defendingPlayerRolls.remove(idMaxDef);
		}
		if (defender.getYield() == 0) {
			maxUnits = attacker.getYield()-1;
			int attackingUnits2Move = -1;

			ui.updateTerritoryDisplay(attacker, players.get(currTurn).getColor());
			ui.updateTerritoryDisplay(defender, players.get(currTurn).getColor());


			attackingUnits2Move = ui.reinforcementCountPrompt(maxUnits, Messages.getString("Game.22"), Messages.getString("Game.23"), JOptionPane.PLAIN_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$

			defendingPlayer = findOwnerOfterritory(defender);
			Set<Territory> defendingPlayersTerritories = this.playersTerritories.get(defendingPlayer);
			defendingPlayersTerritories.remove(defender);

			Player currPlayer = players.get(currTurn);
			Set<Territory> attackingPlayersTerritories = this.playersTerritories.get(currPlayer);
			attackingPlayersTerritories.add(defender);

			defender.setYield(attackingUnits2Move);
			attacker.setYield(attacker.getYield() - attackingUnits2Move);

			
			
			if (defendingPlayersTerritories.size() == 0) {
				ui.displayMessage(Messages.getString("Game.24") + defendingPlayer.ID + Messages.getString("Game.25") + currPlayer.ID); //$NON-NLS-1$ //$NON-NLS-2$
				
				for(Card card : defendingPlayer.getHand()) {
					currPlayer.addCardToHand(card);
				}
				
				
				
			}
			
			

			
		
		}

		ui.updateTerritoryDisplay(attacker, players.get(currTurn).getColor());
		defendingPlayer = findOwnerOfterritory(defender);
		ui.updateTerritoryDisplay(defender, defendingPlayer.getColor());
		return true;
	}

	public Player findOwnerOfterritory(Territory defendingTerritory) {
		for(Player player : players){
			Set<Territory> ownedTerritories = this.playersTerritories.get(player);
			if (ownedTerritories.contains(defendingTerritory)) {
				return player;
			}
		}
		return new Player(0);
	}

	public int rollDice() {
		return rand.nextInt(6) + 1;
	}

	public void autoClaim() {
		RiskUI temp = this.ui;
		this.ui = EasyMock.niceMock(RiskUI.class);
		for (Territory t : territories) {
			EasyMock.expect(this.ui.territoryPrompt(EasyMock.anyString())).andReturn(t);
		}
		EasyMock.replay(this.ui);
		this.claimTerritories();
		int curPlayer = 0;
		for (Territory t : territories) {
			temp.updateTerritoryDisplay(t, Player.COLORS[curPlayer % players.size()]);
			curPlayer++;
		}
		EasyMock.verify(this.ui);
		this.ui = temp;
	}

	public void autoReinforce() {
		for (Player p : players) {
			List <Territory>curPlayerTerritories = new ArrayList<>();
			curPlayerTerritories.addAll(this.playersTerritories.get(p));
			while (p.getReinforcements() > 0) {
				int territoryId = rand.nextInt(curPlayerTerritories.size());
				this.placeOneUnit(curPlayerTerritories.get(territoryId));
			}
			this.switchTurn();
		}
		int curPlayer = 0;
		for (Territory t : territories) {
			this.ui.updateTerritoryDisplay(t, Player.COLORS[curPlayer % players.size()]);
			curPlayer++;
		}
		this.ui.updatePlayerDisplay(0);

	}

	public void fortify() {
		String message = Messages.getString("Game.26"); //$NON-NLS-1$
		boolean moved = false;
		while(!moved) {
			ui.setCancelButtonVisible(false);
			Territory startingTerritory = ui.territoryPrompt(message);
			if (startingTerritory.equals(Territory.END_TERRITORY)){
				break;
			}
			if (!canAttack(startingTerritory)) {
				message = Messages.getString("Game.27"); //$NON-NLS-1$
				continue;
			}
			ui.setCancelButtonVisible(true);
			Territory endTerritory = ui.territoryPrompt(Messages.getString("Game.28")); //$NON-NLS-1$
			if (endTerritory.equals(Territory.CANCEL_TERRITORY)){
				continue;
			}
			if (endTerritory.equals(Territory.END_TERRITORY)){
				break;
			}
			if (canMoveTo(startingTerritory, endTerritory)) {
				moved = moveUnits(startingTerritory, endTerritory);
			}
			else {
				message = Messages.getString("Game.29"); //$NON-NLS-1$
			}
		}
		ui.setCancelButtonVisible(false);
		ui.setEndPhaseButtonVisible(false);
	}

	private boolean moveUnits(Territory startingTerritory, Territory endTerritory) {
		int maxUnits = startingTerritory.getYield()-1;
		int unitsToMove = ui.reinforcementCountPrompt(maxUnits, Messages.getString("Game.30"), Messages.getString("Game.31"), JOptionPane.OK_CANCEL_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
		if (unitsToMove < 1) {
			ui.displayMessage(Messages.getString("Game.32")); //$NON-NLS-1$
			return false;
		}

		endTerritory.setYield(unitsToMove + endTerritory.getYield());
		startingTerritory.setYield(startingTerritory.getYield() - unitsToMove);
		ui.updateTerritoryDisplay(startingTerritory, players.get(currTurn).getColor());
		ui.updateTerritoryDisplay(endTerritory, players.get(currTurn).getColor());
		return true;
	}

	public boolean canMoveTo(Territory startingTerritory, Territory endTerritory) {
		if (startingTerritory.equals(endTerritory)){
			return false;
		}
		List<Territory> passedThrough = new ArrayList<>();
		Stack<Territory> depthFirstSearch = new Stack<>();
		depthFirstSearch.push(startingTerritory);
		Player curPlayer = players.get(currTurn);
		Set<Territory> ownedTerritories = playersTerritories.get(curPlayer);
		while (!depthFirstSearch.isEmpty()) {
			Territory curTerritory = depthFirstSearch.pop();
			if (!passedThrough.contains(curTerritory) && ownedTerritories.contains(curTerritory)) {
				passedThrough.add(curTerritory);
				if (curTerritory.equals(endTerritory)){
					return true;
				}
				List<String> connectedTerritories = curTerritory.getBorderingTerritories();
				for (String territoryId : connectedTerritories) {
					Territory newTerritory = this.getTerritory(territoryId);
					if (newTerritory == null) {
						throw new NullPointerException();
					}
					depthFirstSearch.push(newTerritory);
				}
			}
		}
		return false;
	}

	private Territory getTerritory(String territoryId) {
		for(Territory territory : this.territories) {
			if (territory.getTerritoryID().equals(territoryId))
				return territory;
		}
		return null;
	}
}

