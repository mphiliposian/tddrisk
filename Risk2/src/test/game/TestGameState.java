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
	void numPlayers() {
		Game g = new Game(mockGui());
		assertEquals(0,g.numPlayers());
	}
	
	@Test
	void getNumOfTerritories() {
		Player p = new Player(0);
		assertEquals(0, p.getNumOfTerritories());
	}
	
	@Test
	void addTerritories() {
		Player p = new Player(0);
		p.addTerritory();
		assertEquals(1, p.getNumOfTerritories());
	}
	
	@Test
	void winGameState() {
		RiskUI mockUI = mockGui();
		EasyMock.expect(mockUI.playerCountPrompt()).andReturn(6);
		
		EasyMock.replay(mockUI);
		Game g = new Game(mockUI);
		g.createPlayers();
		for(int x = 0; x < 42; x++) {
			g.getPlayerByID(0).addTerritory();
		}
		
		EasyMock.verify(mockUI);
		assertTrue(g.gameIsWon());
	}
	
	@Test
	void gameIsWon0Territories() {
		RiskUI mockUI = mockGui();
		EasyMock.expect(mockUI.playerCountPrompt()).andReturn(6);
		
		EasyMock.replay(mockUI);
		Game g = new Game(mockUI);
		g.createPlayers();
		
		EasyMock.verify(mockUI);
		assertFalse(g.gameIsWon());
	}
	
	@Test
	void gameIsWon0Players() {
		RiskUI mockUI = mockGui();
		Game g = new Game(mockUI);
		assertFalse(g.gameIsWon());
	}
}
