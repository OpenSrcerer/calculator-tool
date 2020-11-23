/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.actions;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A class with functions created especially for this project's
 * calculations and arranged for easy access.
 */
public final class Functions {
    public static long[] getRandomValues() {
        Random random = new Random();
        long[] array = new long[6];

        for (int index = 0; index < 6; ++index) {
            array[index] = random.nextInt(101);
        }

        return array;
    }

    public static double getVariance(Collection<Integer> population, double mean) {
        double sqrDiff = 0;

        for (Integer integer : population) {
            sqrDiff = sqrDiff + Math.pow(integer - mean, 2);
        }

        return sqrDiff / population.size();
    }

    public static boolean isPalindrome(String s, int index) {
        if (index == (s.length() / 2))
            return true;

        if (s.charAt(index) != s.charAt(s.length() - index - 1))
            return false;

        return isPalindrome(s, index + 1);
    }

    public static List<Integer> multiplyListBy(List<Integer> list, int multiplier) {
        return list.stream().map(e -> e * multiplier).collect(Collectors.toList());
    }
}
