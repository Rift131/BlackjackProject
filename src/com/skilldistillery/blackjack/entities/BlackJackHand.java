package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	public BlackJackHand() {

	}

	public int getHandValue() {
		int handValue = 0;

		for (Card card : getCards()) {
			handValue += card.getValue();
		}
		for (Card card : getCards()) {
			if (card.getValue() == 11 && handValue > 21) {
					handValue -= 10;
				}
			}
		return handValue;
		}
	
	public int getDealerHandValue() {
		int handValue = 0;

		for (Card card : getCards()) {
			handValue += card.getValue();
		}
		for (Card card : getCards()) {
			if (card.getValue() == 11 && handValue >= 17) {
					handValue -= 10;
				}
			}
		return handValue;
		}
	

	public boolean isBlackjack() {
		if (getHandValue() == 21 && getCards().size() == 2) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}

	public boolean isLessThan17() {
		if (getHandValue() < 17) {
			return true;
		}
		return false;
	}

	public int aceCheck() {

		return getHandValue();
	}

}
