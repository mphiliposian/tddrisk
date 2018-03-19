package code.gui;

import java.util.List;

import code.game.Player;
import code.game.Territory;

public interface RiskUI {

	void initializeUI(List<Territory> territories);
	
	int playerCountPrompt();
	
	void createPlayerDisplay(List<Player> players);
	
	void updatePlayerDisplay(Player player);
	
	void updateTerritoryDisplay(Territory territory);
	
	Territory territoryPrompt(String message);
	
}
