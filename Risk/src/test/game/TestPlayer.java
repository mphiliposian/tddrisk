package test.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.game.Player;

public class TestPlayer {
	
	@Test
	public void testGetColor() {
		for (int i=0; i<6; i++) {
			Player player = new Player(i);
			assertEquals(player.getColor(), Player.COLORS[i]);
		}
	}

}
