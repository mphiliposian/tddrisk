package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import code.game.Card;
import code.game.Player;
import code.game.Territory;

public class RiskGUI implements RiskUI {

	private JFrame frame;
	private JPanel playerPanel;
	private PlayerDisplayPanel playerDisplayPanel;
	private MapPanel mapPanel;
	private MessagePanel messagePanel;
	private CompletableFuture <Territory> selectedTerritory;
	private GridBagLayout gridbag;
	private GridBagConstraints constraints;
	private HandPanel handPanel;

	@Override
	public void initializeUI(List <Territory> territories) {
		frame = new JFrame(Messages.getString("RiskGUI.0")); //$NON-NLS-1$
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
		Object[] possibilities = {
			Messages.getString("RiskGUI.1"), //$NON-NLS-1$
			Messages.getString("RiskGUI.2"), //$NON-NLS-1$
			Messages.getString("RiskGUI.3"), //$NON-NLS-1$
			Messages.getString("RiskGUI.4") //$NON-NLS-1$
		};
		int numOfPlayers = Integer.parseInt((String) JOptionPane.showInputDialog(
			frame,
			Messages.getString("RiskGUI.5"), //$NON-NLS-1$
			Messages.getString("RiskGUI.6"), //$NON-NLS-1$
			JOptionPane.PLAIN_MESSAGE,
			null,
			possibilities,
			Messages.getString("RiskGUI.7"))); //$NON-NLS-1$
		return numOfPlayers;
	}

	@Override
	public void createPlayerDisplay(List <Player> players) {
		playerDisplayPanel = new PlayerDisplayPanel(players, 1000, 100);
		playerPanel = playerDisplayPanel.getPanel();
		this.addComponentToFrame(playerPanel, 0, 2, 2, 1);
		frame.pack();
	}

	@Override
	public void createMapDisplay(List <Territory> territories) {
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenResolution.getWidth();
		double height = screenResolution.getHeight();
		Double scaledWidth = width * 0.6;
		Double scaledHeight = height * 0.6;
		int windowWidth = scaledWidth.intValue();
		int windowHeight = scaledHeight.intValue();
		messagePanel = new MessagePanel(windowWidth, 30);
		messagePanel.updateMessage(Messages.getString("RiskGUI.8")); //$NON-NLS-1$
		messagePanel.addCancelButtonListener(new CancelButtonListener(this));
		messagePanel.addEndPhaseButtonListener(new EndAttackingPhaseListener(this));
		mapPanel = new MapPanel(windowWidth, windowHeight, territories);
		mapPanel.addSelectionListeners(this);
		this.addComponentToFrame(messagePanel, 0, 0, 3, 1);
		this.addComponentToFrame(mapPanel, 0, 1, 1, 1);
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
		this.messagePanel.updateMessage(message);
		try {
			return this.waitForTerritory();
		} catch (Exception e) {
			throw new RuntimeException(Messages.getString("RiskGUI.9"), e); //$NON-NLS-1$
		}
	}

	public void selectTerritory(Territory territory) {
		if (!this.selectedTerritory.isDone()) {
			this.selectedTerritory.complete(territory);
		}
	}

	private Territory waitForTerritory() throws InterruptedException, ExecutionException {
		selectedTerritory = new CompletableFuture <> ();
		return selectedTerritory.get();
	}

	@Override
	public int reinforcementCountPrompt(int max, String title, String message, int jOptionType) {
		JOptionPane sliderPane = new JOptionPane(Messages.getString("RiskGUI.10"), JOptionPane.PLAIN_MESSAGE, jOptionType); //$NON-NLS-1$
		JSlider slider = new JSlider();
		slider.setMinimum(1);
		slider.setMaximum(max);
		slider.setValue(max);
		slider.setMajorTickSpacing(((int) (max/10)) + 1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		JLabel countLabel = new JLabel(message + Messages.getString("RiskGUI.11") + max); //$NON-NLS-1$
		sliderPane.setMessage(new Object[] {
			countLabel,
			slider
		});
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				countLabel.setText(message + Messages.getString("RiskGUI.12") + slider.getValue()); //$NON-NLS-1$
				sliderPane.setInputValue(slider.getValue());
			}
		});
		JDialog sliderDialog = sliderPane.createDialog(frame, title);
		sliderDialog.setVisible(true);
		if (sliderPane.getValue() == null || (int) sliderPane.getValue() == JOptionPane.CANCEL_OPTION) {
			return -1;
		}
		return slider.getValue();
	}

	@Override
	public void setCancelButtonVisible(boolean isVisible) {
		this.messagePanel.setCancelButtonVisible(isVisible);
	}
	
	@Override
	public void addCancelButtonListener(ActionListener listener) {
		this.messagePanel.addCancelButtonListener(listener);
	}

	@Override
	public void displayMessage(String message) {
		this.messagePanel.updateMessage(message);
	}
	
	@Override
	public void setEndPhaseButtonVisible(boolean isVisible) {
		this.messagePanel.setEndPhaseButtonVisible(isVisible);
	}
	
	@Override
	public void addEndPhaseButtonListener(ActionListener listener) {
		this.messagePanel.addEndPhaseButtonListener(listener);
	}

	@Override
	public void setPhaseText(String phase) {
		this.messagePanel.setPhaseText(phase);
	}
	
	@Override
	public void setCardValue(int value) {
		this.messagePanel.setCardValue(value);
	}
	
	@Override
	public List<Card> selectCards(int playerID, List<Card> hand) {
		JOptionPane handPane = new JOptionPane(Messages.getString("RiskGUI.13"), JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION); //$NON-NLS-1$
		this.handPanel = new HandPanel(hand);
		handPane.setMessage(new Object[] { this.handPanel } );
		
		boolean cancel = false;
		List<Card> selectedCards = new ArrayList<>();
		while (selectedCards.size() != 3) {
			JDialog handDialog = handPane.createDialog(Messages.getString("RiskGUI.14")); //$NON-NLS-1$
			handDialog.setVisible(true);
			if ( handPane.getValue() == null || (int) handPane.getValue() == JOptionPane.CANCEL_OPTION) {
				cancel = true;
				break;
			} else {
				selectedCards = this.handPanel.getSelectedCards();
			}
		}
		
		this.handPanel = null;
		if (cancel) {
			return null;
		}
		return selectedCards;
	}
}
