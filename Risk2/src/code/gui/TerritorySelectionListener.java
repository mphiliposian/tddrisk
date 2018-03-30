package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.game.Territory;

public class TerritorySelectionListener implements ActionListener {
	private RiskGUI gui;
	private Territory territory;
	
	public TerritorySelectionListener(RiskGUI gui, Territory t) {
		this.gui = gui;
		this.territory = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.setLatestTerritory(territory);
	}

}