import java.util.Random;

/*
 * Write a program to determine simulate the toss of a coin.
 * For 10,000 tosses determine how many heads and how many
 * tails are tossed. Also indicate what the last toss was.
 */

public class CoinToss {

    public static void main(String[] args) {
        int numberOfHeads = 0;
        int numberOfTails = 0;
        boolean isHeads = false;

        for(int coinTossesRemaining = 10000; coinTossesRemaining > 0; coinTossesRemaining--)
        {
            Random generater = new Random();
            isHeads = generater.nextBoolean();

            if(isHeads)
                numberOfHeads++;
            else
                numberOfTails++;
        }

        System.out.println("After 10000 coin tosses, there were " + numberOfHeads +
                " heads, and " + numberOfTails + " tails. The last coin was "
                + ((isHeads) ? "heads." : "tails."));
    }

}
