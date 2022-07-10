package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	// remove cards
	private List<Card> cards;
	// add cards
	public Hand () {
		super();
		cards = new ArrayList<>();
	}
	// display the hand (toString)
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.removeAll(cards);
	}
	// abstract due to different player hands being dealt with
	public abstract int getHandValue();
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [cards=").append(cards).append("]");
		return builder.toString();
	}
	
	public List<Card> getCards() {
		return cards;
	}
	public int getLastCard() {
		return cards.size()-1;
	}
	
	
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
