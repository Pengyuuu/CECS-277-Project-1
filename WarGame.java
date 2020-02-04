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

            if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) == 0){

                System.out.println(cardsInPlay.get(0).compareTo(cardsInPlay.get(1)));
                initiateWar(2, players_decks, cardsInPlay);
            }

            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) > 0){

                System.out.println("Player 1 " + cardsInPlay.get(0).compareTo(cardsInPlay.get(1)));

                for(int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 1 wins the round");
            }

            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) < 0){

                System.out.println("Player 2 " + cardsInPlay.get(0).compareTo(cardsInPlay.get(1)));

                for (int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(1);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 2 wins the round");
            }

            gameOn = gameOver(players_decks.get(0), players_decks.get(1));
        }
    }

    public void initiateWar(int playerNum, ArrayList<ArrayList> players_decks, ArrayList <Card> cardsInPlay){

        // each person draws three cards facedown

        int warOn = 0;

        while (warOn < 4){
            ArrayList <Card> playerOne = players_decks.get(0);
            ArrayList <Card> playerTwo = players_decks.get(1);

            if (warOn == 3) {
                Card playCard = playerOne.remove(0);
                System.out.println("Player 1's " + playCard);
                cardsInPlay.add(playCard);
                playCard= playerTwo.remove(0);
                System.out.println("Player 2's " + playCard);
                cardsInPlay.add(playCard);

            }

            else {

                Card playCard = playerOne.remove(0);

                cardsInPlay.add(playCard);

                playCard = playerTwo.remove(0);

                cardsInPlay.add(playCard);

                if (playerOne.isEmpty()){

                    System.out.println("Player 1 ran out of cards");

                    gameOver(playerOne, playerTwo);

                    warOn = 4;
                }
                else if (playerTwo.isEmpty()){

                    System.out.println("Player 2 ran out of cards");

                    gameOver(playerOne, playerTwo);

                    warOn = 4;
                }

                else {

                    System.out.println("Player 1's Card is xx");
                    System.out.println("Player 2's Card is xx");
                }
            }

            warOn++;
        }

        boolean war = true;
        int topCard = 7;
        while (war){

            if (cardsInPlay.get(topCard).compareTo(cardsInPlay.get(topCard - 1)) > 0){

                for(int j = topCard; j > -1; j--){

                    ArrayList <Card> player = players_decks.get(1);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 2 wins the war round");
                war = false;
            }

            else if (cardsInPlay.get(topCard).compareTo(cardsInPlay.get(topCard - 1)) < 0){

                for (int j = topCard; j > -1; j--){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 1 wins the war round");
                war = false;
            }

            topCard--;
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



