package cs105Project.actions.exactCubes;

import cs105Project.actions.Request;

import java.util.ArrayList;

/**
 * Menu option 1: Exact cubes. Calculate and display the list of all integer numbers between 0
 * and 500 which are the exact cube of another integer. Your program should also calculate the sum,
 * average, statistical variance and standard deviation of all exact cubes it discovers within the
 * prescribed range. Example: integer 8 is the exact cube of integer 2, 27 is the cube of integer 3, 64
 * is the cube of 4, etc. You may need to look up pseudorandom number generation functions and
 * the relevant mathematical formulae for the statistical metrics (choose the population formula to
 * calculate standard deviation, rather than the one for sample.)
 */

public class ExactCubesRequest implements Request {
    CandidateRoot candidate = CandidateRoot.getInstance();
    ArrayList<Integer> exactCubes = new ArrayList<>();
    // ArrayList<Integer> correspondingRoots = new ArrayList<>();

    double sum = 0;
    double mean;
    double variance;
    double stdDev;

    final int limit;

    public ExactCubesRequest(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int numberToTest = 1; numberToTest < limit; ++numberToTest) {
            candidate.setCandidate(numberToTest);

            if (candidate.isExactRoot()) {
                exactCubes.add(numberToTest);
                //correspondingRoots.add(candidate.getRoundedRoot());
                sum = sum + numberToTest;
                System.out.println((numberToTest + " is the cube of " + candidate.getRoundedRoot() + "."));
            }
        }

        {
            mean = sum / exactCubes.size();
            double sqrDiff = 0;

            for (Integer exactCube : exactCubes) {
                sqrDiff = sqrDiff + Math.pow(exactCube - mean, 2);
            }

            variance = sqrDiff / exactCubes.size();
            stdDev = Math.sqrt(variance);
        }

        /*for (int index = 0; index < exactCubes.size(); ++index) {
            System.out.println(exactCubes.get(index) + " is the cube of " + correspondingRoots.get(index) + ".");
        }*/
        System.out.println("Number of cubes found: " + exactCubes.size());
        System.out.println("Sum: " + sum);
        System.out.println("Mean: " + mean);
        System.out.println("Variance: " + variance);
        System.out.println("Population Standard Deviation: " + stdDev);
    }
}
