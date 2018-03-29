package code.gui;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import code.game.Player;
import code.game.Territory;

public class RiskGUI implements RiskUI{
	private JFrame frame; 
	
	@Override
	public void initializeUI(List<Territory> territories) {
		frame = new JFrame("Risk");
		frame.setLayout(new FlowLayout());
		frame.setSize(800, 200);
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
		PlayerDisplayPanel playerPanel = new PlayerDisplayPanel(players);
		frame.add(playerPanel.getPanel());
		frame.pack();
	}

	@Override
	public void updatePlayerDisplay() {
		System.out.println("Player display updated!");
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
