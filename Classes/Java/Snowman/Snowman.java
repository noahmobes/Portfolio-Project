import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Snowman {
    private String name;
    private String[] words = {"alaska", "florida", "hawaii", "maine", "nevada", "oregon", "texas", "utah", "vermont", "wyoming"};
    private String hiddenWord;
    private StringBuilder hiddenString; // This is guessingWord
    private List<String> guesses;
    private StringBuilder incorrectLetters;
    private int correctGuesses;
    private int incorrectGuesses;
    private String gameOver;
    private int gamesWon;
    private int gamesLost;
    private int guessTotal;
    private double correctPercentage;
    private DecimalFormat df = new DecimalFormat("###.##");
    
    // Methods
    public int checkGuess(String letter) {
        int status = 0;
        // If letter has already been guessed
        if (guesses.contains(letter)) {
            return 1;
        }
        // If the guess is wrong
        if (!hiddenWord.contains(letter)) {
            guesses.add(letter);
            incorrectLetters.append(letter);
            incorrectGuesses += 1;
            status = 2;
        }
        // If the guess is correct
        if (hiddenWord.contains(letter)) {
            guesses.add(letter);
            correctGuesses += 1;
            List<Integer> indexes = getIndexes(letter, hiddenWord);
            for (int i = 0; i < indexes.size(); i++) {
                hiddenString.replace(indexes.get(i), indexes.get(i) + 1, letter);
            }
            status = 3;
        }
        // If the player has won
        if (hiddenString.toString().equals(hiddenWord)) {
            setGuessTotalAndCorrectPercentage();
            gamesWon += 1;
            gameOver = "You won!" + " Total guesses: " + guessTotal + " Correct guesses: "
            + correctGuesses + " Correct guess %: " + correctPercentage + " Games won: " + gamesWon;
            status = 4;
        }
        // If the player has run out of guesses and lost
        if (incorrectGuesses == 6) {
            setGuessTotalAndCorrectPercentage();
            gamesLost += 1;
            gameOver = "You ran out of guesses!" + " Total guesses: " + guessTotal + " Correct guesses: "
            + correctGuesses + " Correct guess %: " + correctPercentage + " Games won: " + gamesWon;
            status = 4;
        }

        return status;
    }

    // Setters and getters
    public void setName(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }
    public String getHiddenString() {
        return hiddenString.toString();
    }
    public String getIncorrectLetters() {
        return incorrectLetters.toString();
    }
    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }
    public String getGameOverString() {
        return gameOver;
    }
    public String getGoodBye() {
        return "Thanks for playing, " + (name != null ? name : "Player") + "!" + "\nGames played: " + (gamesWon + gamesLost) + "\nGames won: " + gamesWon;
    }
    // To get a list of indexes of every occurance of a letter in a string
    public static List<Integer> getIndexes(String letter, String string) {
        List<Integer> indexes = new ArrayList<Integer>();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == letter.charAt(0)) {
                indexes.add(i);
            }
        }

        return indexes;
    }
    // To set the total number of guesses and to set percent of correct guesses
    private void setGuessTotalAndCorrectPercentage() {
        guessTotal = correctGuesses + incorrectGuesses;
        correctPercentage = Double.parseDouble(df.format((double)correctGuesses / guessTotal * 100));
    }
    // To reset the hiddenWord and to reset guess stats
    public void reroll() {
        hiddenWord = words[(int)(Math.random() * words.length)];
        guesses = new ArrayList<>();
        incorrectLetters = new StringBuilder("");
        correctGuesses = 0;
        incorrectGuesses = 0;
        hiddenString = new StringBuilder("");

        // Adding * for every character in the hidden word to hiddenString
        for (int i = 0; i < hiddenWord.length(); i++) {
            hiddenString.append("*");
        }
    }

    // Constructors
    public Snowman() {
        reroll();
        gamesWon = 0;
        gamesLost = 0;
    }
}