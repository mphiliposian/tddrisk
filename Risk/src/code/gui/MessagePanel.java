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
	private JButton cancel;

	public MessagePanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.label = new JLabel();
		this.cancel = new JButton("Cancel");
		this.add(this.label);
		this.add(this.cancel);
	}

	public void updateMessage(String message) {
		this.label.setText(message);
		this.add(this.label);
	}

	public void setButtonVisible(boolean isVisible) {
		this.cancel.setVisible(isVisible);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}
}
