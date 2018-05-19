package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

	@Test
	public void addManyCardsToPlayer() {
		Player player = new Player(0);
		Card card = new Card(new Territory("End", "null", 0, null, 0, 0), Card.CardType.Artillery);
		assertEquals(player.getHand().size(),0);
		for(int cardNum = 0; cardNum < 3; cardNum++) {
			assertTrue(player.addCardToHand(card));
		}
		assertEquals(player.getHand().size(),3);
	}

	@Test
	public void addMaxCardsToPlayer() {
		Player player = new Player(0);
		Card card = new Card(new Territory("End", "null", 0, null, 0, 0), Card.CardType.Artillery);
		assertEquals(player.getHand().size(),0);
		for(int cardNum = 0; cardNum < 6; cardNum++) {
			assertTrue(player.addCardToHand(card));
		}
		assertEquals(player.getHand().size(),6);
		assertFalse(player.addCardToHand(card));
		assertEquals(player.getHand().size(),6);
	}

	@Test
	public void removeCardFromPlayer() {
		Player player = new Player(0);
		Card card = new Card(new Territory("End", "null", 0, null, 0, 0), Card.CardType.Artillery);
		assertEquals(player.getHand().size(),0);
		assertTrue(player.addCardToHand(card));
		assertEquals(player.getHand().size(),1);
		player.removeCard(card);
		assertEquals(player.getHand().size(),0);
	}


	@Test
	public void removeCardFromEmptyPlayer() {
		Player player = new Player(0);
		Card card = new Card(new Territory("End", "null", 0, null, 0, 0), Card.CardType.Artillery);
		try {
			player.removeCard(card);
			fail("Should have raised a IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
