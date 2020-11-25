/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.userInterface.panels;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.discordGrayer;
import static cs105Project.userInterface.PanelComponents.getButton;

/**
 * Convenience class for the top bar in the UI
 * with the Help and Credits buttons.
 */
public final class TopPanel {

    /**
     * Set top panel with its respective components
     * once and for all.
     */
    private static final JPanel topPanel = setTopPanel();

    /**
     * Set the top panel.
     * @return A JPanel with the top panel elements.
     */
    private static JPanel setTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(discordGrayer);
        panel.add(getButton("Help", ButtonType.HELP));
        panel.add(getButton("Credits", ButtonType.CREDITS));
        return panel;
    }

    /**
     * @return topPanel JPanel.
     */
    protected static JPanel getTopPanel() {
        return topPanel;
    }
}
