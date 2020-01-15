// This program is a version of Lewis Carroll's Word Links game. It requires a full dictionary .txt file titled
// "words.txt", not included.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordLinks {

    public static ArrayList<String> dictionary = new ArrayList<String>();

    public static void main(String args[]) throws IOException
    {
        readDictionary();

        System.out.println("Lewis Carroll's Word-Links Puzzle Game");

        boolean finished = false;

        while(!finished)
        {
            System.out.println("Enter a series of words, separated by commas, and "
                    + "this program will tell you if your attempt is valid:");
            try
            {
                Scanner userInput = new Scanner(System.in);
                userInput.useDelimiter("\n|\r");
                String user = userInput.next();
                String[] userWords = readWordList(user);
                if(userWords.length>=2)
                {
                    isWordChain(userWords);
                }
                else if(userWords.length==0)
                {
                    finished = true;
                    userInput.close();
                    System.out.println("Goodbye!");
                }
                else
                {
                    System.out.println("You must enter more than one word.");
                }
            }
            catch(java.util.NoSuchElementException e)
            {
                System.out.println("Invalid input.");
            }
        }

    }

    public static ArrayList<String> readDictionary() throws IOException
    {
        try
        {
            FileReader wordsFileRead = new FileReader("words.txt");
            BufferedReader wordsBufferedRead = new BufferedReader(wordsFileRead);
            String currentWord = "";
            while((currentWord = wordsBufferedRead.readLine())!=null)
            {
                dictionary.add(currentWord);
            }

            wordsBufferedRead.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return dictionary;
    }

    public static String[] readWordList(String userWords)
    {
        String[] userAttempt = new String[0];

        if(userWords.isEmpty())
            return userAttempt;

        userWords = userWords.replaceAll(" ","");	//removes all spaces from users list of words
        userAttempt = userWords.split(",");
        return userAttempt;
    }

    public static boolean isUniqueList(String[]userWords)
    {
        for(int baseCompare = 0; baseCompare<userWords.length;baseCompare++)
        {
            String baseWord = userWords[baseCompare];
            for(int compare = 0; compare<userWords.length;compare++)
            {
                if(compare!=baseCompare)
                {
                    String compareWord = userWords[compare];
                    if(baseWord.equals(compareWord))
                        return false;
                }
            }
        }

        return true;
    }

    public static String[] forceLowerCase(String[] userWords)
    {
        String[] userWordsCase = new String[userWords.length];

        for(int arrayIndex = 0; arrayIndex<userWords.length;arrayIndex++)
        {
            userWordsCase[arrayIndex] = userWords[arrayIndex].toLowerCase();
        }

        return userWordsCase;
    }

    public static boolean isEnglishWord(String[] userWords)
    {
        if(dictionary.containsAll(Arrays.asList(userWords)))
            return true;

        return false;
    }

    public static boolean isDifferentByOne(String[] userWords)
    {
        for(int baseCompare = 0; baseCompare<userWords.length-1; baseCompare++)
        {
            String baseWord = userWords[baseCompare];
            String compareWord = userWords[baseCompare+1];
            char[] baseWordArray = baseWord.toCharArray();
            char[] compareWordArray = compareWord.toCharArray();

            if(baseWord.length()!=compareWord.length())
                return false;

            int sameCharCount = 0;

            for(int charIndex = 0; charIndex<baseWord.length(); charIndex++)
            {
                if(baseWordArray[charIndex] == compareWordArray[charIndex])
                    sameCharCount++;
            }

            if(baseWord.length()!=sameCharCount+1)
                return false;
        }

        return true;
    }

    public static void isWordChain(String[] userWords)
    {
        String[] userWordsLowerCase = forceLowerCase(userWords);
        boolean allUniqueWords = isUniqueList(userWordsLowerCase);
        boolean isEnglishWord = isEnglishWord(userWordsLowerCase);
        boolean isDifferentByOne = isDifferentByOne(userWordsLowerCase);

        if(allUniqueWords&&isEnglishWord&&isDifferentByOne)
        {
            System.out.println("Congratulations, "
                    + "this is a valid word chain!");
        }
        else if(!allUniqueWords)
        {
            System.out.println("Two or more of your words are the same. "
                    + "This is not a valid word chain.");
        }
        else if(!isEnglishWord)
        {
            System.out.println("Sorry, at least one of your words is not "
                    + "an English word. This is not a valid word chain.");
        }
        else if(!isDifferentByOne)
        {
            System.out.println("Sorry, one of the words in your list is "
                    + "not different from the last by only one letter, or "
                    + "the words are of different length. "
                    + "This is not a valid word chain.");
        }
    }
}
