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
    /**
     * String to test whether it's a palindrome.
     */
    private final String stringToTest;

    /**
     * Should the check be case sensitive?
     */
    private final boolean isCaseSensitive;

    /**
     * Should the check be space sensitive?
     */
    private final boolean isSpaceSensitive;

    /**
     * Output area for the program's output.
     */
    private final JTextArea outputArea;

    /**
     * Button that starts the execution of this request.
     */
    private final JButton button;

    /**
     * Create a PalindromeRequest object and add it to
     * the Request queue.
     * @param outputField JTextArea to redirect output to.
     * @param button Button that initiates requests.
     * @param inputString What the user input.
     * @param isCaseSensitive Whether the check should be case sensitive.
     */
    public PalindromeRequest(JTextArea outputField, JButton button, String inputString, boolean isCaseSensitive, boolean isSpaceSensitive) {
        this.stringToTest = inputString;
        this.outputArea = outputField;
        this.button = button;
        this.isCaseSensitive = isCaseSensitive;
        this.isSpaceSensitive = isSpaceSensitive;

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);
        String tempString = stringToTest;

        if (!isSpaceSensitive)
            tempString = tempString.replace(" ", "");

        if (!isCaseSensitive)
            tempString = tempString.toLowerCase();

        // using the isPalindrome method from the Functions class!
        if (Functions.isPalindrome(tempString, 0)) {
            updateOutputArea(outputArea, outputArea.getText() + stringToTest + " IS a palindrome." + "\n", outputArea.getRows() + 1);
        } else {
            updateOutputArea(outputArea, outputArea.getText() + stringToTest + " IS NOT a palindrome." + "\n", outputArea.getRows() + 1);
        }

        toggleRunButton(button);
    }
}
