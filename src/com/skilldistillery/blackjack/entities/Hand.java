package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	private Deck deck = new Deck();
	List<Card> hand;

	// add cards
	public Hand() {
		super();
		hand = new ArrayList<>();
	}

	// display the hand (toString)
	public void addCard(Card card) {
		hand.add(card);
	}

	public void clear() {
		hand.removeAll(hand);
	}

	// abstract due to different player hands being dealt with
	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Card card : hand) {
		builder.append("\n\t").append(card);
		}
		return builder.toString();
	}

	public List<Card> getCards() {
		return hand;
	}

	public Card getLastCard() {
		return hand.get(hand.size() - 1);
	}

	public void setCards(List<Card> cards) {
		this.hand = cards;
	}

}
