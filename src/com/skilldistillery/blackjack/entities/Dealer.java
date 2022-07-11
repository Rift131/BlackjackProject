package com.skilldistillery.blackjack.entities;


public class Dealer extends Player {

	public Dealer() {

	}	
	
	@Override
	public void displayHand() {
		System.out.println("Dealers hand: " + hand.toString() + " for a total point value of " + hand.getHandValue());
	}
	
}