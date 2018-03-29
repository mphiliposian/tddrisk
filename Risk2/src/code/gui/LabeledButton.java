package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabeledButton {
	private JLabel label;
	private JButton button;
	private String value;
	private String id;

	public LabeledButton(JPanel panel, String labelName, String value) {
		this.value = value;
		this.label = new JLabel(labelName);
		this.button = new JButton(value);
		this.label.setForeground(Color.RED);
		this.label.setFont(this.label.getFont().deriveFont(14.0f));
		panel.add(button);
		panel.add(label);
	}
	
	public void setBounds(int x, int y, int width, int height) {
		this.label.setHorizontalAlignment(JLabel.CENTER);
		this.label.setBounds(x-50, y-60, width+100, height+80);
		this.button.setBounds(x, y, width, height);
	}
	
	public void updateValue(String newValue) {
		this.value = newValue;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.button.setName(id);
	}
	
	public void addActionListener(ActionListener l) {
		this.button.addActionListener(l);
	}
}
