package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck;

	public Deck() {
		deck = deckBuilder();
	}

	public List<Card> deckBuilder() {
		// initialize deck with all 52 cards
		deck = new ArrayList<>();
		for (Suit cardSuit : Suit.values()) {
			for (Rank cardValue : Rank.values()) {
				deck.add(new Card(cardSuit, cardValue));
			}
		}
		return deck;
	}


	public Card dealCard() {
		// remove a card from the list
		return deck.remove(0);
	}
	public void dealCard(Hand hand) {
		
	}

	public void shuffle() {
		// shuffle the deck
		Collections.shuffle(deck);
	}
	public int checkDeckSize() {
		// count how many cards are in the deck and return that amount
		return deck.size();
	}
}
