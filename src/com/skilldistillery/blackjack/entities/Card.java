package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public class Card {
	private Suit cardSuit;
	private Rank cardRank;
	

	public Card(Suit cardSuit, Rank cardValue) {
		this.cardSuit = cardSuit;
		this.cardRank = cardValue;
	}
	
	

	public int getValue() {
		return cardRank.getValue();
	}

	public Suit getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(Suit cardSuit) {
		this.cardSuit = cardSuit;
	}

	public Rank getCardRank() {
		return cardRank;
	}

	public void setCardRank(Rank cardRank) {
		this.cardRank = cardRank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardRank, cardSuit);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		return cardRank == other.cardRank && cardSuit == other.cardSuit;
	}

	@Override
	public String toString() {
		return  cardRank + " of " + cardSuit;
	}

}
