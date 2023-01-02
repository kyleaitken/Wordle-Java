import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class testWordle {

    public static int getRandom(int max) {
        int rnd = new Random().nextInt(max - 1);
        return rnd;
    }
    public static void main(String[] args) {
        final int numWords = 1000;
        String[] wordList = new String[numWords];

        try {
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine())  {
                String word = myReader.nextLine();
                wordList[counter] = word;
                counter++;
                System.out.println(word);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        // get random word
        String answer = wordList[getRandom(numWords)].toUpperCase();
        System.out.println(answer);

        // run wordle game 
        wordleRound round = new wordleRound(answer);
        boolean gameResult = round.playRound();
        if (gameResult) {
            System.out.println("Congratulations! You guessed correctly in " + round.numberOfGuesses + " guesses!");
        } else {
            System.out.println("Sorry, you didn't guess the correct word with the allotted number of tries. Better luck next time!");
        }

    }


}