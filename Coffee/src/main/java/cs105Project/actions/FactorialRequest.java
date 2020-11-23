package cs105Project.actions;

import cs105Project.managers.RequestManager;

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Menu option 2: Factorial of the average. Ask the user to input 5 positive integers between 0
 * and 15. Proceed to calculate and display the average of the 5 integers, as well as the factorial of
 * the integer in the group which is closest to the group's average. You may need to look up the
 * factorial formula in a mathematics book. You should build the code for the calculation of the
 * factorial rather than use a built-in Java function.
 */

public class FactorialRequest implements Request {

    private final int[] numbers = new int[5];

    private final JTextArea outputArea;
    private final JButton button;

    public FactorialRequest(JTextArea outputArea, JButton button, JTextField[] fields) {
        this.outputArea = outputArea;
        this.button = button;

        for (int index = 0; index < 5; ++index) {
            try {
                numbers[index] = Integer.parseInt(fields[index].getText());
                if (numbers[index] <= 0 || numbers[index] >= 15)
                    throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                updateOutputArea(outputArea, "How about you insert something that works?", 1);
                return;
            }
        }

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);

        double average = IntStream.of(numbers).sum() / 5d;
        int closest = getClosestToAverage(numbers, average);
        long factorial = getFactorial(closest);

        updateOutputArea(outputArea,
                outputArea.getText() + "----------------------------------------------------------------\n"
                        + "For the given numbers: "
                        + Arrays.toString(numbers) + ".\n"
                        + "Average: " + average + "\n"
                        + "Closest integer: " + closest + "\n"
                        + "Factorial of closest integer: " + factorial + "\n",
                outputArea.getRows() + 5
        );
        toggleRunButton(button);
    }

    private static int getClosestToAverage(int[] ints, double average) {
        int closest = 0;
        double delta = Double.MAX_VALUE;

        for (int i : ints) {
            if (Math.abs(average - i) < delta) {
                closest = i;
                delta = Math.abs(average - i);
            }
        }

        return closest;
    }

    public static long getFactorial(int integer) {
        long returnValue = integer;

        for (long index = integer - 1; index >= 1; --index) {
            returnValue = returnValue * index;
        }

        return returnValue;
    }
}
