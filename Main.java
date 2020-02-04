import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args){

        int playerNum = 2;

        /**
        int remainder = 0;

        if (52 % playerNum > 0){

            remainder = 52 % playerNum;
        }

         */

        WarGame war = new WarGame();
        war.play(playerNum);


    }

    /**
    public static int getPlayers(){

        Scanner scan = new Scanner(System.in);

        System.out.print("How many players? (min: 2, max: 10): ");

        int playerNum = scan.nextInt();

        while (playerNum < 2 || playerNum > 10) {

            System.out.print("How many players? (min: 2, max: 10): ");
            playerNum = scan.nextInt();
        }
        return playerNum;
    }
     */
}
