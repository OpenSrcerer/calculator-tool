/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.userInterface;

import cs105Project.userInterface.panels.Selection;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The main and only JFrame that the GUI uses.
 */
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

    /**
     * @return The content pane for this JFrame.
     */
    public static Container getWindowPane() {
        return window.getContentPane();
    }

    /**
     * Packs JFrame so that every element fits to
     * its preferred size.
     */
    public static void packJFrame() {
        window.pack();
    }

    /**
     * Repaints JFrame for every component in it to reload.
     */
    public static void repaintJFrame() {
        window.repaint();
    }

    /**
     * Dispose of the window and exit the program.
     */
    public static void disposeJFrame() {
        window.dispose();
    }
}
