import java.util.ArrayList;

public class WarGame {

    private int wins;

    public void play(int playerNum) {

        Deck d = new Deck();
        d.addCards();
        d.shuffle();

        Card highest = new Card("", 0);

        ArrayList <ArrayList> players_decks = new ArrayList<>();
        ArrayList <Card> cardsInPlay = new ArrayList<>();

        ArrayList <Card> playerOne = d.deal(playerNum);
        players_decks.add(playerOne);
        ArrayList <Card> playerTwo = d.deal(playerNum);
        players_decks.add(playerTwo);

        /**
        for (int i = 0; i < playerNum; i++) {
            ArrayList <Card> player = d.deal(playerNum);
            players_decks.add(player);
        }
         */

        //Card max;
        // ERIC IDK HOW TO FIX THIS 
        // how to like idk uhhh remember the players' cards and compare

        boolean gameOn = true;

        while (gameOn){
            for (int j = 0; j < playerNum; j++) {
                ArrayList <Card> player = players_decks.get(j);
                Card p_card = player.remove(0);
                cardsInPlay.add(p_card);
                System.out.println("Player " + (j+1) + "'s " + p_card.toString());
            }

            /**
            // working with 2+ players seems too difficult LOL
            for (int i = 0; i < cardsInPlay.size() - 1; i++){
                for( int j = 1; j < cardsInPlay.size() - 1; j++){

                    if ()

                }

                // assume first card played is current highest
                highest = cardsInPlay.get(i);

                if (cardsInPlay.get(i++).compareTo(highest) > 1){

                    // if next card is higher than current, mark the next card as the highest
                    highest = cardsInPlay.get(i++);
                }

                else if (cardsInPlay.get(i++).compareTo(highest) == 0){

                    // initiate war
                }
            }
             */

            if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) == 0){

                initiateWar(2, players_decks, cardsInPlay);
            }

            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) > 0){

                for(int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }
            }

            else{

                for (int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(1);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }
            }

            gameOn = gameOver(players_decks.get(0), players_decks.get(1));
        }
    }

    public void initiateWar(int playerNum, ArrayList<ArrayList> players_decks, ArrayList <Card> cardsInPlay){

        // each person draws three cards facedown

        for (int i = 0; i < 4; i++){
            ArrayList <Card> playerOne = players_decks.get(0);
            ArrayList <Card> playerTwo = players_decks.get(1);

            if (i == 3) {
                Card playCard = playerOne.remove(0);
                System.out.println("Player 1's " + playCard);
                cardsInPlay.add(playCard);
                playCard= playerTwo.remove(0);
                System.out.println("Player 2's " + playCard);
                cardsInPlay.add(playCard);

            }

            Card playCard = playerOne.remove(0);

            cardsInPlay.add(playCard);

            playCard = playerTwo.remove(0);

            cardsInPlay.add(playCard);

            System.out.println("Player 1's Card is xx");
            System.out.println("Player 2's Card is xx");
        }
    }

    public boolean gameOver(ArrayList<Card> playerOne, ArrayList<Card> playerTwo){

        if (playerOne.isEmpty()){

            System.out.println("Player two wins!");
            return false;
        }
        else if (playerTwo.isEmpty()){

            System.out.println("Player one wins!");
            return false;
        }

        return true;
    }

    @Override
    public String toString() {

        return "";
    }
}



