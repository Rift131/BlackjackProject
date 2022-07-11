package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<>();
	
	public Deck() {
		
	}

	public void deckBuilder() {
		for (Suit cardSuit : Suit.values()) {
			for (Rank cardValue : Rank.values()) {
				cards.add(new Card(cardSuit, cardValue));
			}
		}
		shuffle(getCards());
	}

	public List<Card> shuffle(List<Card> newDeck) {
		Collections.shuffle(newDeck);
		return newDeck;
	}

	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void dealCard(Hand hand) {
		hand.addCard(dealCard());
	}

	public int checkDeckSize() {
		return getCards().size();
	}
	
	public void removeDeck() {
		cards.removeAll(cards);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Card card : cards) {
		builder.append(card);
		}
		return builder.toString();
	}
	
}
