package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {

	private Scanner userInput = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private BlackJackHand rules = new BlackJackHand();
	private Deck deck = new Deck();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJackApp app = new BlackJackApp();
		app.deck.deckBuilder();
		app.run();
	}

	public void run() {
		System.out.println("Welcome to Sopwith Blackjack!\nWould you like to play?");
		System.out.println("Cards remaining in deck: " + deck.checkDeckSize());
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
					dealInitialHand();
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


	public void dealInitialHand() {
		for (int i = 0; i < 2; i++) {
			this.deck.dealCard(player.getHand());
			this.deck.dealCard(dealer.getHand());
		}
		playersTurn();
	}

	public void playersTurn() {
// sysout current score of player and current status of dealer
		// access the dealers second card
		if (player.getHand().isBlackjack() && !dealer.getHand().isBlackjack()) {
			System.out.println("BLACKJACK!!");
			playerVictoryGraphic();
			// invoke a method that resets the hands and asks if the player wants to play
			// again
			handsReset();
		} else if (player.getHand().isBlackjack() && dealer.getHand().isBlackjack()) {
			System.out.println("Tie Blackjacks! Nothing lost, nothing gained.");
			handsReset();
		} else if (player.getHand().isBust()) {
			playerLossGraphic();
			System.out.println("You have " + player.getHand().toString() + "." + "\nTotal points: "
					+ player.getHand().getHandValue() + ". You've BUSTED 21 points. You lose.");
			handsReset();
		} else {
			System.out.println("The dealer has " + dealer.getHand().getCards().get(1).toString() + " showing.\nYou have "
					+ player.getHand().toString() + "." + "\nTotal points: " + player.getHand().getHandValue());
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
		this.deck.dealCard(player.getHand());
		playersTurn();
	}

	public void stand() {
		// if hold, reveal dealers first card and add cards until logic of 17 or more is
		// met
		System.out.println("The dealer reveals their card. They now have " + dealer.getHand().getCards() + " in play.");
		// logic for dealer black jack

		while (dealer.getHand().isLessThan17()) {
			this.deck.dealCard(dealer.getHand());

			System.out.println("The dealer draws a " + dealer.getHand().getLastCard() + ". The dealer score is now " + dealer.getHand().getHandValue() + ".");
		}
		winnerDeclaration();
	}

	public void winnerDeclaration() {
		// evaluate the winner and sysout
		if (dealer.getHand().isBlackjack()) {
			System.out.println("BLACKJACK!! The dealer wins!");
			System.out.println("    ____        _");
			System.out.println(" |__\\_\\_o,___/ \\   @@@    @@   @@@@");
			System.out.println("([___\\_\\______--\\'    @@@@  @@@");
			System.out.println(" |  o'");
					
			// invoke a method that resets the hands and asks if the player wants to play
			// again
			handsReset();
		} else if (dealer.getHand().isBust()) {
			System.out.println("The dealer has " + dealer.getHand().toString() + " in their hand." + "\nTotal points: "
					+ dealer.getHand().getHandValue() + ". The dealer BUSTED 21 points. You win!");
			playerVictoryGraphic();
			handsReset();
		} else if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("Your score: " + player.getHand().getHandValue());
			System.out.println("The dealers score: " + dealer.getHand().getHandValue());
			System.out.println("You WIN!");
			playerVictoryGraphic();
			handsReset();
		} else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("Your score: " + player.getHand().getHandValue());
			System.out.println("The dealers score: " + dealer.getHand().getHandValue());
			playerLossGraphic();
			System.out.println("You lose!");
			handsReset();
		} else if (player.getHand().getHandValue() == dealer.getHand().getHandValue()) {
			System.out.println("Your score: " + player.getHand().getHandValue());
			System.out.println("The dealers score: " + dealer.getHand().getHandValue());
			System.out.println("A tie! Nothing lost, nothing gained.");
			handsReset();
		}

	}

	public void handsReset() {
		// clear hands and present menu to use
		if (deck.checkDeckSize() < 26) {
			newDeck();
		}
		player.getHand().clear();
		dealer.getHand().clear();
		run();

	}
	
	public void newDeck() {
		System.out.println("*************************************************");
		System.out.println("The deck has less than half the cards remaining.\n\t\tTime for a new deck!");
		System.out.println("*************************************************");
		deck.removeDeck();
		deck.deckBuilder();
		run();
	}
	public void playerVictoryGraphic() {
		System.out.println("\n"
				+ "\n"
				+ " \\ ---------------------------\\           _         ______ |\n"
				+ "  \\                            \\        /   \\___-=O`/|O`/__|\n"
				+ "   \\    (YOU WIN!!!!)           \\_______\\          / | /    )\n"
				+ "   /                             /        `/-==__ _/__|/__=-|  -GM\n"
				+ "  /                             /         *             \\ | |\n"
				+ " /_____________________________/                        (o)\n"
				+ "\n"
				+ "------------------------------------------------------------------\n");
				
	}
	
	public void playerLossGraphic() {
		System.out.println("        _ ._  _ , _ ._\n"
				+ "        (_ ' ( `  )_  .__)\n"
				+ "      ( (  (    )   `)  ) _)\n"
				+ "     (__ (_   (_ . _) _) ,__)\n"
				+ "         `~~`\\ ' . /`~~`\n"
				+ "              ;   ;\n"
				+ "              /   \\\n"
				+ "_____________/_ __ \\_____________");
	}

	public void quit() {
		System.out.println("----|------------|-----------|----\n" + "    |        --/ - \\--       |\n"
				+ "   -|---------|  o  |--------|-\n" + "              /\\ _ /\\\n" + "           []/       \\[]");
		System.out.println("Thank you for playing Sopwith Blackjack!\nThis program will now close.");
		userInput.close();
		System.exit(0);
	}
}
