/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.actions.exactCubes;

import cs105Project.actions.Functions;
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
    /**
     * Retrieve the instance of CandidateRoot to help with the calculations.
     */
    private final CandidateRoot candidate = CandidateRoot.getInstance();

    /**
     * Where to start looking for exact cubes.
     */
    private int highestBound;

    /**
     * Where to stop looking for exact cubes.
     */
    private int lowestBound;

    /**
     * Output area for the program's output.
     */
    private final JTextArea outputArea;

    /**
     * Button that starts the execution of this request.
     */
    private final JButton button;

    /**
     * Progress Bar that shows the progress of the calculation.
     */
    private final JProgressBar progressBar;


    /**
     * Create a new ExactCubesRequest request and put it in the
     * Request queue.
     * @param outputArea Output JTextArea to redirect output to.
     * @param bar ProgressBar to show calculation progress on.
     * @param button Button that starts the calculation.
     * @param lowestBound Where to start looking for exact cubes.
     * @param highestBound Where to stop looking for exact cubes.
     */
    public ExactCubesRequest(JTextArea outputArea, JProgressBar bar, JButton button, String lowestBound, String highestBound) {
        this.outputArea = outputArea;
        this.progressBar = bar;
        this.button = button;

        try {
            this.lowestBound = Integer.parseInt(lowestBound);
            this.highestBound = Integer.parseInt(highestBound);
            if (this.highestBound <= 0 || this.highestBound == Integer.MAX_VALUE || this.lowestBound <= 0 || this.lowestBound >= this.highestBound)
                throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            updateOutputArea(outputArea, "Please insert some proper input. \nIntegers from 1 to 2,147,483,646 would be good!", 1);
            return;
        }

        RequestManager.queueRequest(this);
    }

    @Override
    public void run() {
        toggleRunButton(button);
        final ArrayList<Integer> exactCubes = new ArrayList<>();
        final ArrayList<Integer> correspondingRoots = new ArrayList<>();
        final StringBuilder builder = new StringBuilder();

        double sum = 0;
        double mean;
        double variance;
        double stdDev;

        // Estimate for the progress bar
        double expectedCubes = Math.pow((highestBound - lowestBound), 1/3d);

        // search from number 1 to number 2
        for (int numberToTest = lowestBound; numberToTest <= highestBound; ++numberToTest) {
            // set the candidate in the CandidateRoot object
            // to the current number in the loop
            candidate.setCandidate(numberToTest);


            if (candidate.isExactRoot()) {
                exactCubes.add(numberToTest);
                updateProgressBar(progressBar, (int) ((exactCubes.size() / expectedCubes) * 100));
                correspondingRoots.add(candidate.getRoundedRoot());
                sum += numberToTest;
            }
        }

        // Calculate statistical measures
        mean = sum / exactCubes.size();
        variance = Functions.getVariance(exactCubes, mean);
        stdDev = Math.sqrt(variance);

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
            builder.append("Standard Deviation: ").append(stdDev).append("\n");
        }

        // Update output field
        updateOutputArea(outputArea, builder.toString(), index + 8);
        updateProgressBar(progressBar, 0);
        toggleRunButton(button);
    }
}
