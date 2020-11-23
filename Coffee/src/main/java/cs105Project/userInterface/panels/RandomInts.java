package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

/**
 * Menu option 3: Stats of random integers. Pick 6 random integers between 0 and 100 and
 * then display their sum, product, statistical variance and standard deviation. You may need to look
 * up pseudorandom number generation functions and the relevant mathematical formulae for the
 * statistical metrics (choose the population formula to calculate standard deviation, rather than the
 * one for sample.)
 */
public final class RandomInts {

    public static void setComponents(final Container pane) {
        final JPanel titleHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel buttonLayout = getJPanel();
        final JPanel buttonHolder = getJPanel(new CardLayout());
        final JPanel interactionHolder = getJPanel(new BorderLayout());
        final JPanel scrollHolder = getJPanel(new GridLayout());

        JTextArea outputArea = PanelComponents.getTextArea(15,30);

        titleHolder.add(getLabel("Stats of Random Integers (0-100)", titleFont));
        titleHolder.add(getLabel("Gets these stats for 6 random integers:", descriptionFont));
        titleHolder.add(getLabel("Sum, Product, Variance,", descriptionFont));
        titleHolder.add(getLabel("Standard Deviation", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.RANDOMINTS, outputArea));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
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
