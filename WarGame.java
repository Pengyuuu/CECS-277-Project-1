/**
 * Name: Erina Lara, Eric Truong
 * Date: February 3rd, 2020
 * Purpose: The program has two players play the card game war. To win a round, a player must have a card of higher value.
 * If both players have a card of equal value, they engage in war where they draw three facedown cards and one face up card.
 * The war ends once someone has a card of higher value. The game itself does not end until one person runs out of cards.
*/
import java.util.ArrayList;

public class WarGame {

    /**
     * Runs the game
     * @param playerNum number of people participating
     */
    public void play(int playerNum) {

        // creates a new deck of cards and shuffles it
        Deck d = new Deck();
        d.addCards();
        d.shuffle();

        // creates a list of each player's deck
        ArrayList <ArrayList> players_decks = new ArrayList<>();

        // creates a list of cards currently in play
        ArrayList <Card> cardsInPlay = new ArrayList<>();

        // gives players their decks
        ArrayList <Card> playerOne = d.deal(playerNum);
        players_decks.add(playerOne);
        ArrayList <Card> playerTwo = d.deal(playerNum);
        players_decks.add(playerTwo);

        // flag to tell the game to stop or keep going
        boolean gameOn = true;

        // flag to indicate who wins a war
        int warVictor;

        // the actual game
        while (gameOn){

            // both players play the top card from their deck
            for (int j = 0; j < playerNum; j++) {
                ArrayList <Card> player = players_decks.get(j);
                Card p_card = player.remove(0);
                cardsInPlay.add(p_card);
                System.out.println("Player " + (j+1) + "'s " + p_card.toString());
            }

            // if the cards are equal, they engage in war
            if (cardsInPlay.get(0).equals(cardsInPlay.get(1))){

                warVictor = initiateWar(players_decks, cardsInPlay);


                // if player one wins, they get all ten cards
                if (warVictor == 1){

                    for (int i = 0; i < 2; i++){

                        ArrayList <Card> player = players_decks.get(0);

                        while (!cardsInPlay.isEmpty()){

                            player.add(cardsInPlay.remove(0));
                        }
                    }
                }
                // if player two wins, they get all ten cards
                else if (warVictor == 2){

                    for (int i = 0; i < 2; i++){

                        ArrayList <Card> player = players_decks.get(1);

                        while (!cardsInPlay.isEmpty()){

                            player.add(cardsInPlay.remove(0));
                        }
                    }
                }
            }

            // if player one has a higher value card, they get both cards
            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) > 0){

                for(int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 1 wins the round");
            }

            // if player two has a higher value card, they get both cards
            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) < 0){

                for (int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(1);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 2 wins the round");
            }

            // check if either player has ran out of cards
            gameOn = gameOver(players_decks.get(0), players_decks.get(1));
        }
    }

    /**
     * Runs the war section
     * @param players_decks both player's decks
     * @param cardsInPlay   cards currently in play
     * @return              the winner of the war
     */
    public int initiateWar(ArrayList<ArrayList> players_decks, ArrayList <Card> cardsInPlay){

        // each person draws three cards facedown
        boolean war = true;

        // flags to indicate a winner
        int pOneWin = 1;
        int pTwoWin = 2;

        // counter to make sure 4 cards are played from each player
        int warOn = 0;

        // deals the 4 cards
        while (warOn < 4){
            ArrayList <Card> playerOne = players_decks.get(0);
            ArrayList <Card> playerTwo = players_decks.get(1);

            // the fourth card is played face up
            if (warOn == 3) {
                Card playCard = playerOne.remove(0);
                System.out.println("Player 1's " + playCard);
                cardsInPlay.add(playCard);
                playCard= playerTwo.remove(0);
                System.out.println("Player 2's " + playCard);
                cardsInPlay.add(playCard);

            }

            // cards 1 to 3 are played face down
            else {

                // remove the cards from their decks and play them
                Card playCard = playerOne.remove(0);

                cardsInPlay.add(playCard);

                playCard = playerTwo.remove(0);

                cardsInPlay.add(playCard);

                // if player one is unable to supply four cards, they lose
                if (playerOne.isEmpty()){

                    System.out.println("Player 1 ran out of cards");

                    gameOver(playerOne, playerTwo);

                    warOn = 4;
                    war = false;
                }

                // if player two is unable to supply four cards, they lose
                else if (playerTwo.isEmpty()){

                    System.out.println("Player 2 ran out of cards");

                    gameOver(playerOne, playerTwo);

                    warOn = 4;
                    war = false;
                }

                else {

                    System.out.println("Player 1's Card is xx");
                    System.out.println("Player 2's Card is xx");
                }
            }

            warOn++;
        }

        // war begins
        int topCard = 9;
        while (war){

            // if the face up cards are equal, move on to the next round of war
            while ((cardsInPlay.get(topCard).compareTo(cardsInPlay.get(topCard - 1))) == 0){

                topCard = topCard - 2;
                System.out.println(topCard);
                System.out.println("Player 1's " + cardsInPlay.get(topCard - 1));
                System.out.println("Player 2's " + cardsInPlay.get(topCard));

                // if player one has a higher value card, they win all ten cards
                if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) > 0){

                    while (!cardsInPlay.isEmpty()){

                        ArrayList <Card> player = players_decks.get(0);
                        Card p_card = cardsInPlay.remove(0);
                        player.add(p_card);
                    }

                    System.out.println("Player 1 wins the war round");
                    war = false;
                    return pOneWin;
                }

                // if player two has a higher value card, they win all ten cards
                else if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) < 0){

                    while (!cardsInPlay.isEmpty()){

                        ArrayList <Card> player = players_decks.get(1);
                        Card p_card = cardsInPlay.remove(0);
                        player.add(p_card);
                    }

                    System.out.println("Player 2 wins the war round");
                    war = false;
                    return pTwoWin;
                }
            }

            // if player one has a higher value card, they will all ten cards
            if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) > 0){

                while (!cardsInPlay.isEmpty()){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 1 wins the war round");
                war = false;
                return pOneWin;
            }

            // if player two has a higher value card, they win all ten cards
            else if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) < 0){

                while (!cardsInPlay.isEmpty()){

                    ArrayList <Card> player = players_decks.get(1);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 2 wins the war round");
                war = false;
                return pTwoWin;
            }

            topCard--;
        }

        return 0;
    }

    /**
     * Checks if any player has run out of cards
     * @param playerOne player's deck
     * @param playerTwo player's deck
     * @return          true to continue the game, false if someone ran out of cards
     */
    public boolean gameOver(ArrayList<Card> playerOne, ArrayList<Card> playerTwo){

        if (playerOne.isEmpty()){

            System.out.println("Player two wins!");
            System.out.println(playerOne.size());
            return false;
        }
        else if (playerTwo.isEmpty()){

            System.out.println("Player one wins!");
            System.out.println(playerTwo.size());
            return false;
        }

        return true;
    }

    @Override
    public String toString() {

        return "";
    }
}



