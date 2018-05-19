package code.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import code.game.Card.CardType;

public class Deck {

	Stack<Card> drawPile = new Stack<>();
	public Stack<Card> discardPile = new Stack<>();
	Random rand;

	public Deck(List<Territory> territories, Random rand) {
		this.rand = rand;
		this.drawPile = initializeDeck(territories);
	}

	public Stack<Card> initializeDeck(List<Territory> territories) {
		Stack<Card> deck = new Stack<>();
		for(int i = 0; i < territories.size(); i++) {
			CardType type = CardType.values()[i%3];
			Card card = new Card(territories.get(i), type);
			deck.add(card);
		}
		for(int i = 0; i < 2; i++) {
			Card card = new Card(null, CardType.WILD);
			deck.add(card);
		}
		Collections.shuffle(deck,this.rand);
		return deck;
	}

	public Card drawCard() {
		if (!this.isEmpty()) {
			return drawPile.pop();
		}
		this.reShuffleDiscard();
		return drawPile.pop();
	}

	private void reShuffleDiscard() {
		Collections.shuffle(discardPile, rand);
		for(int i = 0; i < discardPile.size(); i++){
			drawPile.push(discardPile.pop());
		}
	}
	
	public void discard(Card card) {
		discardPile.push(card);
	}

	public boolean isEmpty() {
		return drawPile.isEmpty();
	}
}



