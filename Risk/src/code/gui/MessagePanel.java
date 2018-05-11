package code.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private JLabel label;
	private JButton cancelButton;
	
	public MessagePanel(int width, int height, RiskGUI riskGUI) {
		this.width = width;
		this.height = height;
		this.label = new JLabel();
		this.add(this.label);
		cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setOpaque(true);
		setCancelButtonVisible(true);
		riskGUI.addComponentToFrame(cancelButton, 2, 0, 1, 1);
	}
	
	public void updateMessage(String message) {
		this.label.setText(message);
		this.add(this.label);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}
	
	public void setCancelButtonVisible(boolean isVisible) {
		cancelButton.setVisible(isVisible);
	}
	
}
