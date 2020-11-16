package cs105Project.actions;

import javax.swing.*;

public interface Request extends Runnable {

    default void toggleRunButton(JButton button) {
        SwingUtilities.invokeLater(() -> button.setEnabled(!button.isEnabled()));
    }

    /**
     * Gives a JProgressBar a new value.
     * @param bar Target JProgressBar
     * @param value Value to set
     */
    default void updateProgressBar(JProgressBar bar, int value) {
        SwingUtilities.invokeLater(() -> bar.setValue(value));
    }

    /**
     * Updates the output area with the preset text.
     * Scrolls to the bottom using the caret.
     * @param outputArea Target output JTextArea.
     * @param areaText Text to output in the area.
     * @param areaRows The number of newlines in the given text.
     */
    default void updateOutputArea(JTextArea outputArea, String areaText, int areaRows) {
        // set field rows to fit in result exactly
        SwingUtilities.invokeLater(() -> {
            outputArea.setRows(areaRows);
            outputArea.setText(areaText);
            outputArea.setCaretPosition(outputArea.getDocument().getLength() - 1);
        });
    }
}
