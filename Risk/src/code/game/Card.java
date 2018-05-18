package code.game;

public class Card {
	
	public static enum CardType {
		Infantry,
		Calvary,
		Artillery,
		WILD
	}
	
	private Territory territory;
	private CardType cardType;

	public Card(Territory territory, CardType cardType) {
		this.territory = territory;
		this.cardType = cardType;
	}
	
	public Territory getTerritory() {
		return this.territory;
	}
	
	public CardType getCardType() {
		return this.cardType;
	}

}
