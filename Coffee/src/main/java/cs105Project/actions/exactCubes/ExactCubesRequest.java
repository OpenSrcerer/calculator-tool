package cs105Project.actions.exactCubes;

import cs105Project.actions.Request;
import cs105Project.managers.RequestManager;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Menu option 1: Exact cubes. Calculate and display the list of all integer numbers between the lowest bound
 * and the highest bound which are the exact cube of another integer. Your program should also calculate the sum,
 * average, statistical variance and standard deviation of all exact cubes it discovers within the
 * prescribed range. Example: integer 8 is the exact cube of integer 2, 27 is the cube of integer 3, 64
 * is the cube of 4, etc.
 */

public class ExactCubesRequest implements Request {
    private final CandidateRoot candidate = CandidateRoot.getInstance();

    // Nullable values
    private int highestBound;
    private int lowestBound;

    // Output UI References & Variables
    private JTextArea outputField;
    private JProgressBar progressBar;

    public ExactCubesRequest(JTextArea outputField, JProgressBar bar, String lowestBound, String highestBound) {
        try {
            this.lowestBound = Integer.parseInt(lowestBound);
            this.highestBound = Integer.parseInt(highestBound);
            if (this.highestBound <= 0 || this.highestBound == Integer.MAX_VALUE || this.lowestBound <= 0 || this.lowestBound >= this.highestBound)
                throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            outputField.setText("How about you insert something that works?");
            return;
        }

        this.outputField = outputField;
        this.progressBar = bar;

        try {
            RequestManager.queueRequest(this);
        } catch (InterruptedException interruptedException) {
            outputField.setText("Oops, seems like you broke the program. \nPlease try again.");
        }
    }

    @Override
    public void run() {
        final ArrayList<Integer> exactCubes = new ArrayList<>();
        final ArrayList<Integer> correspondingRoots = new ArrayList<>();
        final StringBuilder builder = new StringBuilder();

        double sum = 0;
        double mean;
        double variance;
        double stdDev;

        // Estimate for the progress bar
        double expectedCubes = (int) Math.pow((highestBound - lowestBound), 1/3d);

        for (int numberToTest = lowestBound; numberToTest <= highestBound; ++numberToTest) {
            candidate.setCandidate(numberToTest);

            if (candidate.isExactRoot()) {
                exactCubes.add(numberToTest);
                updateProgressBar(progressBar, (int) ((exactCubes.size() / expectedCubes) * 100));
                correspondingRoots.add(candidate.getRoundedRoot());
                sum = sum + numberToTest;
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

        int index = 0;
        if (sum == 0) {
            builder.append("----------- No cubes found in this range :( -----------").append("\n");
        } else {
            builder.append("----------- Cubes Found -----------").append("\n");
            for (index = 0; index < exactCubes.size(); ++index) {
                builder.append(exactCubes.get(index)).append(" is the cube of ").append(correspondingRoots.get(index)).append(".\n");
            }
            builder.append("\n----------- Statistics -----------").append("\n");
            builder.append("Number of cubes found: ").append(exactCubes.size()).append("\n");
            builder.append("Sum: ").append(sum).append("\n");
            builder.append("Mean: ").append(mean).append("\n");
            builder.append("Variance: ").append(variance).append("\n");
            builder.append("Population Standard Deviation: ").append(stdDev).append("\n");
        }

        // Update output field
        updateOutputArea(outputField, builder.toString(), index + 8);
        updateProgressBar(progressBar, 0);
    }
}
