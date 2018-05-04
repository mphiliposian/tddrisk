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
	private CompletableFuture<Territory> selectedTerritory;
	
	@Override
	public void initializeUI(List<Territory> territories) {
		frame = new JFrame(Messages.getString("RiskGUI.GameName")); //$NON-NLS-1$
		GridLayout layout = new GridLayout(2, 0);
		frame.setLayout(layout);
		frame.setVisible(true);
				
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public int playerCountPrompt() {
		Object[] possibilities = {"3", "4", "5", "6"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		int numOfPlayers = Integer.parseInt((String)JOptionPane.showInputDialog(
		                    frame,
		                    Messages.getString("RiskGUI.NumOfPlayers"), //$NON-NLS-1$
		                    Messages.getString("RiskGUI.GameName"), //$NON-NLS-1$
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "3")); //$NON-NLS-1$

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
		mapPanel = new MapPanel(windowWidth, windowHeight, territories);
		
		mapPanel.addSelectionListeners(this);
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
			throw new RuntimeException(Messages.getString("RiskGUI.RTException"), e); //$NON-NLS-1$
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
