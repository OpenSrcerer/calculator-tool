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
 * Manages the main selection menu.
 */
public final class Selection {

    /**
     * Set specific components to a target ContentPane.
     * @param pane Target ContentPane.
     */
    public static void setComponents(final Container pane) {
        final JPanel imagePanel = getJPanel();
        final JPanel actionPanel = getJPanel(new GridLayout(3,3));
        final JPanel titlePanel = getJPanel(new BorderLayout());
        final JPanel textPanel = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel textAndImagePanel = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel cardPanel = getJPanel(new CardLayout());

        {
            JButton fakeButton = new JButton("Fake button");
            Dimension buttonSize = fakeButton.getPreferredSize();

            actionPanel.setPreferredSize(
                    new Dimension(
                            (int) (buttonSize.getWidth() * 4),
                            (int) (buttonSize.getHeight() * 10)
                    )
            );
        }

        textPanel.add(getLabel("Multitool for different purpose", titleFont));
        textPanel.add(getLabel("calculations and fun stuff!", titleFont));
        textPanel.add(Box.createVerticalStrut(10));

        imagePanel.add(Box.createHorizontalStrut(-25));
        imagePanel.add(PanelComponents.getImageLabel("mtool.png"));

        textAndImagePanel.add(imagePanel, BorderLayout.NORTH);
        textAndImagePanel.add(textPanel, BorderLayout.SOUTH);

        cardPanel.add(textAndImagePanel);

        titlePanel.add(getSeparator(), BorderLayout.NORTH);
        titlePanel.add(cardPanel, BorderLayout.CENTER);
        titlePanel.add(getSeparator(), BorderLayout.SOUTH);

        actionPanel.add(getBorderedButton("Exact <br>Cubes", ButtonType.EXACTCUBES));
        actionPanel.add(getBorderedButton("Factorial of <br>the Average", ButtonType.FACTORIAL));
        actionPanel.add(getBorderedButton("Stats of Random <br>Integers", ButtonType.RANDOMINTS));
        actionPanel.add(getBorderedButton("Number <br>Guessing Game", ButtonType.GUESSING));
        actionPanel.add(getBorderedButton("Palindrome <br>Detection", ButtonType.PALINDROME));
        actionPanel.add(getBorderedButton("Pythagorean <br>Triples", ButtonType.TRIPLES));
        actionPanel.add(PanelComponents.getJPanel());
        actionPanel.add(getBorderedButton("Exit", ButtonType.EXIT));

        pane.add(TopPanel.getTopPanel(), BorderLayout.NORTH);
        pane.add(titlePanel, BorderLayout.CENTER);
        pane.add(actionPanel, BorderLayout.SOUTH);
    }
}
