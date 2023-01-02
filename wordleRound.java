import java.util.Scanner;
import java.util.Arrays;

public class wordleRound {
    protected final String answer;
    protected String guess;
    protected int numberOfGuesses;

    public wordleRound(String ans) {
        this.answer = ans;
    }

    boolean playRound() {
        this.numberOfGuesses = 0;
        boolean guessedWord = false;
        Scanner getGuess = new Scanner(System.in);

        while (numberOfGuesses < 5 && !guessedWord) {
            // Get new guess 
            System.out.println("Guess a 5 letter word: ");
            this.guess = getGuess.nextLine().toUpperCase();
            System.out.println("You guessed: " + guess);

            guessedWord = checkGuess();
            numberOfGuesses++;
        }
        getGuess.close();
        return guessedWord;
    }

   
    boolean checkGuess() {
        if (guess.compareTo(answer) == 0) {
            return true;
        } else {
            char[] clues = new char[5];
            Arrays.fill(clues, '-');

            for (int i=0; i< 5; i++) {
                char guessChar = guess.charAt(i);
                for (int j=0; j<5; j++) {
                    char ansChar = answer.charAt(j);
                    if (guessChar == ansChar) {
                        if (i == j) {
                            clues[i] = Character.toUpperCase(guessChar); 
                            break;
                        } else {
                            clues[i] = Character.toLowerCase(guessChar);
                            break;
                        }
                    }
                }
            }
            String clue = new String(clues);
            System.out.println("Here's a clue:\n" + clue + "\nThe uppercase letters represent characters that are in the word and in the right location, while lowercase letters represent characters that are in the word, but not in the correct place");
            return false;
        }
    }


}