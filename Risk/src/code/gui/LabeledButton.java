package code.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabeledButton {

	private JLabel label;
	private JButton button;

	public LabeledButton(JPanel panel, String labelName, String value) {
		this.label = new JLabel(labelName);
		this.button = new JButton(value);
		this.label.setForeground(Color.RED);
		this.label.setFont(this.label.getFont().deriveFont(14.0f));
		panel.add(button);
		panel.add(label);
	}

	public void setBounds(int x, int y, int width, int height) {
		this.label.setHorizontalAlignment(JLabel.CENTER);
		this.label.setBounds(x - 50, y - 60, width + 100, height + 80);
		this.button.setBounds(x, y, width, height);
	}

	public void setID(String id) {
		this.button.setName(id);
	}

	public void addActionListener(ActionListener l) {
		this.button.addActionListener(l);
	}

	public void setText(int yield) {
		this.button.setText("" + yield);
	}

	public void setColor(Color color) {
		this.button.setBackground(color);
	}
}
