package cs105Project.actions.palindrome;

import cs105Project.actions.Functions;
import cs105Project.actions.Request;
import cs105Project.managers.RequestManager;

import javax.swing.*;

public class PalindromeRequest implements Request {
    private final String stringToTest;
    private final boolean isCaseSensitive;

    // Output UI References & Variables
    private final JTextArea outputField;
    private final JButton button;

    public PalindromeRequest(JTextArea outputField, JButton button, String inputString, boolean isCaseSensitive) {
        this.stringToTest = inputString;
        this.outputField = outputField;
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
            updateOutputArea(outputField, outputField.getText() + "\n" + stringToTest + " IS a palindrome.", outputField.getRows() + 1);
        } else {
            updateOutputArea(outputField, outputField.getText() + "\n" + stringToTest + " IS NOT a palindrome.", outputField.getRows() + 1);
        }

        toggleRunButton(button);
    }
}
