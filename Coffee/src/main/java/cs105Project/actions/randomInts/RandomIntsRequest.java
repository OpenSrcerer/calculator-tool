package cs105Project.actions.randomInts;

import cs105Project.actions.Functions;
import cs105Project.actions.Request;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class RandomIntsRequest implements Request {

    @Override
    public void run() {
        long[] randomValues = Functions.getRandomValues();
        long product = LongStream.of(randomValues).reduce(
                1, (num1, num2) -> num1 * num2
        );
        double sum = LongStream.of(randomValues).sum();
        double mean = sum / randomValues.length;
        double variance = Functions.getVariance(LongStream.of(randomValues).mapToObj(i -> (int) i).collect(Collectors.toList()), mean);
        double stdDev = Math.sqrt(variance);

        // update standard dev
    }
}
