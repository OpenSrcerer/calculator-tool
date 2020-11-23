/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.userInterface.panels;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class Help {

    public static void setComponents(final Container pane) {
        final JPanel infoPanel = getJPanel(BoxLayout.PAGE_AXIS);
        final JPanel buttonPanel = getJPanel();
        final JPanel totalPanel = getJPanel();

        buttonPanel.add(getButton("Back", ButtonType.BACK));

        infoPanel.add(getLabel("How to use MultiTool", titleFont));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(getLabel("This is a very simple GUI program. In the main", descriptionFont));
        infoPanel.add(getLabel("menu, you can click any of the buttons to", descriptionFont));
        infoPanel.add(getLabel("access the tool that you need.", descriptionFont));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(getLabel("Each tool has a short description and only a few", descriptionFont));
        infoPanel.add(getLabel("inputs, so reading them is all you need to get set up.", descriptionFont));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(getLabel("Click the button below to go back to the menu.", descriptionFont));
        infoPanel.add(buttonPanel);

        totalPanel.add(infoPanel);

        pane.add(totalPanel);
    }
}
