package test.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import code.game.Game;
import code.game.Territory;
import code.game.TerritoryReader;
import code.gui.RiskUI;

public class TestPlaceUnits {

	@Test
	public void placeInitialReinforcementsWith3Players() {
		RiskUI ui = EasyMock.mock(RiskUI.class);
		EasyMock.expect(ui.playerCountPrompt()).andReturn(3);
		createMockedTerritores(ui);
		Game game = new Game(ui);

		EasyMock.replay(ui);
		game.createPlayers();
		game.initializeReinforcements();
		int startingReinforcements = game.getPlayerByID(0).getReinforcements();
		game.claimTerritories();

		
		EasyMock.verify(ui);
		for (int playerID = 0; playerID < game.numPlayers(); playerID++) {
			assertTrue(game.getPlayerByID(playerID).getReinforcements() < startingReinforcements);
			assertEquals(game.getPlayerByID(playerID).getNumOfTerritories(), 14);
		}
		for (int territoryID = 0; territoryID < 42; territoryID++) {
			//assertTrue(game.getTerritoryByID(territoryID).getYield() > 0);
		}
	}

	private List<String> getFakeNeighbors() {
		ArrayList<String> neighbors = new ArrayList<String>();
		neighbors.add("NA2");
		neighbors.add("NA6");
		neighbors.add("AS6");
		return neighbors;
	}

	private void createMockedTerritores(RiskUI ui) {
		List<Territory> territories = new TerritoryReader().readTerritories("TerritoryTestMap.txt");
		int currTerritory = 0;
		System.out.println(territories);
		for(Territory territory : territories) {
			if (currTerritory == 1|| currTerritory == 15 || currTerritory == 43 || currTerritory == 44) {
				territory.setYield(1);
				EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(territory);
			}
			else {
				EasyMock.expect(ui.territoryPrompt(EasyMock.anyString())).andReturn(territory);
				
				ui.updateTerritoryDisplay(EasyMock.anyObject(), EasyMock.anyObject());
				EasyMock.expectLastCall();
				
				ui.updatePlayerDisplay(EasyMock.anyInt());
				EasyMock.expectLastCall();
			}
			currTerritory++;
		}
	}
}
