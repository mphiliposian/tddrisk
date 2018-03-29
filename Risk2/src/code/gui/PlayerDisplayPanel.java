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
	
	public PlayerDisplayPanel(List<Player> players, int width, int height) {
		this.panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		for (Player p : players) {
			IndividualPlayerPanel iPP = new IndividualPlayerPanel(p);
			this.panel.add(iPP);
		}	
	}
	
	public JPanel getPanel() {
		return panel;
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
		
	}
	
}


