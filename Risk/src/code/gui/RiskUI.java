package code.gui;

import java.awt.Color;
import java.util.List;

import code.game.Player;
import code.game.Territory;

public interface RiskUI {

	void initializeUI(List<Territory> territories);
	
	int playerCountPrompt();
	
	void createPlayerDisplay(List<Player> players);
	
	void createMapDisplay(List<Territory> territories);
	
	void updatePlayerDisplay(int activePlayer);
	
	void updateTerritoryDisplay(Territory territory, Color color);
	
	Territory territoryPrompt(String message);
	
	void setCancelButtonVisible(boolean isVisible);
	
	int reinforcementCountPrompt(int max, String title, String message);
	
}
