package cs105Project.actions.randomInts;

import cs105Project.actions.Functions;
import cs105Project.actions.Request;
import cs105Project.managers.RequestManager;

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class RandomIntsRequest implements Request {
    // Output UI References & Variables
    private final JTextArea outputArea;
    private final JButton button;

    public RandomIntsRequest(JTextArea outputArea, JButton button) {
        this.outputArea = outputArea;
        this.button = button;

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);

        long[] randomValues = Functions.getRandomValues();
        long product = LongStream.of(randomValues).reduce(
                1, (num1, num2) -> num1 * num2
        );
        double sum = LongStream.of(randomValues).sum();
        double mean = sum / randomValues.length;
        double variance = Functions.getVariance(LongStream.of(randomValues).mapToObj(i -> (int) i).collect(Collectors.toList()), mean);
        double stdDev = Math.sqrt(variance);

        updateOutputArea(outputArea,
                outputArea.getText() + "----------------------------------------------------------------\n"
                        + "Your random numbers are: "
                        + Arrays.toString(randomValues) + ".\n"
                        + "Sum: " + sum + "\n"
                        + "Product: " + product + "\n"
                        + "Variance: " + variance + "\n"
                        + "Standard Deviation: " + stdDev + "\n",
                outputArea.getRows() + 6);
        toggleRunButton(button);
    }
}
