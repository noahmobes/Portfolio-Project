import javax.swing.JOptionPane;

public class SnowmanUI {
    private Snowman snow;

    // Methods
    public void play() {
        int playStatus = 0;
        String guess;
        int doAgain;

        writeHeader();

        String name = JOptionPane.showInputDialog("What is your name?");
        snow.setName(name);

        do {
            // Rerolling the hidden word and resetting guessed letters
            snow.reroll();
            do {
                do {
                    guess = JOptionPane.showInputDialog("Name: " + snow.getName() + "\nWord: " + snow.getHiddenString() + "\nIncorrect guesses: " + snow.getIncorrectLetters() +
                    "\nPlease enter your guess letter:").toLowerCase();
                } while (guess.length() > 1);

                playStatus = snow.checkGuess(guess);

                if (playStatus == 1) {
                    JOptionPane.showMessageDialog(null, "You already guessed: " + guess);
                } else if (playStatus == 2) {
                    JOptionPane.showMessageDialog(null, guess + " is not in the hidden word.");
                } else if (playStatus == 3) {
                    JOptionPane.showMessageDialog(null, guess + " is in the hidden word!");
                }

            } while (playStatus != 4);

            // Play again?
            doAgain = JOptionPane.showConfirmDialog(null, snow.getGameOverString(), "Play Again?", JOptionPane.YES_NO_OPTION);
        } while (doAgain == JOptionPane.YES_OPTION);

        sayGoodBye();
    }
    public void sayGoodBye() {
        JOptionPane.showMessageDialog(null, snow.getGoodBye());
    }

    // Writing class header
    public static void writeHeader() {
        JOptionPane.showMessageDialog(null, "Noah Moberly\n" + "nmoberly@cnm.edu\n" + "Snowman");
    }

    // Constructors
    public SnowmanUI(Snowman snow) {
        this.snow = snow;
    }
}