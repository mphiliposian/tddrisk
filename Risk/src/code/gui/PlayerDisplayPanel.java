package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import code.game.Player;



public class PlayerDisplayPanel{
	
	private JPanel panel;
	private List<IndividualPlayerPanel> playerPanels;
	
	public PlayerDisplayPanel(List<Player> players, int width, int height) {
		this.panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		playerPanels = new ArrayList<>();
		for (Player player : players) {
			IndividualPlayerPanel individualPlayerPanel = new IndividualPlayerPanel(player);
			this.panel.add(individualPlayerPanel);
			playerPanels.add(individualPlayerPanel);
		}	
	}
	
	public JPanel getPanel() {
		return panel;
	}
	

	public void updatePlayerPanel(int activePlayer) {
		int curPanel = 0;
		for (IndividualPlayerPanel individualPlayerPanel : playerPanels) {
			if (curPanel == activePlayer) {
				individualPlayerPanel.setAsActiveTurn();
			}
			else {
				individualPlayerPanel.setAsInactiveTurn();
			}
			individualPlayerPanel.updateValues();
			curPanel++;
		}
		
	}
	
	
	private class IndividualPlayerPanel extends JPanel{
		
		private static final long serialVersionUID = 7847058765801012990L;
		private Player player;
		private JLabel reinforcement;
		
		public IndividualPlayerPanel(Player player) {
			super();
			this.player = player;
			this.setBackground(this.player.getColor());
			JLabel playerName = new JLabel("Player " + (player.ID + 1));
			this.add(playerName);
			this.reinforcement = new JLabel("R~: " + player.getReinforcements());
			this.add(reinforcement);
			this.setBorder(BorderFactory.createLineBorder(Color.black));
		}

		public void updateValues() {
			reinforcement.setText("R~: " + player.getReinforcements());
		}
		
		public void setAsInactiveTurn() {
			this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		}
		
		public void setAsActiveTurn() {
			this.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		}
		
	}



}


