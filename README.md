# BlackJack Game

# Description
Blackjack, or Sopwith Blackjack as it's named within the program, is a biplane-themed simulation of the game Blackjack. A player, using the console. is up against the dealer. The dealer plays by standard rules, stopping their draw once they reach 17 or more points. If enough rounds are played to reduce the deck to half, the old deck is taken away and a new shuffled deck is put into play. The option for the player to continue is endless until they select the option to quit.

If the player has a Blackjack, the program will recognize it and also check if the dealer also has a Blackjack.

If an Ace will cause a players score to exceed 21, the program will reduce 10 points from the player score, effectively making the ace worth 1 point.


# Technologies Used
Java
Eclipse
Git
ZSH
# Lessons Learned
Organization is key in Object Oriented Programming (OOP). The chief challenge in building  the Blackjack program was accessing data from the correct class in order to produce the desired result. Tracing back where data originated due to extended classes like the dealer class and abstract classes (hand) in order to get the right syntax was a repeated exercise in "is a". Once everything is logically established, navigating to the classes where code needs to be adjusted or examined is easier.

Organizational structure naming conventions are also critical in keeping everything oriented correctly when writing code logically.

Enumeration is a wonderful thing. The enum class is priceless in creating a standard collection of "things" to be used over and over again in different applications.

