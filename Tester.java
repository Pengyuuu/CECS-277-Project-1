/**
 * Name: Erina Lara, Eric Truong
 * Date: February 3rd, 2020
 * Purpose: The program has two players play the card game war. To win a round, a player must have a card of higher value.
 * If both players have a card of equal value, they engage in war where they draw three facedown cards and one face up card.
 * The war ends once someone has a card of higher value. The game itself does not end until one person runs out of cards.
 * Input: User's chosen number of players (2)
 */

public class Tester {

    public static void main (String[] args){

        // inputs number of players as 2
        int playerNum = 2;
        // constructs a new war game
        WarGame war = new WarGame();
        // runs war game (game outputs/prints winner)
        war.play(playerNum);

    }
}
