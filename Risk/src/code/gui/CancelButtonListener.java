package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.game.Territory;

public class CancelButtonListener implements ActionListener{

	private RiskGUI ui;
	
	public CancelButtonListener(RiskGUI ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ui.selectTerritory(Territory.CANCEL_TERRITORY);
	}
	
}
