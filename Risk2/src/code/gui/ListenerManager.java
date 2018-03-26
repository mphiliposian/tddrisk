package code.gui;

import javax.swing.JButton;

public class ListenerManager {
	
	void addListener(JButton button){
		button.addActionListener(new ButtonListener());
		
	}
}
