public class Game {
    int mistakes;
    String title;
    String wrongLetters;
    char[] placeholders;
    public void Game() {
        this.mistakes = 0;
        this.title = "killer 2";
        this.wrongLetters = "";
    }
    // update mistakes
    public void updateMistakes() {
        this.mistakes++;
    }
    // String title - get random title from file
    // change title into char array

    // guessing array make array of '_' same lenght as movie title, use ' ' for spaces between words
    public void makePlaceholders() {
        this.placeholders = new char[this.title.length()];

        for (int i =0; i < this.title.length(); i++) {
            if (this.title.toCharArray()[i] == ' ') {
                this.placeholders[i] = ' ';
            } else {
                this.placeholders[i] = '_';
            }
        }
    }

    // check if letter in title
    public boolean checkLetter(char letter) {
        char[] titleArray = this.title.toCharArray();
        for (char ch : titleArray) {
            if (ch == letter) {
                return true;
            }
        }
        return false;
    }
    // update guessing array
    public void updatePlaceholders(char guess){
        char[] titleArray = this.title.toCharArray();
        for (int i = 0; i < this.placeholders.length; i++) {
            if (this.placeholders[i] == '_') {
                if (guess == titleArray[i]) {
                    this.placeholders[i] = guess;
                }
            }
        }
    }

    // print guessing array
    public void printPlaceholders() {
        System.out.print("You are guessing: ");
        for (int i = 0; i < this.placeholders.length; i++) {
            System.out.print(this.placeholders[i]);
        }
    }
    // update wrong answers
    public void updateWrongGuesses (String guess){
        this.wrongLetters += guess + " ";
    }
    // print wrong answers
    public void printMistakes() {
        System.out.println("You have guessed (" + this.mistakes + ") wrong letters: " + this.wrongLetters);
    }
    // print lives
    // check win condition
}
