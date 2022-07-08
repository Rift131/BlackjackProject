package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Deck> deck = new ArrayList<>();
	
	public Deck() {
		deckBuilder();
	}
	
	public List<Deck> deckBuilder() {
		// initialize deck with all 52 cards
		for (Suit cardSuit : Suit.values()) {
		for (Rank cardValue : Rank.values()) {
			Card card = new Card(cardSuit, cardValue);
		deck.add(card);	
		}	
		}
		return deck;
	}
	
	public int checkDeckSize(Deck deck) {
		// count how many cards are in the deck and return that amount
		return deck.size();
	}
	
	public Card dealCard() {
		// remove a card from the list
		Card card = deck.remove(0);
		return card;
	}
	
	public void shuffle() {
		// shuffle the deck
		Collections.shuffle(deck);
	}
}

