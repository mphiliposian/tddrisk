package test.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Test;

import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;


public class TestContinents {
		
		@Test
		public void PlayerOwnsNothing() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
			Game game = new Game(ui, players, playersTerritories);
			
			assertEquals(game.getReinforcementsFromContinents(), 0);	
		}
		
		@Test
		public void PlayerOwnsAmerica() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 10; i++) {
				ownedTerritories.add(new Territory("NA" + i, "America" + i, 0, new ArrayList<String>(), 0, 0));
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
			
			
			
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 5);			
		}

		
		@Test
		public void PlayerOwnsAsia() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 13; i++) {
				ownedTerritories.add(new Territory("AS" + i, "Asia" + i, 0, new ArrayList<String>(), 0, 0));
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
					
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 7);			
		}
		
		@Test
		public void PlayerOwnsSouthAmerica() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 5; i++) {
				ownedTerritories.add(new Territory("SA" + i, "SouthAmerica" + i, 0, new ArrayList<String>(), 0, 0));
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
					
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 2);			
		}
		
		@Test
		public void PlayerOwnsAfrica() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 7; i++) {
				ownedTerritories.add(new Territory("AF" + i, "Africa" + i, 0, new ArrayList<String>(), 0, 0));
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
					
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 3);			
		}
		
		@Test
		public void PlayerOwnsAustralia() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 5; i++) {
				ownedTerritories.add(new Territory("AU" + i, "Australia" + i, 0, new ArrayList<String>(), 0, 0));
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
					
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 2);			
		}
		
		@Test
		public void PlayerOwnsEurope() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 8; i++) {
				ownedTerritories.add(new Territory("EU" + i, "Europe" + i, 0, new ArrayList<String>(), 0, 0));
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
					
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 5);			
		}
		
		@Test
		public void PlayerOwnsEuropeandAmerica() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 10; i++) {
					ownedTerritories.add(new Territory("NA" + i, "America" + i, 0, new ArrayList<String>(), 0, 0));
				if (i < 8) {
					ownedTerritories.add(new Territory("EU" + i, "Europe" + i, 0, new ArrayList<String>(), 0, 0));
				}
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
					
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 10);			
		}
		
		@Test
		public void PlayerOwnsAllTerritories() {
			RiskUI ui = EasyMock.mock(RiskUI.class);
			Player player = new Player(0);
			Set<Territory> ownedTerritories = new HashSet<>();
			for( int i = 1; i < 13; i++) {
				ownedTerritories.add(new Territory("AS" + i, "Asia" + i, 0, new ArrayList<String>(), 0, 0));
				if (i < 5) {
					ownedTerritories.add(new Territory("SA" + i, "South America" + i, 0, new ArrayList<String>(), 0, 0));
				}
				if (i < 10) {
					ownedTerritories.add(new Territory("NA" + i, "America" + i, 0, new ArrayList<String>(), 0, 0));
				}
				if (i < 8) {
					ownedTerritories.add(new Territory("EU" + i, "Europe" + i, 0, new ArrayList<String>(), 0, 0));
				}
				if (i < 7) {
					ownedTerritories.add(new Territory("AF" + i, "Africa" + i, 0, new ArrayList<String>(), 0, 0));
				}
				if (i < 5) {
					ownedTerritories.add(new Territory("AU" + i, "Australia" + i, 0, new ArrayList<String>(), 0, 0));
				}
			}
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
			playersTerritories.put(player, ownedTerritories);
					
			Game game = new Game(ui, players, playersTerritories);
			assertEquals(game.getReinforcementsFromContinents(), 24);			
		}
	
}
