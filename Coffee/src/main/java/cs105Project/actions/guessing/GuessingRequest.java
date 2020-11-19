package cs105Project.actions.guessing;

import cs105Project.actions.Request;
import cs105Project.managers.RequestManager;

import javax.swing.*;
import java.util.Random;

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
            if (this.userInput <= 0 || this.userInput >= 66)
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
