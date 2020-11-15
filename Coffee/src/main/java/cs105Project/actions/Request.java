package cs105Project.actions;

import cs105Project.userInterface.MainWindow;

import javax.swing.*;

// Marker interface
public interface Request extends Runnable {

    default void updateProgressBar(JProgressBar bar, int value) {
        bar.setValue(value);
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
        outputArea.setRows(areaRows);
        outputArea.setText(areaText);
        outputArea.setCaretPosition(outputArea.getDocument().getLength() - 1);
    }
}
