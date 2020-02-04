/**
 * Name: Erina Lara, Eric Truong
 * Date: February 3rd, 2020
 * Purpose: The program has two players play the card game war. To win a round, a player must have a card of higher value.
 * If both players have a card of equal value, they engage in war where they draw three facedown cards and one face up card.
 * The war ends once someone has a card of higher value. The game itself does not end until one person runs out of cards.
 *
 */

public class Card {

    /**
     *  Provides the rank of a card
     */
    private String rank;

    /**
     *  Provides the type of card
     */
    private String suit;

    /**
     *  Provides numerical value of card
     */
    private int value;

    /**
     * Creates a new card
     * @param c_suit    A card is either a diamond, spade, heart, or club
     * @param c_value   Numerical value of card
     */
    public Card(String c_suit, int c_value){
        suit = c_suit;
        value = c_value;
        if (c_value > 10) {
            if (c_value == 11) {
                rank = "Jack";
            }
            else if (c_value == 12) {
                rank = "Queen";
            }
            else if (c_value == 13) {
                rank = "King";
            }
            else if (c_value == 1) {
                rank = "Ace";
            }
        }
        else {
            rank = String.valueOf(c_value);
        }
    }

    /**
     * Returns rank of card
     * @return  card's rank
     */
    public String getRank(){
        return rank;
    }

    /**
     * Returns suit of card
     * @return  card's suit
     */
    public String getSuit(){
        return suit;
    }

    /**
     * Returns numerical value of card
     * @return  card's value
     */
    public int getValue(){
        return value;
    }

    /**
     * Checks to see if two cards are equal to each other
     * @param c second card that's being compared
     * @return  true if equal, false otherwise
     */
    public boolean equalsTo(Card c) {
        return this.value == c.value;
    }

    /**
     * Compare two cards
     * @param c second card being compared
     * @return  positive number if greater, negative if less than
     */
    public int compareTo(Card c){

        int cardOne = this.value;
        int cardTwo = c.value;
        return cardOne - cardTwo;
    }

    /**
     * Checks to see if two cards are equal to each other
     * @param o second card being compared
     * @return  true if equal, false otherwise
     */
    public boolean equals(Object o){

        if (o instanceof Card){

            Card c = (Card) o;
            return this.getValue() == c.getValue();
        }

        return false;
    }

    /**
     * Converts a card into a string format
     * @return  card in a string format
     */
    @Override
    public String toString () {
        return "Card is " + rank + " of " + suit;
    }
}
