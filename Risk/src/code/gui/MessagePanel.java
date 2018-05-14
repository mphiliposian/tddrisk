package code.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private JLabel label;
	private JButton cancelButton;
	private JPanel cancelPanel;
	
	public MessagePanel(int width, int height, RiskGUI riskGUI) {
		this.width = width;
		this.height = height;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(new JPanel());
		this.label = new JLabel();
		this.label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(this.label);
		cancelPanel = new JPanel();
		cancelPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.cancelButton = createCancelButton();
		cancelPanel.add(cancelButton);
		this.add(cancelPanel);
		
	}
	
	private JButton createCancelButton() {
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setOpaque(true);
		cancelButton.setVisible(true);
		cancelButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		return cancelButton;
	}
	
	public void updateMessage(String message) {
		this.label.setText(message);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}
	
	public void setCancelButtonVisible(boolean isVisible) {
		cancelButton.setVisible(isVisible);
	}
	
}
