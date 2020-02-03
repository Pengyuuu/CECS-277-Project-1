import java.util.ArrayList;

public class Game {

    private int wins;

    public void play(int playerNum) {

        Deck d = new Deck();
        d.addCards();
        d.shuffle();

        Card highest = new Card();

        ArrayList <ArrayList> players_decks = new ArrayList<>();
        ArrayList <Card> cardsInPlay = new ArrayList<>();

        for (int i = 0; i < playerNum; i++) {
            ArrayList player = d.deal(playerNum);
            players_decks.add(player);
        }

        while (//one player left or one persons deck != 0) {

            for (int j = 0; j < playerNum; j++) {

                ArrayList<Card> player = players_decks.get(j);
                if (player.size() == 0) {
                    j++;
                }

                Card p_card = player.remove(0);
                cardsInPlay.add(p_card);
                System.out.println("Player " + (j + 1) + "'s " + p_card.toString());
            }

            for (int i = 0; i < cardsInPlay.size(); i++) {

                // assume first card played is current highest
                highest = cardsInPlay.get(i);

                if (i != 0) {
                    if (cardsInPlay.get(i).compareTo(highest) > 1) {

                        // if next card is higher than current, mark the next card as the highest
                        highest = cardsInPlay.get(i);

                    } else if ((cardsInPlay.get(i).compareTo(highest) == 0) & (cardsInPlay.get(i).compareTo(highest) > 1)) {
                        // initiate war
                        war_start(playerNum, players_decks);

                    }
                }
            }
            int winner = 0;
            for (int p = 0; p < cardsInPlay.size(); p++) {
                if (cardsInPlay.get(p).equalsTo(highest) == true) {
                    winner = p;
                }
            }
            ArrayList<Card> winner_add = players_decks.get(winner);
            winner_add.addAll(cardsInPlay);

            for (int l = 0; l < playerNum; l++) {
                ArrayList loser = players_decks.get(playerNum);
                if (loser.size() == 0) {
                    System.out.println("Player " + playerNum+ "has ran out of cards and lost.");
                }
            }

        }












    }

    public void war_start(int playerNum, ArrayList <ArrayList> players_decks){

        Card high = new Card();
        ArrayList <Card> war = new ArrayList<>();

        for (int k = 0; k < 4; k++) {

            for (int j = 0; j < playerNum; j++) {
                ArrayList<Card> player = players_decks.get(j);
                Card c = player.remove(0);
                war.add(c);
                System.out.println("War card for Player " + (j + 1) + "is xx");
                //System.out.println("Player " + (j+1) + "'s " + c1.toString());
            }
        }

        ArrayList <Card> round = new ArrayList<>();

        for (int g = 0; g+3 < war.size(); g++) {
            Card war1 = war.remove(g);
            round.add(war1);
            System.out.println("War card for Player " + (g + 1) + "'s " + war1.toString());
        }

        for (int i = 0; i < round.size(); i++){
            // assume first card played is current highest
            high = war.get(i);

            if (i != 0) {
                if (war.get(i).compareTo(high) > 1) {

                    // if next card is higher than current, mark the next card as the highest
                    high = war.get(i);

                } else if ((war.get(i).compareTo(high) == 0) & (war.get(i).compareTo(high) > 1)){
                    // initiate war

                }
            }
        }



    }

    public void gameOver(){


    }

    public String toString() {
        return "";

    }


}
