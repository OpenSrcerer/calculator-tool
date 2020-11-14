package cs105Project.userInterface;

import cs105Project.actions.Request;
import cs105Project.actions.RequestManager;
import cs105Project.userInterface.panels.ButtonType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static MainWindow window = new MainWindow();

    private MainWindow() {
        super("Multitool");
        setResizable(false);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
        // Create and set up the window.
        window = getWindow();
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

    public static Container getWindowPane() {
        return window.getContentPane();
    }

    private static ActionListener getListener(ButtonType type) {

        Request request = null;

        /*if (type == ButtonType.HELP) {

        } else if (type == ButtonType.CREDITS) {

        } else*/ if (type == ButtonType.EXACTCUBES) {
            return e -> {
                window.getContentPane().removeAll();
                window.repaint();
            };
        } /*else if (type == ButtonType.FACTORIAL) {

        } else if (type == ButtonType.RANDOMINTS) {

        } else if (type == ButtonType.GUESSING) {

        } else if (type == ButtonType.PALINDROME) {

        } else if (type == ButtonType.TRIPLES) {

        }*/ else if (type == ButtonType.EXIT) {
            return e -> {
                window.dispose();
                RequestManager.killExecutor();
            };
        }
        // shut up compiler
        // will never happen
        return null;
    }
}
