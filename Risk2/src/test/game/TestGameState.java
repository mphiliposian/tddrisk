package test.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;

class TestGameState {
	
	private RiskUI mockGui() {
		return EasyMock.mock(RiskUI.class);
	}

	@Test 
	void testNumPlayers() {
		Game g = new Game(mockGui());
		assertEquals(0,g.numPlayers());
	}
	
	@Test
	void testGetNumOfTerritories() {
		Player p = new Player(0);
		assertEquals(0, p.getNumOfTerritories());
	}
	
	@Test
	void testAddTerritories() {
		Player p = new Player(0);
		p.addTerritory();
		assertEquals(1, p.getNumOfTerritories());
	}
	
	@Test
	void testWinGameState() {
		RiskUI mockUI = mockGui();
		EasyMock.expect(mockUI.playerCountPrompt()).andReturn(6);
		Game g = new Game(mockUI);
		
		EasyMock.replay(mockUI);
		g.createPlayers();
		
		EasyMock.verify(mockUI);
		
		for(int x = 0; x < 42; x ++ ) {
			g.addTerritoryToPlayer(0, new Territory());
		}
		
		assertTrue(g.gameIsWon());
	}

}
