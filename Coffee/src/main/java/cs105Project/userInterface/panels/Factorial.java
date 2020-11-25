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
 * Menu option 2: Factorial of the average. Ask the user to input 5 positive integers between 0
 * and 15. Proceed to calculate and display the average of the 5 integers, as well as the factorial of
 * the integer in the group which is closest to the group's average. You may need to look up the
 * factorial formula in a mathematics book. You should build the code for the calculation of the
 * factorial rather than use a built-in Java function.
 */

public final class Factorial {

    /**
     * Set specific components to a target ContentPane.
     * @param pane Target ContentPane.
     */
    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        final JPanel titleHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolder1 = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolder2 = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolder3 = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolder4 = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolder5 = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel inputHolderAll = getJPanel();

        final JPanel buttonLayout = getJPanel();
        final JPanel buttonHolder = getJPanel(new CardLayout());
        final JPanel interactionHolder = getJPanel(new BorderLayout());

        JTextArea outputArea = PanelComponents.getTextArea(15,30);
        JTextField[] inputFields = {
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4)
        };

        titleHolder.add(getLabel("Factorial of the Average", titleFont));
        titleHolder.add(getLabel("Given the five numbers below, this program", descriptionFont));
        titleHolder.add(getLabel("calculates their average and the factorial", descriptionFont));
        titleHolder.add(getLabel("of the number closest to the group's average.", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        inputHolder1.add(getLabel("N1:", descriptionFont));
        inputHolder1.add(inputFields[0]);
        inputHolder2.add(getLabel("N2:", descriptionFont));
        inputHolder2.add(inputFields[1]);
        inputHolder3.add(getLabel("N3:", descriptionFont));
        inputHolder3.add(inputFields[2]);
        inputHolder4.add(getLabel("N4:", descriptionFont));
        inputHolder4.add(inputFields[3]);
        inputHolder5.add(getLabel("N5:", descriptionFont));
        inputHolder5.add(inputFields[4]);

        inputHolderAll.add(inputHolder1);
        inputHolderAll.add(inputHolder2);
        inputHolderAll.add(inputHolder3);
        inputHolderAll.add(inputHolder4);
        inputHolderAll.add(inputHolder5);

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.FACTORIAL, outputArea, inputFields));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(inputHolderAll, BorderLayout.CENTER);
        interactionHolder.add(buttonHolder, BorderLayout.SOUTH);

        pane.add(
                getSplitPane(interactionHolder, outputArea),
                BorderLayout.CENTER
        );
    }
}
