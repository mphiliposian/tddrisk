package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.game.Card;
import code.game.Card.CardType;
import code.game.Territory;

public class HandPanel extends JPanel {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		List<Card> cards = new ArrayList<>();
		for (int i=0; i<4; i++) {
			cards.add(new Card(new Territory("NA1", "Name", null, 0, 0), CardType.WILD));
		}
		frame.add(new HandPanel(cards));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static final long serialVersionUID = -1539390589602885907L;
	private List<CardComponent> cards;

	public HandPanel(List<Card> hand) {
		this.setLayout(new GridLayout(2,3));
		cards = new ArrayList<>();
		CardComponent cc;
		for (Card card : hand) {
			cc = new CardComponent(card);
			cards.add(cc);
			this.add(cc);
		}
	}
	
	private class CardComponent extends JPanel {

		private static final long serialVersionUID = 3174459576465997294L;
		private Card card;
		private JLabel typeLabel;
		private JLabel nameLabel;
		
		public CardComponent(Card card) {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.card = card;
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			String type = "";
			Color color = null;
			switch(this.card.getCardType()) {
			case Artillery:
				type = "A";
				color = Color.GRAY;
				break;
			case Calvary:
				type = "C";
				color = Color.GREEN;
				break;
			case Infantry:
				type = "I";
				color = Color.RED;
				break;
			case WILD:
				type = "W";
				color = Color.MAGENTA;
				break;
			}
			this.setBackground(color);
			typeLabel = new JLabel(type);
			typeLabel.setFont(new Font("Ariel",1,150));
			typeLabel.setAlignmentX(CENTER_ALIGNMENT);
			this.add(typeLabel);
			
			nameLabel = new JLabel(card.getTerritory().getName());
			nameLabel.setFont(new Font("Ariel",1,25));
			nameLabel.setAlignmentX(CENTER_ALIGNMENT);
			nameLabel.setAlignmentY(CENTER_ALIGNMENT);
			this.add(nameLabel);
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(200, 300);
		}
	}
}
