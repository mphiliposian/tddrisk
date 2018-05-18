package code.game;

import java.util.ArrayList;
import java.util.List;

import code.game.Card.CardType;
import code.gui.RiskGUI;
import code.gui.RiskUI;

public class GameApp {

	public static void main(String[] args) {
		RiskUI gui = new RiskGUI();
		Game g = new Game(gui);
		g.setup();
	}
}
