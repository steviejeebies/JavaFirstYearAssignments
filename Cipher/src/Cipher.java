// Creates a randomly generated Cipher, encrypts the user's string according to
// this cipher, then decrypts this result.

import java.util.Scanner;
import java.util.Random;

public class Cipher {

    public static final int CHARS_IN_CIPHER = 27;
    public static final int CIPHER_RANDOM = 100;

    public static void main(String[] args) {

        boolean finished = false;
        char[] cipher = new char[CHARS_IN_CIPHER];
        cipher = createCipher(cipher);

        // cipher will remain the same while user uses the program,
        // but cipher will change if user restarts the program.

        //follow two for-loops prints alphabet and cipher for the
        //user to compare by themselves, if they want to.

        System.out.print("[");
        for(char alphabetLetter = 'a'; alphabetLetter <= 'z'; alphabetLetter++)
        {
            System.out.print(alphabetLetter
                    + ((alphabetLetter == 'z') ? "| ] = Entered Characters\n" : "|"));
        }

        System.out.print("[");
        for(int cipherIndex = 0; cipherIndex < CHARS_IN_CIPHER; cipherIndex++)
        {
            System.out.print(cipher[cipherIndex]
                    + ((cipherIndex == CHARS_IN_CIPHER - 1) ? "] = Cipher Characters\n" : "|"));
        }

        while (!finished)
        {
            System.out.println("Input your string (or enter 'quit'):");
            Scanner input = new Scanner(System.in);
            input.useDelimiter("\n");

            String userMessage = input.next();
            if (userMessage.equalsIgnoreCase("quit"))
                finished = true;
            else
            {
                String lowercaseMessage = userMessage.toLowerCase();
                char[] characterArray = lowercaseMessage.toCharArray();
                boolean validInput
                        = hasLettersAndSpacesOnly(characterArray);

                if (validInput)
                {
                    System.out.println(" Inputted: " + lowercaseMessage);
                    char[] encryptedMessage = encrypt(characterArray, cipher);
                    String encryptedOutput = new String(encryptedMessage);
                    System.out.println("Encrypted: " + encryptedOutput);

                    String decryptedMessage = decrypt(encryptedMessage, cipher);
                    System.out.println("Decrypted: " + decryptedMessage);
                }
                else
                {
                    System.out.println("Input must consist of letters "
                            + "and spaces only.");
                }
            }
        }

    }

    public static boolean hasLettersAndSpacesOnly(char[] userInputArray) {

        /* The assignment states that our cipher array must be
         * 27 characters (letters and spaces). As a result, we
         * must check that the user's input has no characters
         * other than letters and spaces.
         */

        for (int index = 0; index < userInputArray.length; index++) {
            char currentChar = userInputArray[index];

            if (!Character.isLetter(currentChar) && currentChar != ' ') {
                return false;
            }
        }

        return true;
    }

    public static char[] createCipher(char[] initialCipher) {
        int index = 0;

        //create alphabet array in normal order
        for (char letter = 'a'; letter <= 'z'; letter++)
        {
            initialCipher[index] = letter;
            index++;
        }

        Random value = new Random();

        for (int randomIndex = 0; randomIndex < CIPHER_RANDOM; randomIndex++)
        {
            int firstSwap = value.nextInt(CHARS_IN_CIPHER);
            int secondSwap = value.nextInt(CHARS_IN_CIPHER);

            char firstChar = initialCipher[firstSwap];
            char secondChar = initialCipher[secondSwap];

            initialCipher[firstSwap] = secondChar;
            initialCipher[secondSwap] = firstChar;
        }

        return initialCipher;
    }

    public static char[] encrypt(char[] usersMessage, char[] cipher) {

        for (int index = 0; index < usersMessage.length; index++)
        {
            int currentCharOrdinalValue = 0;
            char currentChar = usersMessage[index];

            if (currentChar == ' ')
                currentCharOrdinalValue = CHARS_IN_CIPHER - 1;
            else
            {
                while (currentChar != 'a')
                {
                    currentChar--;
                    currentCharOrdinalValue++;
                }
            }

            //above gets ordinal value of char, with 'a' = 0 and ' ' = 26

            usersMessage[index] = cipher[currentCharOrdinalValue];
        }
        return usersMessage;
    }

    public static String decrypt(char[] encryptedMessage, char[] cipher) {

        // make new alphabet array in normal order
        char[] alphabetArray = new char[CHARS_IN_CIPHER];
        int alphabetIndex = 0;

        for (char letter = 'a'; letter <= 'z'; letter++)
        {
            alphabetArray[alphabetIndex] = letter;
            alphabetIndex++;
        }

        // find ordinal value of the Cipher equivalent of encrypted character
        for (int index = 0; index < encryptedMessage.length; index++)
        {
            int currentCipherOrdinal = 0;
            char currentEncryptedChar = encryptedMessage[index];
            char currentCipherChar = cipher[currentCipherOrdinal];

            while (currentEncryptedChar != currentCipherChar) {
                currentCipherOrdinal++;
                currentCipherChar = cipher[currentCipherOrdinal];
            }

            // decrypted char = ordinal value of cipher with respect
            // to normal alphabet.
            encryptedMessage[index] = alphabetArray[currentCipherOrdinal];
        }

        String decryptedOutput = new String(encryptedMessage);
        return decryptedOutput;
    }

}