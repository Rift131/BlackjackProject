package com.skilldistillery.blackjack.entities;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class DealerHand extends Hand {
// collection for the cards dealt <key value>
protected Map<Integer, Card> dealerHand = new TreeMap<>();
	// reveal only the second card dealt and its value

	// reveal both cards dealt and their value

	// determine draw or stay

	public DealerHand() {

	}

	
	public void drawACard(int cardDealt, Card fromDealer) {
		// TODO Auto-generated method stub
		dealerHand.put(cardDealt, fromDealer);
	}
	
	public Card dealersFaceUpCard() {
		Card faceUpCard = dealerHand.get(2);
		return faceUpCard;
	}

	public Map<Integer, Card> getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Map<Integer, Card> dealerHand) {
		this.dealerHand = dealerHand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dealerHand);
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
		DealerHand other = (DealerHand) obj;
		return Objects.equals(dealerHand, other.dealerHand);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DealerHand [dealerHand=").append(dealerHand).append("]");
		return builder.toString();
	}


	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
