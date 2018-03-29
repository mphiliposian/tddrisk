package code.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import code.game.Player;
import code.game.Territory;

public class RiskGUI implements RiskUI{
	private JFrame frame;
	private JPanel playerPanel;
	private JPanel mapPanel;
	
	@Override
	public void initializeUI(List<Territory> territories) {
		frame = new JFrame("Risk");
		GridLayout layout = new GridLayout(2, 0);
		frame.setLayout(layout);
		frame.setVisible(true);
				
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public int playerCountPrompt() {
		Object[] possibilities = {"3", "4", "5", "6"};
		int numOfPlayers = Integer.parseInt((String)JOptionPane.showInputDialog(
		                    frame,
		                    "Please select the number of players:\n",
		                    "RISK",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "3"));

		return numOfPlayers;
	}

	@Override
	public void createPlayerDisplay(List<Player> players) {
		PlayerDisplayPanel playerDisplayPanel = new PlayerDisplayPanel(players, 100, 500);
		playerPanel = playerDisplayPanel.getPanel();
		frame.add(playerPanel);
		frame.pack();
	}
	
	@Override
	public void createMapDisplay(List<Territory> territories) {
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
		
		double width = screenResolution.getWidth();
		double height = screenResolution.getHeight();
		
		Double scaledWidth = width * 0.6;
		Double scaledHeight = height * 0.6;
		int windowWidth = scaledWidth.intValue();
		int windowHeight = scaledHeight.intValue();
		mapPanel = new MapPanel(windowWidth, windowHeight, territories);
		
		frame.add(mapPanel);
		frame.pack();
	}

	@Override
	public void updatePlayerDisplay() {
		
		//for (Player p : players)
		//System.out.println(
	}

	@Override
	public void updateTerritoryDisplay(Territory territory) {
		System.out.println("Territory display updated: " + territory);
	}

	@Override
	public Territory territoryPrompt(String message) {
		return null;
	}
}
