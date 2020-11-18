package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class Palindrome {
    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        final JPanel titleHolder = new JPanel();
        titleHolder.setLayout(new BoxLayout(titleHolder, BoxLayout.PAGE_AXIS));
        final JPanel inputBox = new JPanel();
        inputBox.setLayout(new BoxLayout(inputBox, BoxLayout.PAGE_AXIS));
        final JPanel buttonHolder = new JPanel();
        buttonHolder.setLayout(new BoxLayout(buttonHolder, BoxLayout.PAGE_AXIS));
        final JPanel inputHolder = new JPanel();
        final JPanel checkBoxHolder = new JPanel();
        final JPanel buttonLayout = new JPanel();
        final JPanel interactionHolder = new JPanel(new BorderLayout());
        final JPanel scrollHolder = new JPanel(new GridLayout());

        setBackgrounds(buttonHolder, interactionHolder, scrollHolder, buttonLayout, inputBox, inputHolder, titleHolder, checkBoxHolder);

        JTextArea outputArea = PanelComponents.getTextArea(15,30);
        JTextField inputField = PanelComponents.getTextField("Insert String", 30);
        JCheckBox checkBox = PanelComponents.getCheckBox("Case Sensitive", false);

        titleHolder.add(getLabel("Palindrome Checker", titleFont));
        titleHolder.add(getLabel("This tool will check whether the string", descriptionFont));
        titleHolder.add(getLabel("in the box below is a palindrome.", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        checkBoxHolder.add(checkBox);

        inputBox.add(getLabel("String to check:", descriptionFont));
        inputBox.add(inputField);

        inputHolder.add(inputBox);

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.PALINDROME, outputArea, inputField, checkBox));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));

        buttonHolder.add(checkBoxHolder);
        buttonHolder.add(buttonLayout);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(inputHolder, BorderLayout.CENTER);
        interactionHolder.add(buttonHolder, BorderLayout.SOUTH);

        // Create a scroll pane as holder for the output
        JScrollPane scroll = new JScrollPane(
                outputArea,
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
