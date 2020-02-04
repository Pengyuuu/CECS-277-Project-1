/** @authors Eric Truong, Erina Lara
 *  Project 1: ArrayLists
 *  Description: Class creates a card object with a rank, card suit, and  numerical value.
 *
 */
public class Card {

    /** if a card is royal: king, queen, jack, ace */
    private String rank;
    /** card's suit: diamonds, hearts, spades, clovers */
    private String suit;
    /** numerical value of card, based on rank */
    private int value;

    /** Constructs a card with given suit and value
     * @param c_suit card's suit
     * @param c_value card's numerical total value
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

    /** Rank accessor for card
     * @return rank of implicit card
     */
    public String getRank(){
        return rank;
    }

    /** Suit accessor for card
     * @return suit of implicit card
     */
    public String getSuit(){
        return suit;
    }

    /** Value accessor for card
     * @return total numerical value of implicit card
     */
    public int getValue(){
        return value;
    }

    /** tests if both cards are equal to each other
     * @param c Card being compared tp
     * @return true or false, if equals or not
     */
    public boolean equalsTo(Card c) {
        return this.value == c.value;
    }

    /** compares two cards to the oteach other
     * @param c Card to be compared to
     * @return difference of the cards, > if larger, < if smaller
     */
    public int compareTo(Card c){

        int cardOne = this.value;
        int cardTwo = c.value;
        return cardOne - cardTwo;
    }

    /** Converts card's data to string
     * @return string of card's data
     */
    @Override
    public String toString () {
        return "Card is " + rank + " of " + suit;
    }
}
