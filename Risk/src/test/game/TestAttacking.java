package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

public class TestAttacking {

	@Test
	public void attackCountryWith1Unit() {
		RiskUI ui = EasyMock.strictMock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<String> territoriesConnectedToNA1 = new ArrayList<String>();
		territoriesConnectedToNA1.add("NA2");
		ownedTerritories.add(new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0));
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);	
		Game game = new Game(ui, players, playersTerritories);
		
		ArrayList<String> territoriesConnectedToNA2 = new ArrayList<String>();
		territoriesConnectedToNA2.add("NA1");
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);

		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
		EasyMock.replay(ui);
		assertTrue(game.attack());
		EasyMock.verify(ui);
	}
	
	@Test
	public void attackCountryNotConnected() {
		RiskUI ui = EasyMock.strictMock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<String> territoriesConnectedToNA1 = new ArrayList<String>();
		territoriesConnectedToNA1.add("NA2");
		ownedTerritories.add(new Territory("NA1", "murica", 0, territoriesConnectedToNA1, 0, 0));
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);	
		Game game = new Game(ui, players, playersTerritories);
		
		ArrayList<String> territoriesConnectedToNA3 = new ArrayList<String>();
		territoriesConnectedToNA3.add("NA2");
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);

		
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
		EasyMock.replay(ui);

		
		assertFalse(game.attack());
		EasyMock.verify(ui);
		
	}
	
	@Test
	public void attackWithUnownedCountry() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<String> territoriesConnectedToNA2 = new ArrayList<String>();
		territoriesConnectedToNA2.add("NA1");
		territoriesConnectedToNA2.add("NA3");
		ownedTerritories.add(new Territory("NA2", "America", 0, territoriesConnectedToNA2, 0, 0));
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);	
		Game game = new Game(ui, players, playersTerritories);
		
		ArrayList<String> territoriesConnectedToNA1 = new ArrayList<String>();
		territoriesConnectedToNA1.add("NA2");
		ArrayList<String> territoriesConnectedToNA3 = new ArrayList<String>();
		territoriesConnectedToNA3.add("NA2");
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);

		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.replay(ui);

		assertFalse(game.attack());
		EasyMock.verify(ui);
	}

}
