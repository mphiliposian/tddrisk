package test.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;

public class TestFortifying {

	ArrayList <String> connectedTerritories = new ArrayList <String> ();


	@Before
	public void setup() {
		connectedTerritories.add("NA2");
		connectedTerritories.add("NA6");
		connectedTerritories.add("AS6");
	}
	
	@Test
	public void TerritoriesConnectedTogether() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		
		Territory start = new Territory("NA1", "America1", 0, connectedTerritories, 0, 0);
		Territory end = new Territory("NA2", "America1", 0, new ArrayList <String> (), 0, 0);
		ownedTerritories.add(start);
		ownedTerritories.add(end);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertEquals(game.canMoveTo(start, end), true);
	}
	
	@Test
	public void TerritoriesNotConnectedTogether() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory start = new Territory("NA1", "America1", 0, connectedTerritories, 0, 0);
		Territory end = new Territory("NA3", "America1", 0, new ArrayList <String> (), 0, 0);
		ownedTerritories.add(start);
		ownedTerritories.add(end);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertEquals(game.canMoveTo(start, end), false);
	}
	
	@Test
	public void moveToSameTerritory() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory start = new Territory("NA1", "America1", 0, connectedTerritories, 0, 0);
		Territory end = new Territory("NA1", "America1", 0, new ArrayList <String> (), 0, 0);
		ownedTerritories.add(start);
		ownedTerritories.add(end);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertEquals(game.canMoveTo(start, end), false);
	}
	
	@Test
	public void moveToUnOwnedTerritory() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory start = new Territory("NA1", "America1", 0, connectedTerritories, 0, 0);
		Territory end = new Territory("NA2", "America1", 0, new ArrayList <String> (), 0, 0);
		ownedTerritories.add(start);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertEquals(game.canMoveTo(start, end), false);
	}
	
}
