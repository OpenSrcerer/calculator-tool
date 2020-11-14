package cs105Project.userInterface.panels;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class Selection {

    public static void setComponents(final Container pane) {
        final JPanel actionPanel = new JPanel(new GridLayout(3,3));
        actionPanel.setBackground(discordGrayer);

        {
            JButton fakeButton = new JButton("Fake button");
            Dimension buttonSize = fakeButton.getPreferredSize();

            actionPanel.setPreferredSize(
                    new Dimension(
                            (int) (buttonSize.getWidth() * 5),
                            (int) (buttonSize.getHeight() * 10)
                    )
            );
        }

        actionPanel.add(getButton("Exact <br>Cubes", ButtonType.EXACTCUBES));
        actionPanel.add(getButton("Factorial of <br>the Average", ButtonType.FACTORIAL));
        actionPanel.add(getButton("Stats of Random <br>Integers", ButtonType.RANDOMINTS));
        actionPanel.add(getButton("Number <br>Guessing Game", ButtonType.GUESSING));
        actionPanel.add(getButton("Palindrome <br>Detection", ButtonType.PALINDROME));
        actionPanel.add(getButton("Pythagorean <br>Triples", ButtonType.TRIPLES));
        actionPanel.add(getEmptyJPanel());
        actionPanel.add(getButton("Exit", ButtonType.EXIT));

        pane.add(TopPanel.getTopPanel(), BorderLayout.NORTH);
        pane.add(getJSeparator(), BorderLayout.CENTER);
        pane.add(actionPanel, BorderLayout.SOUTH);
    }
}
