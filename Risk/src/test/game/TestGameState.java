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

public class TestGameState {

	public RiskUI mockGui() {
		return EasyMock.mock(RiskUI.class);
	}

	@Test
	public void numPlayers() {
		Game g = new Game(mockGui());
		assertEquals(0, g.numPlayers());
	}

	@Test
	public void getNumOfTerritories() {
		Player p = new Player(0);
		assertEquals(0, p.getNumOfTerritories());
	}

	@Test
	public void addTerritories() {
		Player p = new Player(0);
		p.addTerritory();
		assertEquals(1, p.getNumOfTerritories());
	}

	@Test
	public void winGameState() {
		RiskUI mockUI = mockGui();
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		for( int i = 0; i < 42; i++) {
			ownedTerritories.add(new Territory("Territory" + i, null, i, null, i, i));
		}
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		
		ui.displayMessage("Player 1 Won!");
		EasyMock.expectLastCall();
		EasyMock.replay(ui);
		
		Game game = new Game(ui, players, playersTerritories);
		
		assertTrue(game.gameIsWon());
		EasyMock.verify(ui);
	}



	@Test
	public void gameIsWon0Territories() {
		RiskUI mockUI = mockGui();
		EasyMock.expect(mockUI.playerCountPrompt()).andReturn(6);
		EasyMock.replay(mockUI);
		Game g = new Game(mockUI);
		g.createPlayers();
		EasyMock.verify(mockUI);
		assertFalse(g.gameIsWon());
	}

	@Test
	public void gameIsWon0Players() {
		RiskUI mockUI = mockGui();
		Game g = new Game(mockUI);
		assertFalse(g.gameIsWon());
	}

	@Test
	public void placeInitialReinforcements() {
		RiskUI riskGui = mockGui();
		Game partialGame = EasyMock.partialMockBuilder(Game.class)
				.withConstructor(riskGui)
				.addMockedMethod("claimTerritories")
				.addMockedMethod("reinforceTerritories")
				.createStrictMock();
		partialGame.claimTerritories();
		EasyMock.expectLastCall();
		partialGame.reinforceTerritories();
		EasyMock.expectLastCall();
		EasyMock.replay(partialGame);
		partialGame.placeInitialReinforcements();
		EasyMock.verify(partialGame);
	}
}
