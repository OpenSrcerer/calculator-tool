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

    private static final ArrayList<List<Integer>> primitiveRatios = new ArrayList<>();
    private static final ArrayList<List<Integer>> scaledRatios = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        /*try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(MainWindow::createAndShowGUI);*/

        primitiveRatios.clear();
        scaledRatios.clear();

        int a, b, c;
        int m = 2;

        while (m < 100) {
            int n = 1;
            while (n < m) {

                a = (m * m) - (n * n);
                b = 2 * m * n;
                c = (m * m) + (n * n);

                if (c >= 100)
                    break;

                if ((a * a) + (b * b) == (c * c)) {
                    List<Integer> ratio = Arrays.asList(a, b, c);
                    ratio.sort(Comparator.naturalOrder());

                    if (!isRatioScaled(ratio)) {
                        primitiveRatios.add(ratio);
                    }
                }
                ++n;
            }
            ++m;
        }

        for (List<Integer> ratio : primitiveRatios) {
            int index = 2;
            while (ratio.get(2) * index <= 100) {
                scaledRatios.add(multiplyListBy(ratio, index));
                ++index;
            }
        }

        System.out.println("------ Primitive Ratios -------");
        for (List<Integer> ratio : primitiveRatios) {
            System.out.println(ratio);
        }

        System.out.println("------ Scaled Ratios -------");
        for (List<Integer> ratio : scaledRatios) {
            System.out.println("[" + ratio + "]");
        }
    }

    public static boolean isRatioScaled(List<Integer> ratio) {
        for (List<Integer> primitiveRatio : primitiveRatios) {
            double div1 = (double) ratio.get(0) / primitiveRatio.get(0);
            double div2 = (double) ratio.get(1) / primitiveRatio.get(1);
            double div3 = (double) ratio.get(2) / primitiveRatio.get(2);

            double diva = (div1 + div2 + div3) / 3;

            if (diva == div1) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> multiplyListBy(List<Integer> list, int multiplier) {
        return list.stream().map(e -> e * multiplier).collect(Collectors.toList());
    }
}