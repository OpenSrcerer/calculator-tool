package cs105Project.actions;

import java.util.Collection;
import java.util.Random;

/**
 * A class with functions created especially for this project
 * and arranged for easy access.
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
}
