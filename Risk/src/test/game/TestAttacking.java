package test.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import code.game.Game;
import code.game.Player;
import code.game.Territory;
import code.gui.RiskUI;

public class TestAttacking {

	ArrayList <String> territoriesConnectedToNA1 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA2 = new ArrayList <String> ();
	ArrayList <String> territoriesConnectedToNA3 = new ArrayList <String> ();

	@Before
	public void setup() {
		territoriesConnectedToNA1.add("NA2");
		territoriesConnectedToNA2.add("NA1");
		territoriesConnectedToNA2.add("NA3");
		territoriesConnectedToNA3.add("NA2");
	}

	@Test
	public void attackCountryWith1Unit() {
		RiskUI ui = EasyMock.strictMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, territoriesConnectedToNA2, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertTrue(game.canAttack(player1Territory, player2Territory));
	}

	@Test
	public void attackCountryNotConnected() {
		RiskUI ui = EasyMock.strictMock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertFalse(game.canAttack(player1Territory, player2Territory));
	}

	@Test
	public void attackWithUnownedCountry() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player3Territory = new Territory("NA1", "murica", 2, territoriesConnectedToNA1, 0, 0);
		Territory player2Territory = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);
		ownedTerritories.add(new Territory("NA2", "America", 0, territoriesConnectedToNA2, 0, 0));
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertFalse(game.canAttack(player3Territory, player2Territory));
	}

	@Test
	public void attackOwnedCountry() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA2", "murica", 2, territoriesConnectedToNA2, 0, 0);
		Territory alsoPlayer1Territory = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);
		ownedTerritories.add(player1Territory);
		ownedTerritories.add(alsoPlayer1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertFalse(game.canAttack(player1Territory, alsoPlayer1Territory));
	}

	@Test
	public void attackWithOnly1Unit() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		Player player = new Player(0);
		Set <Territory> ownedTerritories = new HashSet <> ();
		Territory player1Territory = new Territory("NA2", "murica", 1, territoriesConnectedToNA2, 0, 0);
		Territory player2Territory = new Territory("NA3", "murica2", 1, territoriesConnectedToNA3, 0, 0);
		ownedTerritories.add(player1Territory);
		ArrayList <Player> players = new ArrayList <> ();
		players.add(player);
		Map <Player, Set <Territory>> playersTerritories = new HashMap <> ();
		playersTerritories.put(player, ownedTerritories);
		Game game = new Game(ui, players, playersTerritories);
		assertFalse(game.canAttack(player1Territory, player2Territory));
	}
}
