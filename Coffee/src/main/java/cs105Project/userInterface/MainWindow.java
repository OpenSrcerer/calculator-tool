package cs105Project.userInterface;

import cs105Project.userInterface.panels.Selection;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public final class MainWindow extends JFrame {

    private static final MainWindow window = new MainWindow();

    private MainWindow() {
        super("The One and Only Multitool");

        try {
            setIconImage(PanelComponents.getImage("mtool.png"));
        } catch (IOException | NullPointerException ignored) {
            // If new icon cannot be found, fall back to default
        }

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
        Selection.setComponents(window.getContentPane());
        // Pack the window so that the components
        // get their preferred size assigned.
        window.pack();
        // Display the window.
        window.setVisible(true);
    }

    public static Container getWindowPane() {
        return window.getContentPane();
    }

    public static void packJFrame() {
        window.pack();
    }

    public static void repaintJFrame() {
        window.repaint();
    }

    public static void disposeJFrame() {
        window.dispose();
    }
}
