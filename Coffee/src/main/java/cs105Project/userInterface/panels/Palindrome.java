package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

/**
 * Menu option 5: Palindrome detection. Ask the user to input a string. Check if the string is a
 * palindrome. You may need to look up string manipulation functions in the Java library help pages
 * for this option.
 */
public final class Palindrome {
    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        final JPanel titleHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel buttonHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputBox = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolder = getJPanel();
        final JPanel checkBoxHolder = getJPanel();
        final JPanel buttonLayout = getJPanel();
        final JPanel interactionHolder = getJPanel(new BorderLayout());

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

        pane.add(
                getSplitPane(interactionHolder, outputArea),
                BorderLayout.CENTER
        );
    }
}
