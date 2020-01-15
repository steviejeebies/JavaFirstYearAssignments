// Dice game, Chuck-A-Luck

import java.util.Scanner;

public class ChuckALuck {

    public static double TRIPLE_ODDS = 30;

    public static void main(String[] args) {
        boolean finished = false;
        boolean correctWalletInput = false;
        Wallet userWallet = new Wallet();
        double initialWallet = 0;

        while (!correctWalletInput)
        {
            try
            {
                System.out.println("How much cash is in your wallet?");
                Scanner userInput = new Scanner(System.in);
                initialWallet = userInput.nextDouble();
                if(initialWallet > 0.0)
                    userWallet.put(initialWallet);
                else throw new java.util.InputMismatchException();
                correctWalletInput = true;
            }
            catch (java.util.InputMismatchException e)
            {
                System.out.println("Invalid input.");
            }
        }

        while (!finished)
        {
            System.out.println("What kind of bet would you like to make? "
                    + "[Type 'Triple', 'Field', 'High', or 'Low', or type 'quit']");
            Scanner userBetType = new Scanner(System.in);
            String betType = userBetType.next();

            switch(betType.toLowerCase()) {
                case "high":
                case "low":
                case "triple":
                case "field":
                    resolveBet(betType, userWallet);
                    if(userWallet.check() == 0.0) finished = true;
                    break;
                case "quit":
                    finished = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

        double endResult = initialWallet - userWallet.check();

        System.out.println("You started out with $" + initialWallet + " and now you have $" + userWallet.check() +
                ((endResult>0) ? ". You lost $" + (endResult) : ". You won $" + (-endResult)) + ". Goodbye!");

    }

    public static void resolveBet(String betType, Wallet userWallet) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        int dice1Result = 0;
        int dice2Result = 0;
        int dice3Result = 0;
        int diceTotal = 0;
        double betValue = 0;
        boolean isTriple = false;
        boolean finished = false;
        betType = betType.toLowerCase();

        while (!finished)
        {
            System.out.println("You have $" + userWallet.check() + " left, how much would you like to bet?");
            Scanner betValueInput = new Scanner(System.in);
            try
            {
                betValue = betValueInput.nextDouble();
                if (userWallet.get(betValue))
                {
                    dice1Result = dice1.roll();
                    dice2Result = dice2.roll();
                    dice3Result = dice3.roll();
                    diceTotal = dice1Result + dice2Result + dice3Result;
                    finished = true;
                }
                else
                    System.out.println("Not enough cash.");
            }
            catch (java.util.InputMismatchException e)
            {
                System.out.println("Invalid input.");
            }
        }

        System.out.println("The dice rolled: " + dice1Result + ", " + dice2Result + ", " + dice3Result);

        if (dice1Result == dice2Result && dice1Result == dice3Result)
            isTriple = true;

        if(betType.equals("triple") && isTriple && dice1Result != 1 && dice1Result != 6)
            userWallet.put(betValue + betValue * TRIPLE_ODDS);
        else if(betType.equals("field") && (diceTotal < 8 || diceTotal > 12))
            userWallet.put(betValue * 2);
        else if (betType.equals("high") && diceTotal > 10 && !isTriple)
            userWallet.put(betValue * 2);
        else if (betType.equals("low") && diceTotal < 11 && !isTriple)
            userWallet.put(betValue * 2);
        else {
            System.out.println("You lose, you now have $" + userWallet.check());
            return;
        }

        System.out.println("You won $" + betValue + "! You now have $" + userWallet.check());
        return;

    }

}
