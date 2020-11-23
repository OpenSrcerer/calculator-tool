/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.actions;

import cs105Project.managers.RequestManager;

import javax.swing.*;

/**
 * Menu option 5: Palindrome detection. Ask the user to input a string. Check if the string is a
 * palindrome. You may need to look up string manipulation functions in the Java library help pages
 * for this option.
 */
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
