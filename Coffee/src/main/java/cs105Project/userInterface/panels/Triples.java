package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

/**
 * Menu option 6: Pythagorean triples. Look up "Pythagorean triples" in a mathematics book or
 * online. There exist exactly 16 primitive Pythagorean triples involving integers with a hypotenuse
 * value smaller or equal to 100. Write a program that scans all possible integer combinations,
 * discovers the primitive triples and displays them on screen. Triples which are duplicates (for
 * instance [3, 4, 5] and [4, 3, 5]) or multiples (for instance [9, 12, 15] which is 3×[3, 4, 5]) should
 * also be displayed but marked in brackets in your output list, since they are considered to be mere
 * variations of primitive triples which should have appeared in your list earlier.
 */
public final class Triples {

    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        final JPanel titleHolder = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel buttonLayout = getJPanel();
        final JPanel buttonHolder = getJPanel(new CardLayout());
        final JPanel interactionHolder = getJPanel(new BorderLayout());

        JTextArea outputArea = PanelComponents.getTextArea(15,30);

        titleHolder.add(getLabel("Pythagorean Triples Calculator", titleFont));
        titleHolder.add(getLabel("Searches for pythagorean triple ratios", descriptionFont));
        titleHolder.add(getLabel("with a hypotenuse smaller or equal to 100.", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.TRIPLES, outputArea));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(buttonHolder, BorderLayout.CENTER);

        pane.add(
                getSplitPane(interactionHolder, outputArea),
                BorderLayout.CENTER
        );
    }
}
