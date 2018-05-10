package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Test;

import code.game.Game;
import code.game.Territory;
import code.gui.RiskUI;

public class TestAttacking {

	@Test
	public void attackCountryWith1Unit() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		ArrayList<String> territoriesConnectedToNA1 = new ArrayList<String>();
		territoriesConnectedToNA1.add("NA2");
		ArrayList<String> territoriesConnectedToNA2 = new ArrayList<String>();
		territoriesConnectedToNA1.add("NA1");
		Territory player1Territory = new Territory("NA1", "murica", 2, null, 0, 0);
		Territory player2Territory = new Territory("NA2", "murica2", 1, null, 0, 0);

		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
		
		EasyMock.replay(ui);
		game.createPlayers();
		

		assertTrue(game.attack());
		EasyMock.verify(ui);
	}
	
	@Test
	public void attackCountryNotConnected() {
		RiskUI ui = EasyMock.niceMock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		Game game = new Game(ui);
		ArrayList<String> territoriesConnectedToNA1 = new ArrayList<String>();
		territoriesConnectedToNA1.add("NA2");
		ArrayList<String> territoriesConnectedToNA3 = new ArrayList<String>();
		territoriesConnectedToNA3.add("NA2");
		Territory player1Territory = new Territory("NA1", "murica", 2, null, 0, 0);
		Territory player2Territory = new Territory("NA3", "murica2", 1, null, 0, 0);

		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player1Territory);
		EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(player2Territory);
		
		EasyMock.replay(ui);
		game.createPlayers();
		

		assertFalse(game.attack());
		EasyMock.verify(ui);
	}

}
