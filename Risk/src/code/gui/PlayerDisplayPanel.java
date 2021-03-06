package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import code.game.Player;

public class PlayerDisplayPanel {

	private JPanel panel;
	private List <IndividualPlayerPanel> playerPanels;
	private GridBagLayout gridbag;
	private GridBagConstraints constraints;

	public PlayerDisplayPanel(List <Player> players, int width, int height) {
		this.panel = new JPanel();
		gridbag = new GridBagLayout();
		constraints = new GridBagConstraints();
		this.panel.setLayout(gridbag);
		panel.setPreferredSize(new Dimension(width, height));
		playerPanels = new ArrayList <> ();
		int i = 0;
		for (Player player: players) {
			IndividualPlayerPanel individualPlayerPanel = new IndividualPlayerPanel(player);
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridx = i;
			constraints.gridy = 0;
			this.panel.add(individualPlayerPanel, constraints);
			playerPanels.add(individualPlayerPanel);
			i++;
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void updatePlayerPanel(int activePlayer) {
		int curPanel = 0;
		for (IndividualPlayerPanel individualPlayerPanel: playerPanels) {
			if (curPanel == activePlayer) {
				individualPlayerPanel.setAsActiveTurn();
			} else {
				individualPlayerPanel.setAsInactiveTurn();
			}
			individualPlayerPanel.updateValues();
			curPanel++;
		}
	}

	private class IndividualPlayerPanel extends JPanel {

		private static final long serialVersionUID = 7847058765801012990L;
		private Player player;
		private JLabel reinforcement;

		public IndividualPlayerPanel(Player player) {
			super();
			this.player = player;
			this.setBackground(this.player.getColor());
			JLabel playerName = new JLabel(Messages.getString("PlayerDisplayPanel.0") + (player.ID + 1)); //$NON-NLS-1$
			this.add(playerName);
			this.reinforcement = new JLabel(Messages.getString("PlayerDisplayPanel.1") + player.getReinforcements()); //$NON-NLS-1$
			this.add(reinforcement);
			this.setBorder(BorderFactory.createLineBorder(Color.black));
		}

		public void updateValues() {
			reinforcement.setText(Messages.getString("PlayerDisplayPanel.2") + player.getReinforcements()); //$NON-NLS-1$
		}

		public void setAsInactiveTurn() {
			this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}

		public void setAsActiveTurn() {
			this.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		}
	}
}
