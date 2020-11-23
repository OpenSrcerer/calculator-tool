package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

/**
 * Menu option 4: Number guessing game. The program picks a random integer between 0 and
 * 65 and then asks the user to guess what it is. Every time the user misses a guess the program
 * tells them if their guess was higher or lower than the target number. In the end, when the user
 * guesses correctly they are congratulated and told how many guesses it took for them to find the
 * number. You may need to look up the random integer generation functions in the Java help files.
 */
public final class Guessing {
    public static void setComponents(final Container pane) {

        // Init all the JPanels necessary for this program.
        final JPanel inputPanel = getJPanel();
        final JPanel buttonLayout = getJPanel();
        final JPanel titleHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel buttonHolder = getJPanel(new CardLayout());
        final JPanel interactionHolder = getJPanel(new BorderLayout());
        final JPanel scrollHolder = getJPanel(new GridLayout());

        JTextArea outputField = PanelComponents.getTextArea(15,30);
        JTextField inputField = PanelComponents.getTextField("1", 4);

        titleHolder.add(getLabel("Number Guessing Game", titleFont));
        titleHolder.add(getLabel("Guess a number, 0-65.", descriptionFont));
        titleHolder.add(getLabel("Put your guess in the box below.", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        inputHolder.add(getLabel("Your Guess:", descriptionFont));
        inputHolder.add(inputField);

        inputPanel.add(inputHolder);

        buttonLayout.add(PanelComponents.getButton("Guess", ButtonType.GUESSING, outputField, inputField));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(inputPanel, BorderLayout.CENTER);
        interactionHolder.add(buttonHolder, BorderLayout.SOUTH);

        // Create a scroll pane as holder for the output
        JScrollPane scroll = new JScrollPane(
                outputField,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scroll.setBackground(discordGray);
        scrollHolder.add(scroll);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                interactionHolder, scrollHolder
        );
        splitPane.setEnabled(false);
        splitPane.setDividerSize(1);

        pane.add(
                splitPane,
                BorderLayout.CENTER
        );
    }
}
