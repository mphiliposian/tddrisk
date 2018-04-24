package test.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Test;

import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;

public class TestAllocateUnits {
	//Test 1, 8, 9 ,41 ,42
	
	@Test
	public void Playerhas1Territory() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		for( int i = 0; i < 1; i++) {
			player.addTerritory();
		}
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		
		assertEquals(game.getReinforcementsFromTerritories(), 3);	
	}
	
	@Test
	public void Playerhas8Territory() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		for( int i = 0; i < 8; i++) {
			player.addTerritory();
		}
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		
		assertEquals(game.getReinforcementsFromTerritories(), 3);	
	}
	

	
}
