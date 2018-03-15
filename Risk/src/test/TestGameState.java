package test;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import code.Game;
import code.Player;

class TestGameState {

	@Test 
	void testAddPlayerToGame() {
		Game g = new Game();
		Player p = new Player();
		g.addPlayer(p);
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
