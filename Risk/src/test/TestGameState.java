package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.Game;

class TestGameState {

	@Test
	void testWinGameState() {
		Game g = new Game();
		assertTrue(g.gameIsWon());
	}

}
