package code.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import code.game.Card;
import code.game.Player;
import code.game.Territory;

public interface RiskUI {
	void initializeUI(List <Territory> territories);
	int playerCountPrompt();
	void createPlayerDisplay(List <Player> players);
	void createMapDisplay(List <Territory> territories);
	void updatePlayerDisplay(int activePlayer);
	void updateTerritoryDisplay(Territory territory, Color color);
	Territory territoryPrompt(String message);
	void setCancelButtonVisible(boolean isVisible);
	void addCancelButtonListener(ActionListener listener);
	int reinforcementCountPrompt(int max, String title, String message, int jOptionType);
	void displayMessage(String message);
	void setEndPhaseButtonVisible(boolean isVisible);
	void addEndPhaseButtonListener(ActionListener listener);
	void setPhaseText(String phase);
	void setCardValue(int value);
	List<Card> selectCards(int playerID, List<Card> hand);
	void setSelected(boolean selected, Card card);
	void addCardListener(Card card, ActionListener actionListener);
}
