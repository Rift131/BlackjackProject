package com.skilldistillery.blackjack.entities;

import java.util.*;



public class Player {
protected BlackJackHand hand = new BlackJackHand();
protected int playerScore;
	public Player() {
		
	}

	public void displayHand() {
		System.out.println(hand.toString() + " for a total point value of " + hand.getHandValue());
	}

	public BlackJackHand getHand() {
		return hand;
	}

	
	
	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}
	
	public int handValue() {
		return hand.getHandValue();
	}
	
	
	
	
	

}