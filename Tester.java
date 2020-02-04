/**
 * Name: Erina Lara, Eric Truong
 * Date: February 3rd, 2020
 * Purpose: The program has two players play the card game war. To win a round, a player must have a card of higher value.
 * If both players have a card of equal value, they engage in war where they draw three facedown cards and one face up card.
 * The war ends once someone has a card of higher value. The game itself does not end until one person runs out of cards.
*/

public class Tester {

    public static void main (String[] args){

        int playerNum = 2;
        WarGame war = new WarGame();
        war.play(playerNum);


    }
}
