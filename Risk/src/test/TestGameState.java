package test;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import code.Game;
import code.Player;

class TestGameState {

	@Test 
	void testNumPlayers() {
		Game g = new Game();
		Player p = new Player();
		assertEquals(0,g.numPlayers());
	}
	
	@Test 
	void testAddMultiPlayersToGame() {
		Game g = new Game();
		Player p = new Player();
		Player p2 = new Player();
		Player pn = new Player();
		g.addPlayer(p);
		assertEquals(1,g.numPlayers());
		g.addPlayer(p2);
		assertEquals(2,g.numPlayers());
		g.addPlayer(pn);
		g.addPlayer(pn);
		g.addPlayer(pn);
		g.addPlayer(pn);
		assertEquals(6,g.numPlayers());
	}
	
	@Test 
	void testAddAboveMaxPlayers() {
		Game g = new Game();
		Player p = new Player();
		Player p2 = new Player();
		Player pn = new Player();
		g.addPlayer(pn);
		g.addPlayer(pn);
		g.addPlayer(pn);
		g.addPlayer(pn);
		g.addPlayer(pn);
		g.addPlayer(pn);
		g.addPlayer(pn);
		assertEquals(6,g.numPlayers());
	}
	
	@Test
	void testGetNumOfTerritories() {
		Player p = new Player();
		assertEquals(0, p.getNumOfTerritories());
	}
	
	@Test
	void testAddTerritories() {
		Player p = new Player();
		p.addTerritory();
		assertEquals(1, p.getNumOfTerritories());
	}
	
	@Test
	void testWinGameState() {
		Game g = new Game();
		Player p = new Player();
		g.addPlayer(p);
		for(int x = 0; x < 42; x ++ ) {
			p.addTerritory();
		}
		
		assertTrue(g.gameIsWon());
	}

}
