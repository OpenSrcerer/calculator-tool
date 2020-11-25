/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.actions.exactCubes;

/**
 * Singleton that makes our ExactCubes function's workflow
 * more clear and concise.
 */
public class CandidateRoot {
    /**
     * Singleton instance for CandidateRoot
     */

    private static final CandidateRoot instance = new CandidateRoot();
    /**
     * Precision of when we consider a root an integer.
     */

    private static final double ROOT_PRECISION = 1.0E-10;
    /**
     * Index of the nth root (in this case 3)
     */
    private static final double ROOT_INDEX = 3D;

    /**
     * Value where the precise, raw original root
     * from Math.pow() is stored.
     */
    double preciseRoot;
    /**
     * Root after it's been rounded.
     */
    int roundedRoot;


    private CandidateRoot() {
    }

    /**
     * @return Instance for this singleton object.
     */
    public static CandidateRoot getInstance() {
        return instance;
    }

    /**
     * Set function for the CandidateRoot instance.
     * Calculates the precise and rounded roots.
     * @param cube Cube of our root.
     */
    public void setCandidate(int cube) {
        // Find root from given cube.
        preciseRoot = Math.pow(cube, 1/ROOT_INDEX);
        // Round the root to the nearest integer
        roundedRoot = (int) Math.round(preciseRoot);
    }

    /**
     * A function to test the root. Considering that Math.pow()
     * returns values that can be very close to the integer value,
     * but not particularly so, this is a way to figure out whether
     * the root is the exact cube we're looking for.
     * @return If root is exact.
     */
    public boolean isExactRoot() {
        return Math.abs(preciseRoot - roundedRoot) < ROOT_PRECISION;
    }

    /**
     * @return Rounded (exact) root.
     */
    public int getRoundedRoot() {
        return roundedRoot;
    }
}
