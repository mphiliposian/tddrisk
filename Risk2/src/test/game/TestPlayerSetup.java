package test.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.easymock.EasyMock;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import code.game.Game;
import code.game.Player;
import code.gui.RiskUI;

public class TestPlayerSetup {
	
	@Test
	public void aThreeAndSixPlayersIDs() {
		Player[] ps = new Player[3];
		for (int i=0; i<3; i++) {
			ps[i] = new Player(i);
			assertEquals(ps[i].ID, i);
		}
		
		Player[] ps2 = new Player[6];
		for (int i=0; i<6; i++) {
			ps2[i] = new Player(i);
			assertEquals(ps2[i].ID, i);
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
		// Record
		RiskUI fakeUI = EasyMock.strictMock(RiskUI.class);
		EasyMock.expect(fakeUI.playerCountPrompt()).andReturn(3);
		EasyMock.expect(fakeUI.playerCountPrompt()).andReturn(5);
		EasyMock.expect(fakeUI.playerCountPrompt()).andReturn(6);
		
		// Replay
		EasyMock.replay(fakeUI);
		Game g = new Game(fakeUI);
		g.createPlayers();
		g.initializeReinforcements();
		Player player0 = g.getPlayerByID(0);
		assertEquals(35, player0.getReinforcements());
		
		g.createPlayers();
		g.initializeReinforcements();
		player0 = g.getPlayerByID(0);
		assertEquals(25, player0.getReinforcements());

		g.createPlayers();
		g.initializeReinforcements();
		player0 = g.getPlayerByID(0);
		assertEquals(20, player0.getReinforcements());
		
		// Verify
		EasyMock.verify(fakeUI);
	}
	
	@Test
	public void switchTurn3Players() {
		RiskUI fakeGui = EasyMock.mock(RiskUI.class);
		EasyMock.expect(fakeGui.playerCountPrompt()).andReturn(3);
		
		EasyMock.replay(fakeGui);
		Game g = new Game(fakeGui);
		g.createPlayers();
		
		assertEquals(g.currentTurn(),0);
		g.switchTurn();
		assertEquals(g.currentTurn(),1);
		g.switchTurn();
		assertEquals(g.currentTurn(),2);
		g.switchTurn();
		assertEquals(g.currentTurn(),0);
		
		EasyMock.verify(fakeGui);
	}
	
	@Test
	public void switchTurn6Players() {
		RiskUI fakeGui = EasyMock.mock(RiskUI.class);
		EasyMock.expect(fakeGui.playerCountPrompt()).andReturn(6);
		
		EasyMock.replay(fakeGui);
		Game g = new Game(fakeGui);
		g.createPlayers();
		
		assertEquals(g.currentTurn(),0);
		g.switchTurn();
		assertEquals(g.currentTurn(),1);
		g.switchTurn();
		g.switchTurn();
		g.switchTurn();
		g.switchTurn();
		assertEquals(g.currentTurn(),5);
		g.switchTurn();
		assertEquals(g.currentTurn(),0);
	}
	
}
