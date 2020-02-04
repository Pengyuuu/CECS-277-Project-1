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

        boolean gameOn = true;

        int warVictor = 0;

        while (gameOn){
            for (int j = 0; j < playerNum; j++) {
                ArrayList <Card> player = players_decks.get(j);
                Card p_card = player.remove(0);
                cardsInPlay.add(p_card);
                System.out.println("Player " + (j+1) + "'s " + p_card.toString());
            }

            if (cardsInPlay.get(0).equals(cardsInPlay.get(1))){

                warVictor = initiateWar(players_decks, cardsInPlay);


                if (warVictor == 1){

                    for (int i = 0; i < 2; i++){

                        ArrayList <Card> player = players_decks.get(0);

                        while (!cardsInPlay.isEmpty()){

                            player.add(cardsInPlay.remove(0));
                        }
                    }
                }
                else if (warVictor == 2){

                    for (int i = 0; i < 2; i++){

                        ArrayList <Card> player = players_decks.get(1);

                        while (!cardsInPlay.isEmpty()){

                            player.add(cardsInPlay.remove(0));
                        }
                    }
                }
            }

            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) > 0){

                for(int i = 0; i < 2; i++){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 1 wins the round");
            }

            else if (cardsInPlay.get(0).compareTo(cardsInPlay.get(1)) < 0){

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

    public int initiateWar(ArrayList<ArrayList> players_decks, ArrayList <Card> cardsInPlay){

        // each person draws three cards facedown
        boolean war = true;

        int pOneWin = 1;
        int pTwoWin = 2;

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
                    war = false;
                }
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

        int topCard = 9;
        while (war){

            while ((cardsInPlay.get(topCard).compareTo(cardsInPlay.get(topCard - 1))) == 0){

                topCard = topCard - 2;
                System.out.println(topCard);
                System.out.println("Player 1's " + cardsInPlay.get(topCard - 1));
                System.out.println("Player 2's " + cardsInPlay.get(topCard));

                if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) > 0){

                    for(int j = topCard; j > -1; j--){

                        ArrayList <Card> player = players_decks.get(1);
                        Card p_card = cardsInPlay.remove(0);
                        player.add(p_card);
                    }

                    System.out.println("Player 1 wins the war round");
                    war = false;
                    return pTwoWin;
                }

                else if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) < 0){

                    for (int j = topCard; j > -1; j--){

                        ArrayList <Card> player = players_decks.get(0);
                        Card p_card = cardsInPlay.remove(0);
                        player.add(p_card);
                    }

                    System.out.println("Player 2 wins the war round");
                    war = false;
                    return pOneWin;
                }
            }

            if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) > 0){

                for(int j = topCard; j > -1; j--){

                    ArrayList <Card> player = players_decks.get(1);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 1 wins the war round");
                war = false;
                return pTwoWin;
            }

            else if (cardsInPlay.get(topCard - 1).compareTo(cardsInPlay.get(topCard)) < 0){

                for (int j = topCard; j > -1; j--){

                    ArrayList <Card> player = players_decks.get(0);
                    Card p_card = cardsInPlay.remove(0);
                    player.add(p_card);
                }

                System.out.println("Player 2 wins the war round");
                war = false;
                return pOneWin;
            }

            topCard--;
        }

        return 0;
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



