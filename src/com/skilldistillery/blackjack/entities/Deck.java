package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<>();
	
	public Deck() {
		
	}

	public void deckBuilder() {
		// initialize deck with all 52 cards
		for (Suit cardSuit : Suit.values()) {
			for (Rank cardValue : Rank.values()) {
				cards.add(new Card(cardSuit, cardValue));
			}
		}
		shuffle(getCards());
	}

	public List<Card> shuffle(List<Card> newDeck) {
		// shuffle the deck
		Collections.shuffle(newDeck);
		return newDeck;
	}

	public Card dealCard() {
		// remove a card from the list
		return cards.remove(0);
	}
	
	public void dealCard(Hand hand) {
		hand.addCard(dealCard());
	}

	public int checkDeckSize() {
		// count how many cards are in the deck and return that amount
		return getCards().size();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
