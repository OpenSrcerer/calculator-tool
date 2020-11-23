/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.actions;

import cs105Project.managers.RequestManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static cs105Project.actions.Functions.multiplyListBy;

/**
 * Menu option 6: Pythagorean triples. Look up "Pythagorean triples" in a mathematics book or
 * online. There exist exactly 16 primitive Pythagorean triples involving integers with a hypotenuse
 * value smaller or equal to 100. Write a program that scans all possible integer combinations,
 * discovers the primitive triples and displays them on screen. Triples which are duplicates (for
 * instance [3, 4, 5] and [4, 3, 5]) or multiples (for instance [9, 12, 15] which is 3×[3, 4, 5]) should
 * also be displayed but marked in brackets in your output list, since they are considered to be mere
 * variations of primitive triples which should have appeared in your list earlier.
 */
public class TriplesRequest implements Request {

    private static final ArrayList<List<Integer>> primitiveRatios = new ArrayList<>();

    private final JTextArea outputArea;
    private final JButton button;

    public TriplesRequest(JTextArea outputArea, JButton button) {
        this.outputArea = outputArea;
        this.button = button;

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);
        updateOutputArea(outputArea, " ", 1);

        primitiveRatios.clear();

        StringBuilder primitiveBuilder = new StringBuilder(), scaledBuilder = new StringBuilder();
        primitiveBuilder.append("------- Primitive Ratios -------\n");
        scaledBuilder.append("\n------- Scaled Ratios -------\n");

        int a, b, c;
        int m = 2;

        while (m < 100) {

            int n = 1;
            while (n < m) {

                a = (m * m) - (n * n);
                b = 2 * m * n;
                c = (m * m) + (n * n);

                if (c > 100)
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
                scaledBuilder.append("<").append(multiplyListBy(ratio, index)).append("> - Multiple of ").append(ratio).append(" by ").append(index).append(".").append("\n");
                ++index;
            }
        }

        for (List<Integer> ratio : primitiveRatios) {
            primitiveBuilder.append(ratio).append("\n");
        }

        updateOutputArea(outputArea, primitiveBuilder.toString() + scaledBuilder.toString(), 55);
        toggleRunButton(button);
    }

    private static boolean isRatioScaled(List<Integer> ratio) {
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
}
