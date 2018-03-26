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
	void testAddMultiPlayersToGame() {
		Game g = new Game(mockGui());
		Player p = new Player(0);
		g.addPlayer(p);
		assertEquals(1,g.numPlayers());
		g.addPlayer(p);
		assertEquals(2,g.numPlayers());
		g.addPlayer(p);
		g.addPlayer(p);
		g.addPlayer(p);
		g.addPlayer(p);
		assertEquals(6,g.numPlayers());
	}
	
	@Test 
	void testAddAboveMaxPlayers() {
		Game g = new Game(mockGui());
		Player p = new Player(0);
		for (int i=0; i<6; i++) {
			g.addPlayer(p);
		}
		
		assertEquals(6,g.numPlayers());
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
		Game g = new Game(mockGui());
		Player p = new Player(0);
		g.addPlayer(p);
		for(int x = 0; x < 42; x ++ ) {
			p.addTerritory();
		}
		
		assertTrue(g.gameIsWon());
	}

}
