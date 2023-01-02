public class Game {
    int mistakes;
    String title;
    String wrongLetters;
    char[] placeholders;
    Game(String[] titles) {
        this.mistakes = 0;
        this.wrongLetters = "";
        this.title = this.getRandomTitle(titles);
        this.makePlaceholders();
    }

    /** method getRandomTitle - gets random title from an array of titles
     * @param titles - String[]
     *
     * */
    private String getRandomTitle (String[] titles) {
        int i = (int) (Math.random()*titles.length);
        return titles[i];
    }
    // update mistakes count
    public void updateMistakes() {
        this.mistakes++;
    }

    /** method makePlaceholders - makes guessing array of '_' same length as movie title,
    * uses ' ' for spaces between words
    * */
    private void makePlaceholders() {
        this.placeholders = new char[this.title.length()];

        for (int i =0; i < this.title.length(); i++) {
            if (this.title.toCharArray()[i] == ' ') {
                this.placeholders[i] = ' ';
            } else {
                this.placeholders[i] = '_';
            }
        }
    }

    /** method checkLetter - checks if letter is in title
    * @param letter - char
    * @return boolean
    *
    * */
    public boolean checkLetter(char letter) {
        char[] titleArray = this.title.toCharArray();
        for (char ch : titleArray) {
            if (ch == letter) {
                return true;
            }
        }
        return false;
    }

    /** method upadatePlaceholders - updates guessing array with given letter
     * @param guess - char
     *
     * */
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

    /** method printPlacehodlers - prints guessing array
     * */
    public void printPlaceholders() {
        System.out.print("\nYou are guessing: ");
        for (int i = 0; i < this.placeholders.length; i++) {
            System.out.print(this.placeholders[i]);
        }
    }

    /** method updateWrongGuesses - uptades wrong guess list
     * @param guess - string
     *
     * */
    public void updateWrongGuesses (String guess){
        this.wrongLetters += guess + " ";
    }
    // print wrong answers
    /** method printMistakes - prints wrong picks
     * */
    public void printMistakes() {
        System.out.println("\nYou have guessed (" + this.mistakes + ") wrong letters: " + this.wrongLetters);
    }

}
