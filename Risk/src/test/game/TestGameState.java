package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.easymock.EasyMock;
import org.junit.Test;
import code.game.Game;
import code.game.Player;
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
		EasyMock.expect(mockUI.playerCountPrompt()).andReturn(6);
		EasyMock.replay(mockUI);
		Game g = new Game(mockUI);
		g.createPlayers();
		for (int x = 0; x < 42; x++) {
			g.getPlayerByID(0).addTerritory();
		}
		EasyMock.verify(mockUI);
		assertTrue(g.gameIsWon());
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
