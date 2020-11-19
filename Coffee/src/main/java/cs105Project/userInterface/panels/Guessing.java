package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class Guessing {
    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        final JPanel titleHolder = new JPanel();
        titleHolder.setLayout(new BoxLayout(titleHolder, BoxLayout.PAGE_AXIS));
        final JPanel inputHolder = new JPanel();
        inputHolder.setLayout(new BoxLayout(inputHolder, BoxLayout.PAGE_AXIS));
        final JPanel inputPanel = new JPanel();
        final JPanel buttonLayout = new JPanel();
        final JPanel buttonHolder = new JPanel(new CardLayout());
        final JPanel interactionHolder = new JPanel(new BorderLayout());
        final JPanel scrollHolder = new JPanel(new GridLayout());

        setBackgrounds(buttonHolder, interactionHolder, scrollHolder, buttonLayout, inputHolder, titleHolder, inputPanel);

        JTextArea outputField = PanelComponents.getTextArea(15,30);
        JTextField inputField = PanelComponents.getTextField("1", 4);

        titleHolder.add(getLabel("Number Guessing Game", titleFont));
        titleHolder.add(getLabel("Guess a number, 1-64.", descriptionFont));
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
