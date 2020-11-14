package cs105Project.userInterface;

import cs105Project.userInterface.panels.ActionGUI;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static final MainWindow window = new MainWindow();

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
        window.setSize(500,500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the content pane.
        ActionGUI.setActionGuiComponents(window.getContentPane());
        // Pack the window so that the components
        // get their preferred size assigned.
        window.pack();
        // Display the window.
        window.setVisible(true);
    }

    public static Container getWindowPane() {
        return window.getContentPane();
    }

    public static void disposeJFrame() {
        window.dispose();
    }
}
