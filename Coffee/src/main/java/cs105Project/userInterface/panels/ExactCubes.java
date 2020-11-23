package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

/**
 * Menu option 1: Exact cubes. Calculate and display the list of all integer numbers between the lowest bound
 * and the highest bound which are the exact cube of another integer. Your program should also calculate the sum,
 * average, statistical variance and standard deviation of all exact cubes it discovers within the
 * prescribed range. Example: integer 8 is the exact cube of integer 2, 27 is the cube of integer 3, 64
 * is the cube of 4, etc.
 */
public final class ExactCubes {

    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        final JPanel titleHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolderL = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolderR = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel barHolder = getJPanel();
        final JPanel inputHolderBoth = getJPanel();
        final JPanel buttonLayout = getJPanel();
        final JPanel buttonHolder = getJPanel(new CardLayout());
        final JPanel buttonAndBarHolder = getJPanel(new BorderLayout());
        final JPanel interactionHolder = getJPanel(new BorderLayout());
        final JPanel scrollHolder = getJPanel(new GridLayout());

        JTextArea outputArea = PanelComponents.getTextArea(15,30);
        JProgressBar progressBar = PanelComponents.getProgressBar();
        JTextField inputFieldL = PanelComponents.getTextField("1", 10);
        JTextField inputFieldR = PanelComponents.getTextField("500", 10);

        titleHolder.add(getLabel("Exact Cubes Calculator", titleFont));
        titleHolder.add(getLabel("Searches for exact cubes of numbers,", descriptionFont));
        titleHolder.add(getLabel("in the range provided below:", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        inputHolderL.add(getLabel("From:", descriptionFont));
        inputHolderL.add(inputFieldL);

        inputHolderR.add(getLabel("To:", descriptionFont));
        inputHolderR.add(inputFieldR);

        inputHolderBoth.add(inputHolderL);
        inputHolderBoth.add(Box.createHorizontalStrut(50));
        inputHolderBoth.add(inputHolderR);

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.EXACTCUBES, outputArea, progressBar, inputFieldL, inputFieldR));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        barHolder.add(progressBar);

        buttonAndBarHolder.add(buttonHolder, BorderLayout.NORTH);
        buttonAndBarHolder.add(barHolder, BorderLayout.SOUTH);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(inputHolderBoth, BorderLayout.CENTER);
        interactionHolder.add(buttonAndBarHolder, BorderLayout.SOUTH);

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
