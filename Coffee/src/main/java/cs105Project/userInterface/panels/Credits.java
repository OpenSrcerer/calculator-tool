/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.userInterface.panels;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public class Credits {

    public static void setComponents(final Container pane) {
        final JPanel infoPanel = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel imagePanel = getJPanel();
        final JPanel buttonPanel = getJPanel();
        final JPanel totalPanel = getJPanel();

        imagePanel.add(getImageLabel("bonk.png"));
        buttonPanel.add(getButton("Back", ButtonType.BACK));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(getLabel("Multitool v0.0.1", titleFont));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(getLabel("GNU © 2020 Daniel Stefani / OpenSrcerer", descriptionFont));
        infoPanel.add(getLabel("Made for my final CS105 Project", descriptionFont));
        infoPanel.add(getLabel("Thank you Bonkers & Marce", descriptionFont));
        infoPanel.add(buttonPanel);

        totalPanel.add(imagePanel);
        totalPanel.add(infoPanel);

        pane.add(totalPanel);
    }
}