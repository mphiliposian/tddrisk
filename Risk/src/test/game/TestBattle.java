package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;

public class TestBattle {

	ArrayList <String> territoriesConnectedToNA1 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA2 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA3 = new ArrayList <String> ();

	@Before
	public void setup() {
		territoriesConnectedToNA1.add("NA2");
		territoriesConnectedToNA2.add("NA1");
		territoriesConnectedToNA2.add("NA3");
		territoriesConnectedToNA3.add("NA2");
	}

	@Test
	public void player1Wins2Battle() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 8, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories, 2);
		EasyMock.expect(ui.reinforcementCountPrompt(3, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(3);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 10);
		assertEquals(player2Territory.getYield(), 6);
		EasyMock.verify(ui);

	}

	@Test
	public void bothPlayersLoseUnitInBattle() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 8, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories, 9);
		EasyMock.expect(ui.reinforcementCountPrompt(3, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(3);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 9);
		assertEquals(player2Territory.getYield(), 7);
		EasyMock.verify(ui);
	}

	@Test
	public void PlayersLoseBothUnitsInBattle() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 8, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories, 4);
		EasyMock.expect(ui.reinforcementCountPrompt(3, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(3);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 8);
		assertEquals(player2Territory.getYield(), 8);
		EasyMock.verify(ui);
	}

	@Test
	public void PlayersHas3UnitsAndAttacks() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 3, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 4, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories, 4);
		EasyMock.expect(ui.reinforcementCountPrompt(2, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(2);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 1);
		assertEquals(player2Territory.getYield(), 4);
		EasyMock.verify(ui);
	}
	
	@Test
	public void PlayerCancelsAttack() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 3, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 4, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories, 4);
		EasyMock.expect(ui.reinforcementCountPrompt(2, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(-1);
		ui.displayMessage("You must have at least 2 units to attack!");
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertFalse(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 3);
		assertEquals(player2Territory.getYield(), 4);
		EasyMock.verify(ui);
	}

	@Test
	public void PlayerAttacksWith2Units() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories, 4);
		EasyMock.expect(ui.reinforcementCountPrompt(1, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(1);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 1);
		assertEquals(player2Territory.getYield(), 1);
		EasyMock.verify(ui);
	}

	@Test
	public void PlayerAttacksWith3Units() {
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
		EasyMock.expect(ui.reinforcementCountPrompt(2, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(2);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 2);
		assertEquals(player2Territory.getYield(), 1);
		EasyMock.verify(ui);
	}

	@Test
	public void PlayerWinsBattleAndTakesTerritory() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Player player2 = new Player(1);
		Set <Territory> ownedTerritories1 = new HashSet <> ();
		Set <Territory> ownedTerritories2 = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		ownedTerritories1.add(player1Territory);
		ownedTerritories2.add(player2Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		players.add(player2);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories1);
		playersTerritories.put(player2, ownedTerritories2);
		Game game = new Game(ui, players, playersTerritories, 5);
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
		ui.displayMessage("Player 1 was defeated by Player 0");
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 1);
		assertEquals(player2Territory.getYield(), 1);
		assertEquals(game.findOwnerOfterritory(player2Territory),player);
		EasyMock.verify(ui);
	}

	@Test
	public void PlayerWinsBattleAndTakesTerritoryPlayer2StillHasTerritories() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Player player2 = new Player(1);
		Set <Territory> ownedTerritories1 = new HashSet <> ();
		Set <Territory> ownedTerritories2 = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
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
		Game game = new Game(ui, players, playersTerritories, 5);
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
		EasyMock.replay(ui);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 1);
		assertEquals(player2Territory.getYield(), 1);
		assertEquals(game.findOwnerOfterritory(player2Territory),player);
		EasyMock.verify(ui);
	}

	@Test
	public void validDiceRolls() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		Player player = new Player(0);
		Player player2 = new Player(1);
		Set <Territory> ownedTerritories1 = new HashSet <> ();
		Set <Territory> ownedTerritories2 = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		ownedTerritories1.add(player1Territory);
		ownedTerritories2.add(player2Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		players.add(player2);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories1);
		playersTerritories.put(player2, ownedTerritories2);
		Game game = EasyMock.partialMockBuilder(Game.class)
				.withConstructor(ui, players, playersTerritories, 5)
				.addMockedMethod("rollDice").createMock();
		EasyMock.expect(ui.reinforcementCountPrompt(1, "Select number of units to attack with.", "Reinforcements", JOptionPane.OK_CANCEL_OPTION)).andReturn(1);
		
		EasyMock.expect(game.rollDice()).andReturn(2).times(2);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(ui,game);
		assertTrue(game.battle(player1Territory, player2Territory));
		assertEquals(player1Territory.getYield(), 1);
		assertEquals(player2Territory.getYield(), 1);
		EasyMock.verify(ui,game);
	}
	



	
}
