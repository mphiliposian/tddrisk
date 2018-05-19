package test.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import code.game.Card;
import code.game.Card.CardType;
import code.game.Deck;
import code.game.Territory;

public class TestDeck {
	ArrayList <String> territoriesConnectedToNA1 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA2 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA3 = new ArrayList <String> ();

	@Before
	public void setup() {
		territoriesConnectedToNA1.add("NA2");
		territoriesConnectedToNA1.add("NA3");
		territoriesConnectedToNA2.add("NA1");
		territoriesConnectedToNA2.add("NA3");
		territoriesConnectedToNA3.add("NA2");
	}
	
	@Test
	public void testDeckIsEmpty() {
		Deck deck = new Deck(new ArrayList<Territory>(), new Random());
		for(int i = 0; i < 2; i++) {
			deck.drawCard();
		}
		boolean canDraw = true;
		try {
			deck.drawCard();
		} catch(EmptyStackException e) {
			canDraw = false;
		}
		
		assertFalse(canDraw);
		assertTrue(deck.isEmpty());
	}
	
	@Test
	public void testDrawPileToDiscardPile() {
		ArrayList <Territory> allTerritories = new ArrayList <Territory> ();
		Territory territory1 = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory territory2 = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		Territory territory3 = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);
		allTerritories.add(territory1);
		allTerritories.add(territory2);
		allTerritories.add(territory3);
		
		Deck deck = new Deck(allTerritories, new Random());
		
		for(int i = 0; i < allTerritories.size()+2; i++) {
			deck.discard(deck.drawCard());
		}
		
		boolean cardExistsInPile = true;
		int numWilds = 0;
		for(int i = 0; i < allTerritories.size()+2; i++) {
			Card card = deck.drawCard();
			if(card.getCardType() == CardType.WILD) {
				numWilds++;
			} else if(!(allTerritories.contains(card.getTerritory()))) {
				cardExistsInPile = false;
			}
		}
		assertTrue(numWilds == 2);
		assertTrue(cardExistsInPile);
	}

}
