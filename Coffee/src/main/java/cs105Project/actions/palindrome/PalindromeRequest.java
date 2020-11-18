package cs105Project.actions.palindrome;

import cs105Project.actions.Functions;
import cs105Project.actions.Request;
import cs105Project.managers.RequestManager;

import javax.swing.*;

public class PalindromeRequest implements Request {
    // What is taken as input
    private final String stringToTest;
    private final boolean isCaseSensitive;

    // Output UI References & Variables
    private final JTextArea outputArea;
    private final JButton button;

    public PalindromeRequest(JTextArea outputField, JButton button, String inputString, boolean isCaseSensitive) {
        this.stringToTest = inputString;
        this.outputArea = outputField;
        this.button = button;
        this.isCaseSensitive = isCaseSensitive;

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);
        String tempString = stringToTest;

        if (!isCaseSensitive)
            tempString = tempString.toLowerCase();

        if (Functions.isPalindrome(tempString, 0)) {
            updateOutputArea(outputArea, outputArea.getText() + stringToTest + " IS a palindrome." + "\n", outputArea.getRows() + 1);
        } else {
            updateOutputArea(outputArea, outputArea.getText() + stringToTest + " IS NOT a palindrome." + "\n", outputArea.getRows() + 1);
        }

        toggleRunButton(button);
    }
}
