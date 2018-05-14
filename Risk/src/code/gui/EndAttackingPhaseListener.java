package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import code.game.Territory;

public class EndAttackingPhaseListener implements ActionListener{

	private RiskGUI ui;
	
	public EndAttackingPhaseListener(RiskGUI ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ui.selectTerritory(Territory.END_TERRITORY);
	}
	
}
