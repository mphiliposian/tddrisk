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

public class TestAllocateUnitPhase {

	@Test
	public void Turnwith1Territory() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ownedTerritories.add(new Territory("NA1", "America1", 0, new ArrayList<String>(), 0, 0));
		player.addTerritory();
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		game.AllocatePhase();
		assertEquals(0, player.getReinforcements());
	}
	
}
