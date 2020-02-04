/**
 * Name: Erina Lara, Eric Truong
 * Date: February 3rd, 2020
 * Purpose: The program has two players play the card game war. To win a round, a player must have a card of higher value.
 * If both players have a card of equal value, they engage in war where they draw three facedown cards and one face up card.
 * The war ends once someone has a card of higher value. The game itself does not end until one person runs out of cards.
 */

import java.util.ArrayList;

public class Deck {

    // creates the deck
    ArrayList <Card> deck = new ArrayList<Card>();

    /**
     * Add cards into the deck
     */
    public void addCards() {
        String card_suit = "";
        for (int i = 0; i < 4; i++) {

            for (int j = 1; j < 14; j++) {

                if (i == 0) {
                    card_suit = "Hearts";
                }
                if (i == 1) {
                    card_suit = "Diamonds";
                }
                if (i == 2) {
                    card_suit = "Clovers";
                }
                if (i == 3) {
                    card_suit = "Spades";
                }
                Card c = new Card(card_suit, j);
                deck.add(c);
            }
        }
    }

    /**
     * Shuffles the deck
     */
    public void shuffle() {

        int max = deck.size()-1;
        int min = 1;

        for (int i = 0; i < max; i++) {

            int rd = (int)(Math.random() * (max - min + 1)) + min;

            Card c_switch = deck.get(i);
            Card c_swap = deck.get(rd);

            deck.remove(deck.get(i));
            deck.add(i,c_swap);
            deck.remove(deck.get(rd));
            deck.add(rd, c_switch);
        }
    }

    /**
     * Deals cards to each player
     * @param playerNum number of players participating
     * @return          a deck of cards
     */
    public ArrayList<Card> deal(int playerNum) {

        ArrayList <Card> p_deck = new ArrayList<>(26);

        for (int j = 25; j > -1; j--) {

            Card addCard = deck.remove(j);
            p_deck.add(addCard);
        }

        return p_deck;
    }

    /** Converts deck to string format
     * @return string of deck
     */
    @Override
    public String toString () {
        return deck.toString();
    }

}
