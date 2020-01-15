import java.util.Scanner;
import java.util.Random;

public class HighLowCardGame {

    public final static int HIGHEST_CARD_VALUE = 13;
    public final static int LOWEST_CARD_VALUE = 2;
    public final static int CORRECT_GUESSES_TO_WIN = 4;

    public static void main(String[] args) {

        int correctStreak = 0;
        int currentCard = 0;
        int nextCard = 0;
        boolean isFinished = false;

        System.out.println(
                "In this High-Low Card Game, you must guess" + " if the next card is Higher, Lower, or Equal \nto your"
                        + " current card. Simply type \"higher\", \"lower\", or"
                        + " \"equal\" and hit enter \nto make your guess, or enter \"quit\""
                        + " to finish the game. If you get 4 correct \nguesses in a row, you win!"
                        + " Remember, Aces are high!");

        Random cardGenerator = new Random();
        currentCard = cardGenerator.nextInt(HIGHEST_CARD_VALUE) + LOWEST_CARD_VALUE;

        do {
            System.out.println("The current card is " + getCardName(currentCard));
            nextCard = cardGenerator.nextInt(HIGHEST_CARD_VALUE) + LOWEST_CARD_VALUE;

            System.out.println("Do you think the next card will be higher, lower or equal?");
            Scanner userInput = new Scanner(System.in);
            String nextString = userInput.next();

            if (nextString.equalsIgnoreCase("higher") && nextCard > currentCard)
                correctStreak++;
            else if (nextString.equalsIgnoreCase("lower") && nextCard < currentCard)
                correctStreak++;
            else if (nextString.equalsIgnoreCase("equal") && nextCard == currentCard)
                correctStreak++;
            else if ((nextString.equalsIgnoreCase("higher")
                    || nextString.equalsIgnoreCase("lower")
                    || nextString.equalsIgnoreCase("equal")))
            {
                System.out.println("You lose, it was " + getCardName(nextCard) + ", try again! (or enter \"quit\" to end the game)");
                correctStreak = 0;
            }
            else if (nextString.equalsIgnoreCase("quit")) {
                isFinished = true;
                userInput.close();
            }
            else
                System.out.println("Invalid input, try again.");

            currentCard = nextCard;

        } while (!isFinished && correctStreak < CORRECT_GUESSES_TO_WIN);

        System.out.println((correctStreak == 4) ? "Congratulations. You got them all correct." : "Goodbye!");

    }

    static String getCardName(int cardNumber) {
        switch (cardNumber) {
            case 11:
                return "a Jack";
            case 12:
                return "a Queen";
            case 13:
                return "a King";
            case 14:
                return "an Ace.";
            default:
                return "a " + cardNumber;
        }
    }

}
