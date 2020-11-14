package cs105Project.actions.exactCubes;

import cs105Project.actions.Request;
import cs105Project.managers.RequestManager;

import javax.swing.*;
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
    private final CandidateRoot candidate = CandidateRoot.getInstance();
    private final ArrayList<Integer> exactCubes = new ArrayList<>();
    private final ArrayList<Integer> correspondingRoots = new ArrayList<>();
    private final StringBuilder builder = new StringBuilder();

    double sum = 0;
    double mean;
    double variance;
    double stdDev;

    // Nullable values
    int limit;
    private JTextArea outputField;

    public ExactCubesRequest(JTextArea outputField, String limit) {
        try {
            this.limit = Integer.parseInt(limit);
        } catch (NumberFormatException ex) {
            outputField.setText("Invalid input!");
            return;
        }
        this.outputField = outputField;

        try {
            RequestManager.queueRequest(this);
        } catch (InterruptedException interruptedException) {
            outputField.setText("Whoops, seems like you broke the program. \nPlease try again.");
        }
    }

    @Override
    public void run() {
        for (int numberToTest = 1; numberToTest < limit; ++numberToTest) {
            candidate.setCandidate(numberToTest);

            if (candidate.isExactRoot()) {
                exactCubes.add(numberToTest);
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

        for (int index = 0; index < exactCubes.size(); ++index) {
            builder.append(exactCubes.get(index)).append(" is the cube of ").append(correspondingRoots.get(index)).append(".\n");
        }
        builder.append("Number of cubes found: ").append(exactCubes.size()).append("\n");
        builder.append("Sum: ").append(sum).append("\n");
        builder.append("Mean: ").append(mean).append("\n");
        builder.append("Variance: ").append(variance).append("\n");
        builder.append("Population Standard Deviation: ").append(stdDev).append("\n");

        outputField.setText(builder.toString());
        outputField.setCaretPosition(outputField.getDocument().getLength() - 1);
    }
}
