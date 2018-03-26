package code.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import code.game.Player;



public class PlayerDisplayPanel{
	
	private JPanel panel;
	
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 0; i < 6; i++) {
			Player p = new Player(i);
			players.add(p);
			p.setReinforcements(20);
		}		
		PlayerDisplayPanel pDp = new PlayerDisplayPanel(players);
		JFrame frame = new JFrame("Players");
		frame.setLayout(new FlowLayout());
		frame.add(pDp.getPanel());
		frame.setSize(800, 200);
		frame.setVisible(true);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

	}
	
	public PlayerDisplayPanel(ArrayList<Player> players) {
		this.panel = new JPanel();
		panel.setBounds(0, 0, 100, 100);
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


