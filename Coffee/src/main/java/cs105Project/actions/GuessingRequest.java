package cs105Project.actions;

import cs105Project.managers.RequestManager;

import javax.swing.*;
import java.util.Random;

/**
 * Menu option 4: Number guessing game. The program picks a random integer between 0 and
 * 65 and then asks the user to guess what it is. Every time the user misses a guess the program
 * tells them if their guess was higher or lower than the target number. In the end, when the user
 * guesses correctly they are congratulated and told how many guesses it took for them to find the
 * number. You may need to look up the random integer generation functions in the Java help files.
 */
public class GuessingRequest implements Request {

    private static int numberToGuess = new Random().nextInt(66);
    private static int guesses = 0;

    private int userInput;

    private final JTextArea outputArea;
    private final JButton button;

    public GuessingRequest(JTextArea outputArea, JButton button, String userInput) {
        this.outputArea = outputArea;
        this.button = button;

        try {
            this.userInput = Integer.parseInt(userInput);
            if (this.userInput < 0 || this.userInput > 65)
                throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            updateOutputArea(outputArea, outputArea.getText() + "How about you insert something that works?\n", outputArea.getRows() + 1);
            return;
        }

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);
        ++guesses;

        if (userInput == numberToGuess) {
            updateOutputArea(outputArea,
                    outputArea.getText() + "----------------------------------------------------------------\n"
                            + "Congratulations, you have guessed correctly! The number was "
                            + numberToGuess +".\n"
                            + "Total Guesses: " + guesses +".\n"
                            + "A new number has been picked, you may start guessing again.\n",
                    outputArea.getRows() + 4
            );
            numberToGuess = new Random().nextInt(66);
            guesses = 0;
        } else if (userInput > numberToGuess) {
            updateOutputArea(outputArea,
                    outputArea.getText() + "----------------------------------------------------------------\n"
                    + "You need to guess lower!\n"
                    + "Current guesses: " + guesses + ".\n",
                    outputArea.getRows() + 3
            );
        } else {
            updateOutputArea(outputArea,
                    outputArea.getText() + "----------------------------------------------------------------\n"
                    + "You need to guess higher!\n"
                    + "Current guesses: " + guesses + ".\n",
                    outputArea.getRows() + 3
            );
        }

        toggleRunButton(button);
    }
}
