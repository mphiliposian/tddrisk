package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class TestBattle {

		ArrayList<String> territoriesConnectedToNA1 = new ArrayList<String>();
		ArrayList<String> territoriesConnectedToNA2 = new ArrayList<String>();
		ArrayList<String> territoriesConnectedToNA3 = new ArrayList<String>();
		
		@Before
		public void setup() {
		territoriesConnectedToNA1.add("NA2");
		territoriesConnectedToNA2.add("NA1");
		territoriesConnectedToNA2.add("NA3");
		territoriesConnectedToNA3.add("NA2");
		}
		
		@Test
		public void player1Wins2Battle() {
			RiskUI ui = EasyMock.strictMock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			Territory player1Territory = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
			Territory player2Territory = new Territory("NA2", "murica2", 8, territoriesConnectedToNA2, 0, 0);
			
			ownedTerritories.add(player1Territory);
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);	
			Game game = new Game(ui, players, playersTerritories, 2);
			
			EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
			EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
			EasyMock.replay(ui);
			
			game.battle();

			assertEquals(player1Territory.getYield(), 10);
			assertEquals(player2Territory.getYield(), 6);
			EasyMock.verify(ui);
		}
		
		@Test
		public void bothPlayersLoseUnitInBattle() {
			RiskUI ui = EasyMock.strictMock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			Territory player1Territory = new Territory("NA1", "murica", 10, territoriesConnectedToNA1, 0, 0);
			Territory player2Territory = new Territory("NA2", "murica2", 8, territoriesConnectedToNA2, 0, 0);
			
			ownedTerritories.add(player1Territory);
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);	
			Game game = new Game(ui, players, playersTerritories, 9);
			
			EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
			EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
			EasyMock.replay(ui);
			
			game.battle();

			assertEquals(player1Territory.getYield(), 9);
			assertEquals(player2Territory.getYield(), 7);
			EasyMock.verify(ui);
		}
}
