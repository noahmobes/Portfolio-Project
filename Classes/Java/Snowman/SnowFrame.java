import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class SnowFrame extends JFrame {
    private Snowman snow;
    private SnowmanPanel canvas = new SnowmanPanel(); //for drawing
    private JTextArea tbGuess = new JTextArea(); // for user input
    private JTextArea tbName = new JTextArea(); // for user input
    private JLabel lblWord = new JLabel("Word to guess:"); // for word to guess
    private JLabel lblGuessed = new JLabel("Incorrect guesses:"); // for guessed letters
    private JLabel lblResult = new JLabel(""); // for result of guess
    private JButton btnStart = new JButton("Start Game"); // for starting the game
    private JLabel lblGameOver = new JLabel(""); // for game over message
    private JButton btnGuess = new JButton("Submit"); // for submitting a guess

    //Constructor
    public SnowFrame (Snowman snow){
        this.snow = snow;
        initComponents();
    }

    private void initComponents(){
        setLayout(new BorderLayout());
        setTitle("Snowman");
        setSize(500, 400);

        // Class header
        JLabel lblHeader = new JLabel("Noah Moberly | Snowman | MoberlyP3");
        add(lblHeader, BorderLayout.NORTH);

        // Guess panel
        JPanel guessPanel = new JPanel();
        guessPanel.setLayout(new FlowLayout());
        guessPanel.setPreferredSize(new Dimension(200, 100));
        add(guessPanel, BorderLayout.EAST);

        // Guess label
        JLabel lblGuess = new JLabel("Guess a letter:");
        lblGuess.setPreferredSize(new Dimension(200, 20));
        guessPanel.add(lblGuess);

        // Guess input
        tbGuess.setEnabled(false);
        tbGuess.setPreferredSize(new Dimension(200, 20));
        guessPanel.add(tbGuess);

        // Guess button
        btnGuess.setPreferredSize(new Dimension(100, 30));
        btnGuess.addActionListener(new SubmitListener());
        btnGuess.setEnabled(false);
        guessPanel.add(btnGuess);

        // Name label
        JLabel lblName = new JLabel("Name:");
        lblName.setPreferredSize(new Dimension(200, 20));
        guessPanel.add(lblName);

        // Name input
        tbName.setPreferredSize(new Dimension(200, 20));
        guessPanel.add(tbName);

        // Start button
        btnStart.setPreferredSize(new Dimension(100, 30));
        btnStart.addActionListener(new StartListener());
        guessPanel.add(btnStart);

        // Quit button
        JButton btnQuit = new JButton("Quit");
        btnQuit.setPreferredSize(new Dimension(100, 30));
        btnQuit.addActionListener(new QuitListener());
        guessPanel.add(btnQuit);

        // Result label
        lblResult.setPreferredSize(new Dimension(300, 20));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        guessPanel.add(lblResult);

        // Left panel for the snowman and game info
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new FlowLayout());
        pnlInfo.setPreferredSize(new Dimension(300, 600));
        add(pnlInfo, BorderLayout.CENTER);

        // Snowman canvas
        canvas.setPreferredSize(new Dimension(300, 250));
        pnlInfo.add(canvas, BorderLayout.CENTER);

        // Word to guess
        lblWord.setPreferredSize(new Dimension(280, 20));
        pnlInfo.add(lblWord);

        // Incorrect guessed letters
        lblGuessed.setPreferredSize(new Dimension(280, 20));
        pnlInfo.add(lblGuessed);

        // Game over message
        lblGameOver.setPreferredSize(new Dimension(400, 20));
        add(lblGameOver, BorderLayout.SOUTH);
    }

    // Listeners
    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (tbGuess.getText().isEmpty()) {
                lblResult.setText("Please enter a letter to guess.");
                return;
            }
            checkResult(tbGuess.getText().charAt(0) + "");
            tbGuess.setText("");
            showGuessingWord();
            lblGuessed.setText("Incorrect guesses: " + snow.getIncorrectLetters());
        }
    }
    private class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (tbName.getText().isEmpty()) {
                lblResult.setText("Enter your name to start the game.");
                return;
            }
            snow.setName(tbName.getText());
            tbName.setEnabled(false);
            tbGuess.setEnabled(true);
            btnGuess.setEnabled(true);
            btnStart.setEnabled(false);
            lblGameOver.setText("");
            lblGuessed.setText("Incorrect guesses:");
            snow.reroll();
            showGuessingWord();
        }
    }

    private class QuitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sayGoodBye();
        }
    }

    // Methods
    private void showGuessingWord() {
        lblWord.setText("Word to guess: " + snow.getHiddenString());
    }
    private void checkResult(String guess) {
        int status = snow.checkGuess(guess);

        switch (status) {
            case 1:
                lblResult.setText("You already guessed that letter!");
                break;
            case 2:
                lblResult.setText(guess + " is not in the word.");
                drawSnowman(snow.getIncorrectGuesses());
                break;
            case 3:
                lblResult.setText(guess + " is in the word!");
                break;
            case 4:
                btnStart.setEnabled(true);
                lblGameOver.setText(snow.getGameOverString());
                btnGuess.setEnabled(false);
                tbGuess.setEnabled(false);
                drawSnowman(6);
                break;
            default:
                lblResult.setText("An error occurred.");
                break;
        }
    }

    private void sayGoodBye() {
        JOptionPane.showMessageDialog(this, snow.getGoodBye());
        System.exit(0);
    }

    private void drawSnowman(int num) {
        switch (num) {
            case 1:
                canvas.addBase();
                break;
            case 2:
                canvas.addMiddle();
                break;
            case 3:
                canvas.addHead();
                break;
            case 4:
                canvas.addArms();
                break;
            case 5:
                canvas.addSmile();
                break;
            case 6:
                canvas.addEyes();
                break;
            default:
                break;
        }
    }
}