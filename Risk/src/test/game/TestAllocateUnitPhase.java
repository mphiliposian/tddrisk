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

public class TestAllocateUnitPhase {

	public static Set<Territory> asiaStubs(int n) {
		Set<Territory> stubs = new HashSet<>();
		for (int i=1; i<=n; i++) {
			stubs.add(new Territory("AS" + i, null, 0, null, 0, 0));
		}
		return stubs;
	}
	
	@Test
	public void allocateWith1Territory() {
		// Setup
		Set<Territory> ownedTerritories = new HashSet<>();
		Territory expectedTerritory =
				new Territory("NA1", "America1", null, 0, 0);
		ownedTerritories.add(expectedTerritory);
		ArrayList<Player> players = new ArrayList<>();
		Player player = new Player(0);
		player.addTerritory();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Game game = new Game(ui, players, playersTerritories);

		// Record
		EasyMock.expect(ui.territoryPrompt(""))
			.andReturn(expectedTerritory).times(3);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall().times(3);
		ui.updatePlayerDisplay(0);
		EasyMock.expectLastCall().times(3);
		
		// Replay
		EasyMock.replay(ui);
		game.allocatePhase();
		
		// Verify
		EasyMock.verify(ui);
		assertEquals(0, player.getReinforcements());
	}
	
	@Test
	public void allocateWithAsia() {
		Set<Territory> asia = asiaStubs(12);
		Territory expectedTerritory = asia.iterator().next();
		ArrayList<Player> players = new ArrayList<>();
		Player player = new Player(0);
		for (int i=0; i<12; i++) {
			player.addTerritory();
		}
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, asia);
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Game game = new Game(ui, players, playersTerritories);
		int totalReinforcements = 11;
		
		// Record
		EasyMock.expect(ui.territoryPrompt(""))
			.andReturn(expectedTerritory).times(totalReinforcements);
		ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
		EasyMock.expectLastCall().times(totalReinforcements);
		ui.updatePlayerDisplay(0);
		EasyMock.expectLastCall().times(totalReinforcements);
		
		// Replay
		EasyMock.replay(ui);
		game.allocatePhase();
		
		// Verify
		EasyMock.verify(ui);
		assertEquals(0, player.getReinforcements());
	}
	
}
