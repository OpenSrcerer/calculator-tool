package cs105Project;

import cs105Project.actions.Functions;
import cs105Project.userInterface.MainWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void main(String[] args) throws InterruptedException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(MainWindow::createAndShowGUI);
    }
}