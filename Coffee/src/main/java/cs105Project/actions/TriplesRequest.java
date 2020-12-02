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

    /**
     * ArrayList of Lists of Integers that contain
     * the found primitiveRatios.
     */
    private static final ArrayList<List<Integer>> primitiveRatios = new ArrayList<>();

    /**
     * Output area for the program's output.
     */
    private final JTextArea outputArea;

    /**
     * Button that starts the execution of this request.
     */
    private final JButton button;

    /**
     * Creates a new TripleRequest object and adds it to the
     * Request queue.
     * @param outputArea JTextArea to redirect output to.
     * @param button JButton that started the creation of this request.
     */
    public TriplesRequest(JTextArea outputArea, JButton button) {
        this.outputArea = outputArea;
        this.button = button;

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);
        updateOutputArea(outputArea, " ", 1);

        // primitiveRatios is static, clear
        // what's left over from the previous run
        primitiveRatios.clear();

        StringBuilder primitiveBuilder = new StringBuilder(), scaledBuilder = new StringBuilder();
        primitiveBuilder.append("------- Primitive Ratios -------\n");
        scaledBuilder.append("\n------- Scaled Ratios -------\n");

        // a, b = legs of the triangle
        // c = hypotenuse of the triangle
        int a, b, c;

        // q1 & q2 = placeholder integers
        // that iterate from 1-100 to create
        // triples using the early greek formula
        int q1 = 2;

        while (q1 < 100) {

            int q2 = 1;
            while (q2 < q1) {

                // Early greek formula for
                // calculating pythagorean triples
                a = (q1 * q1) - (q2 * q2);
                b = 2 * q1 * q2;
                c = (q1 * q1) + (q2 * q2);

                // Quit calculating if the
                // hypotenuse gets larger than 100
                if (c > 100)
                    break;

                // If the ratio conforms to the pythagorean
                // theorem
                if ((a * a) + (b * b) == (c * c)) {

                    // Create an immutable list of the ratio and sort it naturally
                    List<Integer> ratio = Arrays.asList(a, b, c);
                    ratio.sort(Comparator.naturalOrder());

                    // if ratio is not scaled, add it to the primitive
                    // ratios
                    if (!isRatioScaled(ratio)) {
                        primitiveRatios.add(ratio);
                    }
                }
                ++q2;
            }
            ++q1;
        }

        // calculate all scaled versions of the ratio
        // with a hypotenuse less than 100
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

    /**
     * Takes a ratio in and figures out whether this ratio
     * is the scaled version of another ratio by checking it
     * to the list of primitive ratios.
     * @param ratio Ratio parameter.
     * @return Whether the ratio parameter is scaled.
     */
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
