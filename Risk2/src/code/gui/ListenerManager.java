package code.gui;

public class ListenerManager {
	
	void addListener(LabeledButton lButton){
		lButton.addActionListener(new ButtonListener());
		
	}
}
