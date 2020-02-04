
import java.util.ArrayList;

public class Deck {

    //private Card c;
    private ArrayList <Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public Card get(int x) {
        return deck.get(x);
    }

    public void addCard(Card x) {
        deck.add(x);
    }

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

    public ArrayList<Card> deal(int per) {
        ArrayList<Card> p_deck = new ArrayList<>();
        for (int j = 0; j < per; j++) {
            Card add = deck.remove(0);
            p_deck.add(add);
        }
        return p_deck;
    }

    public int length() {
        int count = 0;
        for (int i = 0; i < deck.size(); i++) {
            count ++;
        }
        return count;


    }

    @Override
    public String toString () {
        return "";
    }

}
