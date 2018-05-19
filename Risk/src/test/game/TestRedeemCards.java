package test.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Test;

import code.game.Card;
import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;

public class TestRedeemCards {

	@Test
	public void redeem1SetOfCards() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);

		Territory territory1 = new Territory("NA1", "murica", 10, null, 0, 0);

		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card calvary = new Card(territory1, Card.CardType.Calvary);

		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(calvary);

		player.addCardToHand(wild);
		player.addCardToHand(infantry1);
		player.addCardToHand(calvary);

		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		
		assertEquals(game.redeemCards(player, cards), 4);
		assertEquals(player.getHand().size(),0);
		assertEquals(game.deck.discardPile.size(), 3);
	}
	
	@Test
	public void redeem2SetOfCards() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);

		Territory territory1 = new Territory("NA1", "murica", 10, null, 0, 0);

		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card calvary = new Card(territory1, Card.CardType.Calvary);

		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(calvary);

		player.addCardToHand(wild);
		player.addCardToHand(infantry1);
		player.addCardToHand(calvary);

		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
	
		game.redeemedSets = 1;
		assertEquals(game.redeemCards(player, cards), 6);
		assertEquals(player.getHand().size(),0);
		assertEquals(game.deck.discardPile.size(), 3);
	}
	
	@Test
	public void redeem3SetOfCards() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);

		Territory territory1 = new Territory("NA1", "murica", 10, null, 0, 0);

		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card calvary = new Card(territory1, Card.CardType.Calvary);

		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(calvary);

		player.addCardToHand(wild);
		player.addCardToHand(infantry1);
		player.addCardToHand(calvary);

		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		
		game.redeemedSets = 3;
		assertEquals(game.redeemCards(player, cards), 10);
		assertEquals(player.getHand().size(),0);
		assertEquals(game.deck.discardPile.size(), 3);
	}
	
	@Test
	public void redeem7SetOfCards() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);

		Territory territory1 = new Territory("NA1", "murica", 10, null, 0, 0);

		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card calvary = new Card(territory1, Card.CardType.Calvary);

		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(calvary);

		player.addCardToHand(wild);
		player.addCardToHand(infantry1);
		player.addCardToHand(calvary);

		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		
		game.redeemedSets = 6;
		assertEquals(game.redeemCards(player, cards), 15);
		assertEquals(player.getHand().size(),0);
		assertEquals(game.deck.discardPile.size(), 3);
	}
	
	@Test
	public void redeem6SetOfCards() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);

		Territory territory1 = new Territory("NA1", "murica", 10, null, 0, 0);

		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card calvary = new Card(territory1, Card.CardType.Calvary);

		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(calvary);

		player.addCardToHand(wild);
		player.addCardToHand(infantry1);
		player.addCardToHand(calvary);

		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		
		game.redeemedSets = 7;
		assertEquals(game.redeemCards(player, cards), 20);
		assertEquals(player.getHand().size(),0);
		assertEquals(game.deck.discardPile.size(), 3);
	}

	@Test
	public void redeemSetOfCardsBack2Back() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set<Territory> ownedTerritories = new HashSet<>();
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);

		Territory territory1 = new Territory("NA1", "murica", 10, null, 0, 0);

		Card infantry1 = new Card(territory1, Card.CardType.Infantry);
		Card wild = new Card(territory1, Card.CardType.WILD);
		Card calvary = new Card(territory1, Card.CardType.Calvary);

		List<Card> cards = new ArrayList<>();
		cards.add(wild);
		cards.add(infantry1);
		cards.add(calvary);

		player.addCardToHand(wild);
		player.addCardToHand(infantry1);
		player.addCardToHand(calvary);

		Map<Player, Set<Territory>> playersTerritories = new HashMap<>();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		
		assertEquals(game.redeemCards(player, cards), 4);
		assertEquals(player.getHand().size(),0);
		assertEquals(game.deck.discardPile.size(), 3);
		
		player.addCardToHand(wild);
		player.addCardToHand(infantry1);
		player.addCardToHand(calvary);
		
		assertEquals(game.redeemCards(player, cards), 6);
		assertEquals(player.getHand().size(),0);
		assertEquals(game.deck.discardPile.size(), 6);
	}

}


