package code.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

public class TestUI {

	public static void main(String[] args) {
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
		MapGUI gui = new MapGUI(screenResolution.getWidth(), screenResolution.getHeight());
		gui.initializeMap("map.png", "TerritoryMap.txt");
		gui.drawMap();
	}
	
}