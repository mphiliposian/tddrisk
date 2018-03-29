package code.gui;

import java.util.List;

import code.game.Player;
import code.game.Territory;

public interface RiskUI {

	void initializeUI(List<Territory> territories);
	
	int playerCountPrompt();
	
	void createPlayerDisplay(List<Player> players);
	
	void createMapDisplay(List<Territory> territories);
	
	void updatePlayerDisplay();
	
	void updateTerritoryDisplay(Territory territory);
	
	Territory territoryPrompt(String message);
	
}
