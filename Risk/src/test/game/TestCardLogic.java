package test.game;

import static org.junit.Assert.assertEquals;
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

public class TestCardLogic {

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
	public void playerGetsCardAfterWinningBattle() {
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
	
}