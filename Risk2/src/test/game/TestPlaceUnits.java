package test.game;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;

import code.game.Game;
import code.game.Territory;
import code.gui.RiskUI;

public class TestPlaceUnits {
		
	@Test
	public void placeInitialReinforcementsWith3Players() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		EasyMock.expect(ui.territoryPrompt("")).andReturn(new Territory(null, null, 0, null, 0, 0)).atLeastOnce();
		Game game = new Game(ui);
	
		EasyMock.replay(ui);
		game.createPlayers();
		game.placeInitialReinforcements();
		
		EasyMock.verify(ui);
		for (int playerID = 0; playerID < game.numPlayers(); playerID++) {
			assertEquals(game.getPlayerByID(playerID).getReinforcements(), 0);
			assertEquals(game.getPlayerByID(playerID).getNumOfTerritories(), 14);
		}
		for (int territoryID = 0; territoryID < 42; territoryID++) {
			game.getTerritoryByID(territoryID);
		}
	}
}
