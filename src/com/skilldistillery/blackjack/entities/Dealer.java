package com.skilldistillery.blackjack.entities;


public class Dealer extends Player {
// dealer does all of the talking
	

	public Dealer() {

	}	
	
	@Override
	public void displayHand() {
		System.out.println("Dealers hand: " + hand.toString() + " for a total point value of " + hand.getHandValue());
	}
	
}