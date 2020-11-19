package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class RandomInts {

    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program
        final JPanel titleHolder = new JPanel();
        titleHolder.setLayout(new BoxLayout(titleHolder, BoxLayout.PAGE_AXIS));

        // Other JPanels and FlowLayouts
        final JPanel buttonLayout = new JPanel();
        final JPanel buttonHolder = new JPanel(new CardLayout());
        final JPanel interactionHolder = new JPanel(new BorderLayout());
        final JPanel scrollHolder = new JPanel(new GridLayout());

        setBackgrounds(buttonHolder, interactionHolder, scrollHolder, buttonLayout, titleHolder);

        JTextArea outputArea = PanelComponents.getTextArea(15,30);

        titleHolder.add(getLabel("Stats of Random Integers", titleFont));
        titleHolder.add(getLabel("Gets these stats for 6 random integers:", descriptionFont));
        titleHolder.add(getLabel("Sum, Product", descriptionFont));
        titleHolder.add(getLabel("Variance, Standard Deviation", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.RANDOMINTS, outputArea));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(buttonHolder, BorderLayout.SOUTH);

        // Create a scroll pane as holder for the output
        JScrollPane scroll = new JScrollPane(
                outputArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scroll.setBackground(discordGray);
        scrollHolder.add(scroll);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                interactionHolder, scrollHolder
        );
        splitPane.setEnabled(false);
        splitPane.setDividerSize(1);

        pane.add(
                splitPane,
                BorderLayout.CENTER
        );
    }
}
