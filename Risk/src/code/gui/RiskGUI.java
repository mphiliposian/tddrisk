package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import code.game.Player;
import code.game.Territory;

public class RiskGUI implements RiskUI{
	private JFrame frame;
	private JPanel playerPanel;
	private PlayerDisplayPanel playerDisplayPanel;
	private MapPanel mapPanel;
	private MessagePanel messagePanel;
	private CompletableFuture<Territory> selectedTerritory;
	
	@Override
	public void initializeUI(List<Territory> territories) {
		frame = new JFrame("Risk");
		GridLayout layout = new GridLayout(3, 0);
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
		playerDisplayPanel = new PlayerDisplayPanel(players, 100, 500);
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
		messagePanel = new MessagePanel(100, 200);
		messagePanel.updateMessage("Gud dag gu digg!");
		messagePanel.setButtonVisible(false);
		mapPanel = new MapPanel(windowWidth, windowHeight, territories);
		
		mapPanel.addSelectionListeners(this);
		frame.add(messagePanel);
		frame.add(mapPanel);
		frame.pack();
	}

	@Override
	public void updatePlayerDisplay(int activePlayer) {
		playerDisplayPanel.updatePlayerPanel(activePlayer);
	}

	@Override
	public void updateTerritoryDisplay(Territory territory, Color color) {
		mapPanel.updateTerritory(territory, color);
	}

	@Override
	public Territory territoryPrompt(String message) {
		try {
			return this.waitForTerritory();
		} catch (Exception e) {
			throw new RuntimeException("Runtime exception occurred while waiting for territory selection.", e);
		}
	}
	
	public void selectTerritory(Territory territory) {
		this.selectedTerritory.complete(territory);
	}
	
	private Territory waitForTerritory() throws InterruptedException, ExecutionException {
		selectedTerritory = new CompletableFuture<>();
		return selectedTerritory.get();
	}
}
