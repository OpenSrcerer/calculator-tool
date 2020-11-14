package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.discordGray;
import static cs105Project.userInterface.PanelComponents.setBackgrounds;

public final class ExactCubes {

    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        JPanel inputHolder = new JPanel(); // Using FlowLayout
        JPanel buttonLayout = new JPanel();
        JPanel buttonHolder = new JPanel(new CardLayout());
        JPanel interactionHolder = new JPanel(new BorderLayout());
        JPanel scrollHolder = new JPanel(new GridLayout());

        setBackgrounds(buttonHolder, interactionHolder, scrollHolder, inputHolder, buttonLayout);

        JTextArea outputField = PanelComponents.getJTextArea(15,30);
        JTextField inputField = PanelComponents.getJTextField("0", 10);
        JTextField inputField2 = PanelComponents.getJTextField("500", 10);
        outputField.setPreferredSize(new Dimension(200, 200));
        outputField.setEditable(false);

        // Add components to respective fields
        inputHolder.add(inputField);
        inputHolder.add(inputField2);
        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.EXACTCUBES, outputField, inputField));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);
        interactionHolder.add(inputHolder, BorderLayout.PAGE_START);
        interactionHolder.add(buttonHolder, BorderLayout.CENTER);

        // Create a scroll pane as holder for the output
        JScrollPane scroll = new JScrollPane(
                outputField,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scroll.setBackground(discordGray);
        scrollHolder.add(scroll);

        pane.add(
                new JSplitPane(
                        JSplitPane.VERTICAL_SPLIT,
                        interactionHolder, scrollHolder
                ),
                BorderLayout.CENTER
        );
    }
}
