package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent clickEvent) {
		
		JButton button = (JButton) clickEvent.getSource();
		String territoryId = button.getName();
		System.out.println(territoryId);
		
	}

}
