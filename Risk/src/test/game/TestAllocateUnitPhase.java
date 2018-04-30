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

	@Test
	public void turnWith1Territory() {
		// Record
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<Player> players = new ArrayList<>();
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		
		Player player = new Player(0);
		player.addTerritory();
		players.add(player);
		
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Territory expectedTerritory =
				new Territory("NA1", "America1", null, 0, 0);
		ownedTerritories.add(expectedTerritory);
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);

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
	
}
