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

public class TestFortifying {

	@Test
	public void TerritoriesConnectedTogether() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		ownedTerritories.add(new Territory("NA1", "America1", 0, new ArrayList <String> (), 0, 0));
		ownedTerritories.add(new Territory("NA2", "America1", 0, new ArrayList <String> (), 0, 0));
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertEquals(game.canMoveto(), true);
	}
	
}
