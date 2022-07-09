package com.skilldistillery.blackjack.entities;

import java.util.*;

public class Dealer {
// dealer does all of the talking
	private Scanner userInput = new Scanner(System.in);
	private 	Deck deck = new Deck();
	private PlayerHand player = new PlayerHand();
	private DealerHand dealer = new DealerHand();

public Dealer() {
//    ___                                       ___
//    ||| |                                     | |||
//_    |||#|                _                    |#|||    _
//\_`----;| |/        .     | L   - __           \| |;----'_/
///_,----:| |      .'\\\  ,' _,) _     .          | |:----._\
//    |||#|       \#\\,' ,'      ` .  \         |#|||
//    |||_|        \ \\)'    .-     \           |_|||
//                 ~\ \\\       \       \
//                 `~\#\\\       |   |  |         ___
//     ___            \,'            |           | |||
//    ||| |                      |      |        |#|||    _
//_    |||#|                                     \| |;----'_/
//\_`----;| |                         /            | |:----._\
///_,----:| |\                    /                |#|||
//    |||#|                                      |_|||
//    |||_|                          /                        /
}
// welcome to black jack play or quit?
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
	deck.deckBuilder();
	deck.shuffle();
	dealInitialHand();
}
public void dealInitialHand() {
// initial deal loops twice..
	// put a card into the player hand

	// put a card into the dealer hand
	
}

// sysout current score of player and current status of dealer

// Ask player if they would like to be dealt another card or hold

	// if deal another card, add one to player hand, evaluate with Blackjack rules and reinvoke the sysout of current score method above if 21 is not busted

	// if hold, reveal dealers first card and add cards until logic of 17 or more is met

	// evaluate the winner and sysout

	// would the player like to play again or quit?

public void quit() {
	System.out.println("Thank you for playing Sopwith Blackjack! This program will now close.");
	userInput.close();
	System.exit(0);
}

}