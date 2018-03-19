package test.game;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;

import code.game.Game;
import code.game.Player;
import code.gui.RiskUI;

public class TestPlayerSetup {
	
	// Goals:
	// - Player count between 3 and 6
	// - Units given appropriately
	// - Turn ordering
	
	@Test
	public void lowNumberOfPlayers() {
		RiskUI fakeGui = EasyMock.mock(RiskUI.class);
		EasyMock.expect(fakeGui.playerCountPrompt()).andReturn(0);
		EasyMock.expect(fakeGui.playerCountPrompt()).andReturn(1);
		EasyMock.expect(fakeGui.playerCountPrompt()).andReturn(3);

		EasyMock.replay(fakeGui);
		
		Game g = new Game(fakeGui);
		g.createPlayers();
		
		EasyMock.verify(fakeGui);
		assertEquals(g.numPlayers(), 3);
	}
}
