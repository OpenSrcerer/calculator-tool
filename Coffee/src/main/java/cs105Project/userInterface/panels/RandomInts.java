/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

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

    /**
     * Set specific components to a target ContentPane.
     * @param pane Target ContentPane.
     */
    public static void setComponents(final Container pane) {
        final JPanel titleHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel buttonLayout = getJPanel();
        final JPanel buttonHolder = getJPanel(new CardLayout());
        final JPanel interactionHolder = getJPanel(new BorderLayout());

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

        pane.add(
                getSplitPane(interactionHolder, outputArea),
                BorderLayout.CENTER
        );
    }
}
