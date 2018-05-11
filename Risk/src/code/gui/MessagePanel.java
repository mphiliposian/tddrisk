package code.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private JLabel label;
	
	public MessagePanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.label = new JLabel();
		this.add(this.label);
	}
	
	public void updateMessage(String message) {
		this.label.setText(message);
		this.add(this.label);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}
	
}
