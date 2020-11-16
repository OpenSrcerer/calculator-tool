package cs105Project.actions.factorial;

import cs105Project.actions.Request;

import java.util.stream.IntStream;

public class FactorialRequest implements Request {


    @Override
    public void run() {
        int[] ints = {3, 4, 5, 6, 7};
        double average = IntStream.of(ints).sum() / 5d;
        int closest = getClosestToAverage(ints, average);
        long factorial = getFactorial(closest);
    }

    public static int getClosestToAverage(int[] ints, double average) {
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
