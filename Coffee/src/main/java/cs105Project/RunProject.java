/*
 * <h3>Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 OpenSrcerer</h3>
 */

package cs105Project;

import cs105Project.userInterface.MainWindow;

import javax.swing.*;

/**
 * <h1>A Calculation Multitool</h1>
 *
 * <p>A Java program that fulfills specific requests as required in the Final Course Project Description PDF.<br></p>
 *
 * <h2>Available Calculations:</h2>
 * <ul>
 *     <li>Exact cubes</li>
 *     <li>Factorial of the average</li>
 *     <li>Stats of random integers</li>
 *     <li>Number guessing game</li>
 *     <li>Palindrome detection</li>
 *     <li>Pythagorean triples</li>
 * </ul>
 *
 * <br>
 * <h3>Made for the Final Project in CS105, due December 4th 2020. <br> This work is licensed under the GNU General Public License v3.0</h3>
 * <h5>Note: Special permission has been granted to me by
 * Dr. Alexander Astaras to bypass the project's requirements. <br>
 * Instead of using a text-based menu, I have programmed a GUI.</h5>
 *
 * @author Daniel Stefani (OpenSrcerer)
 * @version 0.0.1
 * @since 2020-11-12
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