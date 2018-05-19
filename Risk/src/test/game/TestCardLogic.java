package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import code.game.Card;
import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;

public class TestCardLogic {

	ArrayList <String> territoriesConnectedToNA1 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA2 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA3 = new ArrayList <String> ();

	@Before
	public void setup() {
		territoriesConnectedToNA1.add("NA2");
		territoriesConnectedToNA1.add("NA3");
		territoriesConnectedToNA2.add("NA1");
		territoriesConnectedToNA2.add("NA3");
		territoriesConnectedToNA3.add("NA2");
	}
	
	@Test
	public void playerGetsCardAfterWinningBattle() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Player player2 = new Player(1);
		Set <Territory> ownedTerritories1 = new HashSet <> ();
		Set <Territory> ownedTerritories2 = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory player2Territory2 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);
		ownedTerritories1.add(player1Territory);
		ownedTerritories2.add(player2Territory);
		ownedTerritories2.add(player2Territory2);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		players.add(player2);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories1);
		playersTerritories.put(player2, ownedTerritories2);
		Game game = new Game(ui, players, playersTerritories, 7);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
		EasyMock.expect(ui.reinforcementCountPrompt(1, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(1);
		EasyMock.expect(ui.reinforcementCountPrompt(1, "Select number of units to move with.", "Reinforcements", JOptionPane.PLAIN_MESSAGE)).andReturn(1);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(new Territory("End", "null", 0, null, 0, 0));
		EasyMock.replay(ui);
		game.battlePhase();
		assertEquals(player.getHand().size(), 1);
		EasyMock.verify(ui);
	}
	
	@Test
	public void playerBattlesButDoesnotTakeTerritory() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 3, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories, 10);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
		EasyMock.expect(ui.reinforcementCountPrompt(2, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(2);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(new Territory("End", "null", 0, null, 0, 0));
		EasyMock.replay(ui);
		game.battlePhase();
		assertEquals(player.getHand().size(), 0);
		EasyMock.verify(ui);
	}
	
	
	@Test
	public void playerGets1CardAfterWinningMultipleBattle() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Player player2 = new Player(1);
		Set <Territory> ownedTerritories1 = new HashSet <> ();
		Set <Territory> ownedTerritories2 = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory player2Territory2 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		ownedTerritories1.add(player1Territory);
		ownedTerritories2.add(player2Territory);
		ownedTerritories2.add(player2Territory2);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		players.add(player2);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories1);
		playersTerritories.put(player2, ownedTerritories2);
		Game game = new Game(ui, players, playersTerritories, 9);
		
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
		EasyMock.expect(ui.reinforcementCountPrompt(3, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(3);
		EasyMock.expect(ui.reinforcementCountPrompt(9, "Select number of units to move with.", "Reinforcements", JOptionPane.PLAIN_MESSAGE)).andReturn(1);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory2);
		EasyMock.expect(ui.reinforcementCountPrompt(3, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(3);
		EasyMock.expect(ui.reinforcementCountPrompt(8, "Select number of units to move with.", "Reinforcements", JOptionPane.PLAIN_MESSAGE)).andReturn(1);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.displayMessage("Player 1 was defeated by Player 0");
		EasyMock.expectLastCall();
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(new Territory("End", "null", 0, null, 0, 0));
		EasyMock.replay(ui);
		game.battlePhase();
		assertEquals(player.getHand().size(), 1);
		EasyMock.verify(ui);
	}
	
	@Test 
	public void validVerify() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		Territory territory1 = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory territory2 = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory territory3 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		
		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card infantry2 = new Card(territory1, Card.CardType.Infantry);
		Card infantry3 = new Card(territory1, Card.CardType.Infantry);
		Card calvary = new Card(territory2, Card.CardType.Calvary);
		Card artillery = new Card(territory3, Card.CardType.Artillery);
		
		List<Card> cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(infantry2);
		cards.add(infantry3);
		
		assertTrue(game.verifyCards(cards));
	}
	
	@Test 
	public void invalidVerify() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		Territory territory1 = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory territory2 = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory territory3 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		
		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card infantry2 = new Card(territory1, Card.CardType.Infantry);
		Card infantry3 = new Card(territory1, Card.CardType.Infantry);
		Card calvary = new Card(territory2, Card.CardType.Calvary);
		Card artillery = new Card(territory3, Card.CardType.Artillery);
		
		List<Card> cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(infantry2);
		cards.add(calvary);
		
		assertFalse(game.verifyCards(cards));
	}
	
	@Test 
	public void uniqueVerify() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		Territory territory1 = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory territory2 = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory territory3 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		
		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card infantry2 = new Card(territory1, Card.CardType.Infantry);
		Card infantry3 = new Card(territory1, Card.CardType.Infantry);
		Card calvary = new Card(territory2, Card.CardType.Calvary);
		Card artillery = new Card(territory3, Card.CardType.Artillery);
		
		List<Card> cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(calvary);
		cards.add(artillery);
		
		assertTrue(game.verifyCards(cards));
	}
	
	@Test 
	public void sameWith1WildValid() {		
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		Territory territory1 = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory territory2 = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory territory3 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		
		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card infantry3 = new Card(territory1, Card.CardType.Infantry);
		
		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(infantry3);
		assertTrue(game.verifyCards(cards));
		
		cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(wild);
		cards.add(infantry3);
		assertTrue(game.verifyCards(cards));
		
		cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(infantry3);
		cards.add(wild);
		assertTrue(game.verifyCards(cards));
		
	}
	
	@Test 
	public void sameWith2WildValid() {		
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		Territory territory1 = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory territory2 = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory territory3 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		
		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card wild2 = new Card(territory1, Card.CardType.WILD);
		
		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(wild2);
		cards.add(infantry1);
		assertTrue(game.verifyCards(cards));
		
		cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(wild2);
		assertTrue(game.verifyCards(cards));
		
		cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(wild);
		cards.add(wild2);
		assertTrue(game.verifyCards(cards));
	}
	
	@Test 
	public void UniqueWith1Wildvalid() {		
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		Territory territory1 = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory territory2 = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory territory3 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		
		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card calvary = new Card(territory1, Card.CardType.Calvary);
		
		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(calvary);
		assertTrue(game.verifyCards(cards));
		
		cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(wild);
		cards.add(calvary);
		assertTrue(game.verifyCards(cards));
		
		cards = new ArrayList<>();
		cards.add(infantry1);
		cards.add(calvary);
		cards.add(wild);
		assertTrue(game.verifyCards(cards));
		
	}
	
	
}
