import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String guess;
        char chGuess;

        Titles movies = new Titles();

        Game game = new Game(movies.titles);

        while (game.mistakes < 10) {
            game.printPlaceholders();
            game.printMistakes();
            System.out.print("Guess a letter: ");
            guess = scan.next();
            chGuess = guess.charAt(0);
            if (game.checkLetter(chGuess)) {
                game.updatePlaceholders(chGuess);
            } else {
                game.updateMistakes();
                game.updateWrongGuesses(guess);
            }
            if (Arrays.equals(game.placeholders, game.title.toCharArray())) {
                System.out.println("\nYou guessed right title! YOU WIN!");
                System.out.println("Title: " + game.title);
                break;
            }
        }
        if (game.mistakes == 10) {
            System.out.println("\nYou lost!");
            System.out.println("Title: " + game.title);
        }

        scan.close();
    }
}