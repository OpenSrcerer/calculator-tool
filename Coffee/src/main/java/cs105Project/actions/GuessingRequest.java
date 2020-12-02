/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

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

    /**
     * Number that the user will guess.
     */
    private static int numberToGuess = new Random().nextInt(66);
    /**
     * Number the times user has already guessed.
     */
    private static int guesses = 0;

    /**
     * Variable to store userInput in;
     */
    private int userInput;

    /**
     * Output area for the program's output.
     */
    private final JTextArea outputArea;

    /**
     * Button that starts the execution of this request.
     */
    private final JButton button;

    /**
     * Create a new GuessingRequest object and put it in the
     * Request queue.
     * @param outputArea JTextArea to redirect output to.
     * @param button Button that created this request.
     * @param userInput User's input.
     */
    public GuessingRequest(JTextArea outputArea, JButton button, String userInput) {
        this.outputArea = outputArea;
        this.button = button;

        try {
            this.userInput = Integer.parseInt(userInput);
            if (this.userInput < 0 || this.userInput > 65)
                throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            updateOutputArea(outputArea, outputArea.getText() + "Error in input: Please guess from 0-65!\n", outputArea.getRows() + 1);
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
                    + "You guessed: " + userInput + ".\nYou need to guess lower!\n"
                    + "Current guesses: " + guesses + ".\n",
                    outputArea.getRows() + 4
            );
        } else {
            updateOutputArea(outputArea,
                    outputArea.getText() + "----------------------------------------------------------------\n"
                    + "You guessed: " + userInput + ".\nYou need to guess higher!\n"
                    + "Current guesses: " + guesses + ".\n",
                    outputArea.getRows() + 4
            );
        }

        toggleRunButton(button);
    }
}
