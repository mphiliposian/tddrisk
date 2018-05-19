package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.game.Card;
import code.game.Player;
import code.game.Territory;

public class TestPlayer {

	@Test
	public void testGetColor() {
		for (int i = 0; i < 6; i++) {
			Player player = new Player(i);
			assertEquals(player.getColor(), Player.COLORS[i]);
		}
	}

	@Test
	public void addCardToPlayer() {
		Player player = new Player(0);
		Card card = new Card(new Territory("End", "null", 0, null, 0, 0), Card.CardType.Artillery);
		assertEquals(player.getHand().size(),0);
		assertTrue(player.addCardToHand(card));
		assertEquals(player.getHand().size(),1);
	}


}
