package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.discordGray;
import static cs105Project.userInterface.PanelComponents.setBackgrounds;

public final class ExactCubes {

    public static void setComponents(final Container pane) {
        JPanel cards = new JPanel(new CardLayout());
        JPanel border = new JPanel(new BorderLayout());
        JPanel grid = new JPanel(new GridLayout());
        JPanel textFieldPane = new JPanel(); //use FlowLayout
        JPanel card1 = new JPanel();

        setBackgrounds(cards, border, grid, textFieldPane, card1);

        //Put the JComboBox in a JPanel to get a nicer look.
        JTextArea outputField = PanelComponents.getJTextArea(15,30);
        JTextField inputField = PanelComponents.getJTextField("500", 20);
        outputField.setPreferredSize(new Dimension(200, 200));
        outputField.setEditable(false);
        textFieldPane.add(inputField);

        //Create the "cards".
        card1.add(PanelComponents.getButton("Run", ButtonType.EXACTCUBES, outputField, inputField));
        card1.add(PanelComponents.getButton("Back", ButtonType.BACK));

        //Create the panel that contains the "cards".
        cards.add(card1);

        border.add(textFieldPane, BorderLayout.PAGE_START);
        border.add(cards, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(outputField);
        scroll.setBackground(discordGray);
        grid.add(scroll);

        pane.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                        border, grid), BorderLayout.CENTER);
    }
}
