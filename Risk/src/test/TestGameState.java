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
	void testgetNumOfTerritories() {
		Player p = new Player();
		assertEquals(0, p.getNumOfTerritories());
	}
	
	/*
	@Test
	void testWinGameState() {
		Game g = new Game();
		Player p = EasyMock.mock(Player.class);
		EasyMock.expect(p.getNumOfTerritories()).andReturn(42);
		assertTrue(g.gameIsWon());
	}
	*/
}
