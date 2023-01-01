import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String guess;
        char chGuess;
        // String title = "Killer";
        Game game = new Game();
        game.Game();
        game.makePlaceholders();

        while (game.mistakes < 10) {
            System.out.println();
            game.printPlaceholders();
            System.out.println();
            game.printMistakes();
            System.out.print("Guess a letter: ");
            // add while loop that checks if input is valid
            guess = scan.next();
            chGuess = guess.charAt(0);
            if (game.checkLetter(chGuess)) {
                game.updatePlaceholders(chGuess);
            } else {
                game.updateMistakes();
                game.updateWrongGuesses(guess);
            }
            if (Arrays.equals(game.placeholders, game.title.toCharArray())) {
                System.out.println("You guessed right title! YOU WIN!");
                System.out.println("Title: " + game.title);
                break;
            }
        }
        if (game.mistakes == 10) {
            System.out.println("You lost!");
            System.out.println("Title: " + game.title);
        }

        scan.close();
    }
}