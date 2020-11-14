package cs105Project.userInterface.panels;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class Selection {

    public static void setComponents(final Container pane) {
        final JPanel actionPanel = new JPanel(new GridLayout(3,3));
        final JPanel titlePanel = new JPanel(new BorderLayout());
        final JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        final JPanel cardPanel = new JPanel(new CardLayout());

        setBackgrounds(actionPanel, textPanel, cardPanel, titlePanel);

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

        textPanel.add(Box.createVerticalStrut(50));
        textPanel.add(getJLabel("Multitool for different purpose"));
        textPanel.add(getJLabel("calculations and fun stuff!"));
        textPanel.add(Box.createVerticalStrut(50));
        cardPanel.add(textPanel);
        titlePanel.add(getJSeparator(), BorderLayout.NORTH);
        titlePanel.add(cardPanel, BorderLayout.CENTER);
        titlePanel.add(getJSeparator(), BorderLayout.SOUTH);

        actionPanel.add(getBorderedButton("Exact <br>Cubes", ButtonType.EXACTCUBES));
        actionPanel.add(getBorderedButton("Factorial of <br>the Average", ButtonType.FACTORIAL));
        actionPanel.add(getBorderedButton("Stats of Random <br>Integers", ButtonType.RANDOMINTS));
        actionPanel.add(getBorderedButton("Number <br>Guessing Game", ButtonType.GUESSING));
        actionPanel.add(getBorderedButton("Palindrome <br>Detection", ButtonType.PALINDROME));
        actionPanel.add(getBorderedButton("Pythagorean <br>Triples", ButtonType.TRIPLES));
        actionPanel.add(getEmptyJPanel());
        actionPanel.add(getBorderedButton("Exit", ButtonType.EXIT));

        pane.add(TopPanel.getTopPanel(), BorderLayout.NORTH);
        pane.add(titlePanel, BorderLayout.CENTER);
        pane.add(actionPanel, BorderLayout.SOUTH);
    }
}
