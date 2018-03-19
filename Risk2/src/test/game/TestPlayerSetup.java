package test.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import code.game.Game;
import code.game.Player;
import code.gui.RiskUI;

// TODO: Find a way around this. Current workaround for static ID.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPlayerSetup {
	
	// Goals:
	// - Units given appropriately
	// - Turn ordering
	
	@Test
	public void aThreeAndSixPlayersIDs() {
		Player[] ps = new Player[3];
		for (int i=0; i<3; i++) {
			ps[i] = new Player();
			assertEquals(ps[i].ID, i);
		}
		
		Player[] ps2 = new Player[3];
		for (int i=0; i<3; i++) {
			ps2[i] = new Player();
			assertEquals(ps2[i].ID, i + 3);
		}
	}
	
	
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
	
	@Test
	public void highNumberOfPlayers() {
		RiskUI fakeGui = EasyMock.mock(RiskUI.class);
		EasyMock.expect(fakeGui.playerCountPrompt()).andReturn(7);
		EasyMock.expect(fakeGui.playerCountPrompt()).andReturn(6);
		
		EasyMock.replay(fakeGui);
		
		Game g = new Game(fakeGui);
		g.createPlayers();
		
		EasyMock.verify(fakeGui);
		assertEquals(g.numPlayers(), 6);
	}
	
	@Test
	public void initialReinforcements() {
		RiskUI fakeGui = EasyMock.mock(RiskUI.class);
		Game g = new Game(fakeGui);
		Player p = new Player();
		g.addPlayer(p);
		for (int i=0; i<2; i++) {
			g.addPlayer(new Player());
		}
		
		g.initializeReinforcements();
		assertEquals(35, p.getReinforcements());
		g.addPlayer(new Player());
		g.initializeReinforcements();
		assertEquals(30, p.getReinforcements());
		g.addPlayer(new Player());
		g.initializeReinforcements();
		assertEquals(25, p.getReinforcements());
		g.addPlayer(new Player());
		g.initializeReinforcements();
		assertEquals(20, p.getReinforcements());
	}	
}
