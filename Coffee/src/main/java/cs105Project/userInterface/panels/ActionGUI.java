package cs105Project.userInterface.panels;

import cs105Project.userInterface.MainWindow;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public abstract class ActionGUI {

    private static final Container actionContentPane = MainWindow.getWindowPane();

    // Layouts
    private static final FlowLayout topLayout = new FlowLayout(FlowLayout.LEADING);
    private static final GridLayout actionLayout = new GridLayout(3,3);

    private static void setActionGuiComponents(final Container pane) {
        final JPanel topPanel = new JPanel();
        final JPanel actionPanel = new JPanel();
        topPanel.setLayout(topLayout);
        actionPanel.setLayout(actionLayout);

        topPanel.setBackground(discordGrayer);
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

        topPanel.add(getButton("Help", ButtonType.HELP));
        topPanel.add(getButton("Credits", ButtonType.CREDITS));

        actionPanel.add(getButton("Exact <br>Cubes", ButtonType.EXACTCUBES));
        actionPanel.add(getButton("Factorial of <br>the Average", ButtonType.FACTORIAL));
        actionPanel.add(getButton("Stats of Random <br>Integers", ButtonType.RANDOMINTS));
        actionPanel.add(getButton("Number <br>Guessing Game", ButtonType.GUESSING));
        actionPanel.add(getButton("Palindrome <br>Detection", ButtonType.PALINDROME));
        actionPanel.add(getButton("Pythagorean <br>Triples", ButtonType.TRIPLES));
        actionPanel.add(getEmptyJPanel());
        actionPanel.add(getButton("Exit", ButtonType.EXIT));

        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(getJSeparator(), BorderLayout.CENTER);
        pane.add(actionPanel, BorderLayout.SOUTH);
    }
}
