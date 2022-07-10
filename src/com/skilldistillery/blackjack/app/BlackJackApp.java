package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {

	private Scanner userInput = new Scanner(System.in);
	private Deck deck = new Deck();
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private BlackJackHand rules = new BlackJackHand();
	private Card card = new Card(null, null);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public void run() {
		System.out.println("Welcome to Sopwith Blackjack!\nWould you like to play?");
		System.out.println("********************************");
		System.out.println("*                 _____|_____  *");
		System.out.println("*                  __I_@_I__   *");
		System.out.println("*                     d b      *");
		System.out.println("* 1. Enter 1 to play           *");
		System.out.println("* 2. Enter 2 to quit           *");
		System.out.println("*    _____|_____               *");
		System.out.println("*     __I_@_I__                *");
		System.out.println("*        d b                   *");
		System.out.println("********************************");
		int userMenuSelection;
		boolean validUserInput = false;
		try {
			userMenuSelection = userInput.nextInt();
			userInput.nextLine();
			while (!validUserInput) {

				validUserInput = true;

				switch (userMenuSelection) {
				case 1:
					gameSetup();
					break;
				case 2:
					quit();
					break;

				default:
					System.out.println("The number entered did not match the menu choices. Please try again.");
					run();
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input.");
			userInput.nextLine();
			validUserInput = false;
			run();
		}
	}

// play -> get a deck and shuffle it
	public void gameSetup() {
		this.deck.deckBuilder();
		this.deck.shuffle();
		this.dealInitialHand();
	}

	public void dealInitialHand() {
		for (int i = 0; i < 2; i++) {
			this.player.getHand().addCard(card);
			this.dealer.getHand().addCard(card);
		}
		playersTurn();
	}

	public void playersTurn() {
// sysout current score of player and current status of dealer
		// access the dealers second card
		if (player.getHand().isBlackjack() && !dealer.getHand().isBlackjack()) {
			System.out.println("BLACKJACK!! YOU WIN!");
			// invoke a method that resets the hands and asks if the player wants to play
			// again
			handsReset();
		} else if (!player.getHand().isBlackjack() && dealer.getHand().isBlackjack()) {
			System.out.println("BLACKJACK!! DEALER WINS!");
			// invoke a method that resets the hands and asks if the player wants to play
			// again
			handsReset();
		} else if (player.getHand().isBlackjack() && dealer.getHand().isBlackjack()) {
			System.out.println("Tie Blackjacks! Nothing lost, nothing gained.");
			handsReset();
		} else if (player.getHand().isBust()) {
			System.out.println("You have " + player.getHand().toString() + "." + "\nTotal points: " + player.getHand().getHandValue() + ". You've BUSTED 21 points. You lose.");
			handsReset();
		}else {
			System.out.println("The dealer has " + dealer.getHand().getCards().get(1) + " showing.\nYou have " 	+ player.getHand().toString() + "." + "\nTotal points: " + player.getHand().getHandValue());
		}
// Ask player if they would like to be dealt another card or hold
		System.out.println("Would you like to Hit or Stay?");
		playersChoice();
	}

	public void playersChoice() {
		System.out.println("**********************");
		System.out.println("*     _____|_____    *");
		System.out.println("*      __I_@_I__     *");
		System.out.println("*         d b        *");
		System.out.println("* 1. Enter 1 to Hit  *");
		System.out.println("* 2. Enter 2 to Stay *");
		System.out.println("* 3. Enter 3 to Quit *");
		System.out.println("**********************");
		int userMenuSelection;
		boolean validUserInput = false;
		try {
			userMenuSelection = userInput.nextInt();
			userInput.nextLine();
			while (!validUserInput) {

				validUserInput = true;

				switch (userMenuSelection) {
				case 1:
					hit();
					break;
				case 2:
					stand();
					break;
				case 3:
					quit();
					break;
				default:
					System.out.println("The number entered did not match the menu choices. Please try again.");
					playersChoice();
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input.");
			userInput.nextLine();
			validUserInput = false;
			playersChoice();
		}
	}

	public void hit() {
		// put a card into the player hand
		this.player.getHand().addCard(deck.dealCard());
		playersTurn();
		}

	public void stand() {
		// if hold, reveal dealers first card and add cards until logic of 17 or more is
		// met
		System.out.println("The dealer reveals their card. They now have " + dealer.getHand().getCards());
		
		while(dealer.getHand().isLessThan17()) {
			this.dealer.getHand().addCard(deck.dealCard());

			//System.out.println("The dealer draws a " + 
		}
		
	}

	public void winnerDeclaration() {

		// evaluate the winner and sysout

	}

	public void handsReset() {
		// clear hands and present menu to use
		player.getHand().clear();
		dealer.getHand().clear();
		run();

	}

	public void quit() {
		System.out.println("----|------------|-----------|----\n" + "    |        --/ - \\--       |\n"
				+ "   -|---------|  o  |--------|-\n" + "              /\\ _ /\\\n" + "           []/       \\[]");
		System.out.println("Thank you for playing Sopwith Blackjack! This program will now close.");
		userInput.close();
		System.exit(0);
	}
}
