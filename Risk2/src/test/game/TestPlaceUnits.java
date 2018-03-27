package test.game;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import code.game.Game;
import code.gui.RiskUI;

public class TestPlaceUnits {
		
	@Test
	public void placeInitialReinforcementsWith3Players() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
	
		EasyMock.replay(ui);
		game.createPlayers();
		game.placeInitialReinforcements();
		
		EasyMock.verify(ui);
		for (int playerID = 0; playerID < game.numPlayers(); playerID++) {
			assertEquals(game.getPlayerByID(playerID).getReinforcements(), 0);
		}
	}
}
