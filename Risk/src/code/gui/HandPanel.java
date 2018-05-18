package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.game.Card;

public class HandPanel extends JPanel {
	
	private static final long serialVersionUID = -1539390589602885907L;
	private List<CardComponent> cards;

	public HandPanel(List<Card> hand) {
		this.setLayout(new GridLayout(3,4));
		cards = new ArrayList<>();
		CardComponent cc;
		for (Card card : hand) {
			cc = new CardComponent(card);
			cards.add(cc);
			this.add(cc);
		}
		for (int i=0; i<12 - hand.size(); i++) {
			this.add(new CardComponent(null));
		}
	}
	
	public void setSelected(boolean selected, Card card) {
		for (CardComponent cc : cards) {
			cc.setSelected(selected, card);
		}
	}
	
	private class CardComponent extends JButton {

		private static final long serialVersionUID = 3174459576465997294L;
		private Card card;
		private JLabel typeLabel;
		private JLabel nameLabel;
		
		public CardComponent(Card card) {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.card = card;
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			String type = "";
			if (card != null) {
				switch(this.card.getCardType()) {
				case Artillery:
					type = "A";
					break;
				case Calvary:
					type = "C";
					break;
				case Infantry:
					type = "I";
					break;
				case WILD:
					type = "W";
					break;
				}
			} else {
				type = "";
			}
				
			this.setBackground(Color.GRAY);
			typeLabel = new JLabel(type);
			typeLabel.setFont(new Font("Ariel",1,125));
			typeLabel.setAlignmentX(CENTER_ALIGNMENT);
			typeLabel.setAlignmentY(BOTTOM_ALIGNMENT);
			this.add(typeLabel);
			
			if (card != null) {
				nameLabel = new JLabel(card.getTerritory().getName());
			} else {
				nameLabel = new JLabel("");
			}
			nameLabel.setFont(new Font("Ariel",1,18));
			nameLabel.setAlignmentX(CENTER_ALIGNMENT);
			nameLabel.setAlignmentY(BOTTOM_ALIGNMENT);
			this.add(nameLabel);
		}
		
		public void setSelected(boolean selected, Card card) {
			if (this.card == card) {
				if (selected) {
					this.setBackground(Color.YELLOW);
				} else {
					this.setBackground(Color.GRAY);
				}
			}
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(175, 250);
		}

		public void addCardListener(Card card, ActionListener actionListener) {
			if (this.card == card) {
				this.addActionListener(actionListener);
			}
		}
	}

	public void addCardListener(Card card, ActionListener actionListener) {
		for (CardComponent cc : cards) {
			cc.addCardListener(card, actionListener);
		}
	}
}
