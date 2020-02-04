import java.util.ArrayList;

public class WarGame {


    public void play(int playerNum) {
        int winner = 0;

        Deck d = new Deck();
        d.addCards();
        d.shuffle();

        Card highest = new Card();
        int losers = 0;

        ArrayList <ArrayList <Card> > players_decks = new ArrayList<ArrayList<Card>>();
        ArrayList <Card> cardsInPlay = new ArrayList<>();

        int per = 52 / playerNum; // hand 26
        ArrayList<Card> pDeck = new ArrayList();

        for (int i = 0; i < playerNum; i++) {
            pDeck = d.deal(per);
            players_decks.add(i, pDeck);
        }

        while (losers != playerNum - 1) {

            for (int j = 0; j < playerNum; j++) {

                ArrayList<Card> player = players_decks.get(j);
                if (player.size() == 0) {
                    Card p_card = new Card();
                    cardsInPlay.add(p_card);
                }
                else {
                    Card p_card = player.remove(0);
                    cardsInPlay.add(p_card);
                    System.out.println("Player " + (j + 1) + "'s " + p_card.toString());
                }
            }

            int counter = 0;
            for (int i = 0; i < cardsInPlay.size(); i++) {
                //System.out.println(cardsInPlay.get(i).toString());
                // assume first card played is current highest
                highest = cardsInPlay.get(i);
                System.out.println("highest" + highest.toString());

                if (cardsInPlay.get(i).compareTo(highest) > 1) {
                    // if next card is higher than current, mark the next card as the highest
                    highest = cardsInPlay.get(i);
                    System.out.println("HELLO" + highest.toString() + "hi");
                }

            }

            for (int i = 0; i < cardsInPlay.size(); i++) {
                if ((cardsInPlay.get(i).equalsTo(highest))){
                    counter ++;
                }
            }
            if (counter > 2) {

                ArrayList <Card> war = new ArrayList<>();

                for (int k = 0; k < 4; k++) {

                    for (int j = 0; j < playerNum; j++) {

                        ArrayList<Card> player = players_decks.get(j);

                        if (player.size() == 0) {
                            Card c = new Card();
                            war.add(c);
                        }
                        else {
                            Card c = player.remove(0);
                            war.add(c);
                            System.out.println("War card for Player " + (j + 1) + "is xx");
                            //System.out.println("Player " + (j+1) + "'s " + c1.toString());
                        }
                    }
                }

                ArrayList <Card> round = new ArrayList<>();
                winner = war_start(playerNum, war, round);

                //ArrayList<Card> winner_add = players_decks.get(winner);
                //winner_add.addAll(cardsInPlay);
                players_decks.add(winner, war);
                winner = 0;
            }
            else {
                for (int p = 0; p < cardsInPlay.size(); p++) {
                    if (cardsInPlay.get(p).equalsTo(highest)) {
                        winner = p;
                    }
                }
                players_decks.add(winner,cardsInPlay);
                System.out.println("Player " + (winner+1) + " has won this round.");
                winner = 0;
            }

            for (int l = 0; l < playerNum; l++) {
                ArrayList loser = players_decks.get(playerNum);
                if (loser.size() == 0) {
                    losers ++;
                    System.out.println("Player " + playerNum+ "has ran out of cards and lost.");
                }
            }
        }
    }

    public int war_start(int playerNum, ArrayList <Card> war, ArrayList<Card> round){

        int winner = 0;
        Card high = new Card();

        for (int g = 0; g+3 < war.size(); g++) {
            Card war1 = war.remove(g);
            round.add(war1);
            System.out.println("War card for Player " + (g + 1) + "'s " + war1.toString());
        }
        int counter = 0;
        for (int i = 0; i < round.size(); i++){
            // assume first card played is current highest
            if (i != 0) {
                if (round.get(i).compareTo(high) > 1) {
                    // if next card is higher than current, mark the next card as the highest
                    high = round.get(i);
                }
            }
        }

        for (int i = 0; i < round.size(); i++) {
            if ((round.get(i).equalsTo(high))){
                // initiate war
                counter ++;
            }
        }

        if (counter > 2) {
            winner = war_start(playerNum, war, round);

            for (int p = 0; p < round.size(); p++) {
                if (round.get(p).equalsTo(high)) {
                    winner = p;
                }
            }

        }
        return winner;

    }

    public void gameOver(){


    }

    public String toString() {
        return "";

    }


}
