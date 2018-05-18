package code.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private JLabel phaseIndicator;
	private JLabel cardValueIndicator;
	private JLabel label;
	private JButton cancelButton;
	private JButton endPhaseButton;
	
	public MessagePanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.phaseIndicator = createPhaseLabel();
		this.add(phaseIndicator);
		this.cardValueIndicator = createCardValueLabel();
		this.add(cardValueIndicator);
		this.add(new JPanel());
		this.label = new JLabel();
		this.add(this.label);
		this.cancelButton = createCancelButton();
		JPanel cancelPanel = new JPanel();
		cancelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelPanel.add(cancelButton);
		this.add(cancelPanel);
		this.endPhaseButton = createEndPhaseButton();
		this.add(endPhaseButton);
	}
	
	private JLabel createPhaseLabel() {
		JLabel phaseLabel = new JLabel(" Phase: Default ");
		phaseLabel.setBorder(BorderFactory.createDashedBorder(null));
		return phaseLabel;
	}
	
	private JLabel createCardValueLabel() {
		JLabel cardValueLabel = new JLabel(" Card value: 4 ");
		cardValueLabel.setBorder(BorderFactory.createDashedBorder(null));
		return cardValueLabel;
	}
	
	private JButton createCancelButton() {
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setOpaque(true);
		cancelButton.setVisible(false);
		cancelButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		return cancelButton;
	}
	
	private JButton createEndPhaseButton() {
		JButton endPhaseButton = new JButton("End Phase");
		endPhaseButton.setForeground(Color.WHITE);
		endPhaseButton.setBackground(new Color(75 , 200, 75));
		endPhaseButton.setVisible(false);
		endPhaseButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		return endPhaseButton;
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
	
	public void addCancelButtonListener(ActionListener listener) {
		this.cancelButton.addActionListener(listener);
	}
	
	public void setEndPhaseButtonVisible(boolean isVisible) {
		this.endPhaseButton.setVisible(isVisible);
	}
	
	public void addEndPhaseButtonListener(ActionListener listener) {
		this.endPhaseButton.addActionListener(listener);
	}
	
	public void setPhaseText(String phase) {
		this.phaseIndicator.setText(" Phase: " + phase + " ");
	}
	
	public void setCardValue(int value) {
		this.cardValueIndicator.setText(" Card value: " + value + " ");
	}
	
}
