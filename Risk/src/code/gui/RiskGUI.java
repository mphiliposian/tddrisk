package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JComponent;
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
	private GridBagLayout gridbag;
	private GridBagConstraints constraints;
	private JButton cancelButton;
	
	@Override
	public void initializeUI(List<Territory> territories) {
		frame = new JFrame("Risk");
		gridbag = new GridBagLayout();
		constraints = new GridBagConstraints();
		frame.setLayout(gridbag);
		frame.setVisible(true);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	public void addComponentToFrame(JComponent component, int x, int y, int width, int height) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		gridbag.setConstraints(component, constraints);
        frame.add(component);
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
		playerDisplayPanel = new PlayerDisplayPanel(players, 500, 100);
		playerPanel = playerDisplayPanel.getPanel();
		this.addComponentToFrame(playerPanel, 0, 2, 2, 1);
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
		messagePanel = new MessagePanel(100, 30);
		messagePanel.updateMessage("Goddag til dig!");
		
		cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setOpaque(true);
		this.setCancelButtonVisible(true);
		
		mapPanel = new MapPanel(windowWidth, windowHeight, territories);
		mapPanel.addSelectionListeners(this);
		
		this.addComponentToFrame(messagePanel, 0, 0, 2, 1);
		this.addComponentToFrame(cancelButton, 2, 0, 1, 1);
		this.addComponentToFrame(mapPanel, 0, 1, 2, 1);
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

	@Override
	public void setCancelButtonVisible(boolean isVisible) {
		cancelButton.setVisible(isVisible);
	}
}
