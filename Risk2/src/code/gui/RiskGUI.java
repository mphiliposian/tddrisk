package code.gui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import code.game.Player;
import code.game.Territory;

public class RiskGUI implements RiskUI{
	private JFrame frame; 
	

	
	@Override
	public void initializeUI(List<Territory> territories) {
		this.frame = new JFrame();
		
	}

	@Override
	public int playerCountPrompt() {
		Object[] possibilities = {"3", "4", "5", "6"};
		int s = Integer.parseInt((String)JOptionPane.showInputDialog(
		                    frame,
		                    "Please select the number of players:\n",
		                    "RISK",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "3"));

		return s;
	}

	@Override
	public void createPlayerDisplay(List<Player> players) {
				
	}

	@Override
	public void updatePlayerDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTerritoryDisplay(Territory territory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Territory territoryPrompt(String message) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
