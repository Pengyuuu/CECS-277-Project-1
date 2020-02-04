/**
 * Name: Erina Lara, Eric Truong
 * Date: February 3rd, 2020
 * Purpose: The program has two players play the card game war. To win a round, a player must have a card of higher value.
 * If both players have a card of equal value, they engage in war where they draw three facedown cards and one face up card.
 * The war ends once someone has a card of higher value. The game itself does not end until one person runs out of cards.
 */

import java.util.ArrayList;

public class WarGame {

    /** Number of games a player has won.
     */
    private int wins;

    /** Default constructor for a game of war
     */
    public WarGame() {
        wins = 0;
    }

    /**
     * Runs the game
     * @param playerNum number of people participating
     */
    public void play(int playerNum) {

        // creates a new deck of cards
        Deck d = new Deck();
        d.addCards(); // adds cards to deck
        d.shuffle(); // shuffles deck

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
                System.out.println("Player " + (j+1) + "'s " + p_card.toString()); // Reveals player's card
            }

            // if the cards are equal, they engage in war
            if (cardsInPlay.get(0).equals(cardsInPlay.get(1))){

                warVictor = initiateWar(players_decks, cardsInPlay); // starts war


                // if player one wins, they get all ten cards
                if (warVictor == 1){

                    for (int i = 0; i < 2; i++){

                        ArrayList <Card> player = players_decks.get(0); // gets Player 1's deck

                        while (!cardsInPlay.isEmpty()){

                            player.add(cardsInPlay.remove(0)); // adds cards played to Player 1's deck
                        }
                    }
                }
                // if player two wins, they get all ten cards
                else if (warVictor == 2){

                    for (int i = 0; i < 2; i++){

                        ArrayList <Card> player = players_decks.get(1); // gets Player 2's deck

                        while (!cardsInPlay.isEmpty()){

                            player.add(cardsInPlay.remove(0)); // adds cards played to winner's deck
                        }
                    }
                }
            }

            // if player one has a higher value card, they get both cards
            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) > 0){

                for(int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(0); // gets Player 1's deck
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card); // adds card in play to Player 1's deck
                }

                System.out.println("Player 1 wins the round"); // tells user that Player 1 won the round
            }

            // if player two has a higher value card, they get both cards
            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) < 0){

                for (int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(1); // gets Player 2's deck
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card); // adds card in play to Player 2's deck
                }

                System.out.println("Player 2 wins the round"); // tells user that Player 2 won the round
            }

            // checks if either player has ran out of cards
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
            ArrayList <Card> playerOne = players_decks.get(0); // Player 1's deck
            ArrayList <Card> playerTwo = players_decks.get(1); // Player 2's deck

            // the fourth card is played face up
            if (warOn == 3) {
                Card playCard = playerOne.remove(0);
                System.out.println("Player 1's " + playCard); // reveals Player 1's 4th card face up
                cardsInPlay.add(playCard); // adds that card to cards in play
                playCard= playerTwo.remove(0); // reveals Player 2's 4th card face up
                System.out.println("Player 2's " + playCard);
                cardsInPlay.add(playCard); // adds that card to cards in play

            }

            // cards 1 to 3 are played face down
            else {

                // remove the cards from their decks and play them
                Card playCard = playerOne.remove(0); // removes a card from Player 1's deck

                cardsInPlay.add(playCard); // adds Player 1's card to cards in play

                playCard = playerTwo.remove(0); // removes a card from Player 2's deck

                cardsInPlay.add(playCard); // adds Player 2's card to cards in play

                // if player one is unable to supply four cards, they lose
                if (playerOne.isEmpty()){
                    warOn = 4;
                    war = false;
                }

                // if player two is unable to supply four cards, they lose
                else if (playerTwo.isEmpty()){
                    warOn = 4;
                    war = false;
                }

                else {
                    System.out.println("Player 1's Card is xx"); // tells user of Player 1's face down (unknown) cards during war
                    System.out.println("Player 2's Card is xx"); // tells user of Player 2's face down (unknown) cards during war
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
                System.out.println("Player 1's " + cardsInPlay.get(topCard - 1));
                System.out.println("Player 2's " + cardsInPlay.get(topCard));

                // if player one has a higher value card, they win all ten cards
                if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) > 0){

                    while (!cardsInPlay.isEmpty()){

                        ArrayList <Card> player = players_decks.get(0);
                        Card p_card = cardsInPlay.remove(0);
                        player.add(p_card);
                    }

                    System.out.println("Player 1 wins the war round"); // tells user that Player 1 has won the round
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

                    System.out.println("Player 2 wins the war round"); // tells user that Player 2 has won the round
                    war = false;
                    return pTwoWin;
                }
            }

            // if player one has a higher value card, they will win all ten cards
            if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) > 0){

                while (!cardsInPlay.isEmpty()){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 1 wins the war round"); // tells user that Player 1 has won the round
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

                System.out.println("Player 2 wins the war round"); // tells user that Player 2 has won the round
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

        // Player 2 wins if Player 1 is out of cards
        if (playerOne.isEmpty()){
            System.out.println("Player 1 ran out of cards. "); // tells user that Player 1 loses
            System.out.println("Player 2 wins!"); // tells user that Player 2 wins
            return false;
        }
        // Player 1 wins if Player 2 is out of cards
        else if (playerTwo.isEmpty()){
            System.out.println("Player 2 ran out of cards. "); // tells user that Player 2 loses
            System.out.println("Player 1 wins!"); // tells user that Player 1 wins
            return false;
        }

        return true;
    }

    /** String format of # of wins in war game
     * @return Game wins into string
     */
    @Override
    public String toString() {
        return ("Number of wins " + wins);
    }
}
