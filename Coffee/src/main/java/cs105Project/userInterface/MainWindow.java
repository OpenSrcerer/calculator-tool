package cs105Project.userInterface;

import cs105Project.actions.Request;
import cs105Project.actions.RequestManager;
import cs105Project.actions.exactCubes.ExactCubesRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static MainWindow window;
    // Stylizing
    private static final Color
            discordGray = new Color(54, 57, 63),
            discordGrayer = new Color(47, 49, 54),
            discordLightGray = new Color(185, 187, 190);

    private static final Font actionFont = new Font("Arial", Font.BOLD, 15);

    // Layouts
    FlowLayout topLayout = new FlowLayout(FlowLayout.LEADING);
    GridLayout actionLayout = new GridLayout(3,3);

    enum ButtonType {
        // UTILITY BUTTONS
        HELP, CREDITS, EXIT,
        // ACTION BUTTONS
        EXACTCUBES, FACTORIAL, RANDOMINTS,
        GUESSING, PALINDROME, TRIPLES
    }

    public MainWindow() {
        super("Multitool");
        setResizable(false);
    }

    private void addComponentsToPane(final Container pane) {
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

    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
        // Create and set up the window.
        window = new MainWindow();
        window.setSize(500,500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the content pane.
        window.addComponentsToPane(window.getContentPane());
        // Pack the window so that the components
        // get their preferred size assigned.
        window.pack();
        // Display the window.
        window.setVisible(true);
    }

    private static JButton getButton(String buttonName, ButtonType type) {
        JButton button = new JButton();
        button.setText("<html>" + buttonName + "</html>");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(discordGray);
        button.setForeground(discordLightGray);
        button.setFont(actionFont);
        return button;
    }

    private static JSeparator getJSeparator() {
        JSeparator separator = new JSeparator();
        separator.setBackground(discordGrayer);
        separator.setForeground(discordLightGray);
        return separator;
    }

    private static JPanel getEmptyJPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(discordGrayer);
        return panel;
    }

    private static ActionListener getListener(ButtonType type) {

        Request request = null;

        if (type == ButtonType.HELP) {
            request = new ExactCubesRequest(500);
        } else if (type == ButtonType.CREDITS) {

        } else if (type == ButtonType.EXACTCUBES) {

        } else if (type == ButtonType.FACTORIAL) {

        } else if (type == ButtonType.RANDOMINTS) {

        } else if (type == ButtonType.GUESSING) {

        } else if (type == ButtonType.PALINDROME) {

        } else if (type == ButtonType.TRIPLES) {

        } else if (type == ButtonType.EXIT) {
            return e -> window.dispose();
        }

        Request finalRequest = request;
        return e -> {
            try {
                RequestManager.queueRequest(finalRequest);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        };
    }
}
