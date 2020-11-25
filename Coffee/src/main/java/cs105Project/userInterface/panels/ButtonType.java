/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.userInterface.panels;

/**
 * This enum is used to distinguish button types,
 * when creating different button action listeners.
 * For example, a Help type button will show a help GUI, but
 * a Factorial button will initialize the factorial calculation GUI.
 *
 * Using an enum makes it easy to distinguish these buttons by assigning
 * a ButtonType value to them.
 */
public enum ButtonType {

    /**
     * Represents the "Help" button in the UI.
     */
    HELP,

    /**
     * Represents the "Credits" button in the UI.
     */
    CREDITS,

    /**
     * Represents the "Exit" button in the UI.
     */
    EXIT,

    /**
     * Represents the "Back" button in the UI.
     */
    BACK,

    /**
     * Represents the "ExactCubes" button in the UI.
     */
    EXACTCUBES,

    /**
     * Represents the "Factorial" button in the UI.
     */
    FACTORIAL,

    /**
     * Represents the "RandomInts" button in the UI.
     */
    RANDOMINTS,

    /**
     * Represents the "Guessing Game" button in the UI.
     */
    GUESSING,

    /**
     * Represents the "Palindrome Checker" button in the UI.
     */
    PALINDROME,

    /**
     * Represents the "Pythagorean Triples" button in the UI.
     */
    TRIPLES
}