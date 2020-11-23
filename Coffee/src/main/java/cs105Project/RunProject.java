package cs105Project;

import cs105Project.userInterface.MainWindow;

import javax.swing.*;
import java.io.IOException;

/**
 * <h1>Java Program</h1>
 *
 * <p>A Java program demonstrate crap</p>
 *
 * <br>
 * <h3>Made for the Midterm Examination in CS105, November 9th 2020. <br> This work is licensed under the GNU General Public License v3.0</h3>
 *
 * @author Daniel Stefani (OpenSrcerer)
 * @version 0.0.1
 * @since 2020-10-12
 */

public class RunProject {

    private static boolean lookAndFeelSuccessful = false;

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        if (!lookAndFeelSuccessful)
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        if (!lookAndFeelSuccessful)
            throw new UnsupportedLookAndFeelException("Program is unable to start, provided look and feels are incompatible!");

        SwingUtilities.invokeLater(MainWindow::createAndShowGUI);
    }

    private static void setLookAndFeel(String lfClassName) {
        try {
            UIManager.setLookAndFeel(lfClassName);
            lookAndFeelSuccessful = true;
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException ex) {
            System.out.println("Look and feel is unsupported.");
        }
    }
}