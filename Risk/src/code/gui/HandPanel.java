package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.game.Card;

public class HandPanel extends JPanel {
	
	private static final long serialVersionUID = -1539390589602885907L;
	private Map<Card, CardComponent> cards;

	public HandPanel(List<Card> hand) {
		this.setLayout(new GridLayout(3,4));
		cards = new HashMap<>();
		CardComponent cc;
		for (Card card : hand) {
			cc = new CardComponent(card);
			cards.put(card, cc);
			this.add(cc);
		}
		for (int i=0; i<12 - hand.size(); i++) {
			this.add(new CardComponent(null));
		}
	}
	
	public void setSelected(boolean selected, Card card) {
		cards.get(card).setSelected(selected);
	}

	public void addCardListener(Card card, ActionListener actionListener) {
		this.cards.get(card).addActionListener(actionListener);
	}
	
	public List<Card> getSelectedCards() {
		List<Card> selectedCards = new ArrayList<>();
		for (Card c : this.cards.keySet()) {
			if (this.cards.get(c).isSelected()) {
				selectedCards.add(c);
			}
		}
		
		return selectedCards;
	}
	
	private class CardComponent extends JButton {

		private static final long serialVersionUID = 3174459576465997294L;
		private Card card;
		private boolean isSelected;
		private JLabel typeLabel;
		private JLabel nameLabel;
		
		public CardComponent(Card card) {
			this.card = card;
			this.isSelected = false;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
			this.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					toggleSelected();
				}
				
			});
		}
		
		public boolean isSelected() {
			return this.isSelected;
		}
		
		public void toggleSelected() {
			this.isSelected = !this.isSelected;
			if (this.isSelected) {
				this.setBackground(Color.YELLOW);
			} else {
				this.setBackground(Color.GRAY);
			}
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(175, 250);
		}
	}
}
