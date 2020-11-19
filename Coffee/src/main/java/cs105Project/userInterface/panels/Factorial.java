package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class Factorial {

    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        final JPanel titleHolder = new JPanel();
        titleHolder.setLayout(new BoxLayout(titleHolder, BoxLayout.PAGE_AXIS));

        // Input Holders
        final JPanel inputHolder1 = new JPanel();
        inputHolder1.setLayout(new BoxLayout(inputHolder1, BoxLayout.PAGE_AXIS));
        final JPanel inputHolder2 = new JPanel();
        inputHolder2.setLayout(new BoxLayout(inputHolder2, BoxLayout.PAGE_AXIS));
        final JPanel inputHolder3 = new JPanel();
        inputHolder3.setLayout(new BoxLayout(inputHolder3, BoxLayout.PAGE_AXIS));
        final JPanel inputHolder4 = new JPanel();
        inputHolder4.setLayout(new BoxLayout(inputHolder4, BoxLayout.PAGE_AXIS));
        final JPanel inputHolder5 = new JPanel();
        inputHolder5.setLayout(new BoxLayout(inputHolder5, BoxLayout.PAGE_AXIS));
        final JPanel inputHolderAll = new JPanel();

        final JPanel buttonLayout = new JPanel();
        final JPanel buttonHolder = new JPanel(new CardLayout());
        final JPanel interactionHolder = new JPanel(new BorderLayout());
        final JPanel scrollHolder = new JPanel(new GridLayout());

        setBackgrounds(buttonHolder, interactionHolder, scrollHolder, buttonLayout, inputHolder1,
                inputHolder2, inputHolder3, inputHolder4, inputHolder5, inputHolderAll, titleHolder);

        JTextArea outputArea = PanelComponents.getTextArea(15,30);
        JTextField[] inputFields = {
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4),
                PanelComponents.getTextField("1", 4)
        };

        titleHolder.add(getLabel("Factorial of the Average", titleFont));
        titleHolder.add(getLabel("Given the five numbers below, this program", descriptionFont));
        titleHolder.add(getLabel("calculates their average and the factorial", descriptionFont));
        titleHolder.add(getLabel("of the number closest to the group's average.", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getSeparator());

        inputHolder1.add(getLabel("N1:", descriptionFont));
        inputHolder1.add(inputFields[0]);
        inputHolder2.add(getLabel("N2:", descriptionFont));
        inputHolder2.add(inputFields[1]);
        inputHolder3.add(getLabel("N3:", descriptionFont));
        inputHolder3.add(inputFields[2]);
        inputHolder4.add(getLabel("N4:", descriptionFont));
        inputHolder4.add(inputFields[3]);
        inputHolder5.add(getLabel("N5:", descriptionFont));
        inputHolder5.add(inputFields[4]);

        inputHolderAll.add(inputHolder1);
        inputHolderAll.add(inputHolder2);
        inputHolderAll.add(inputHolder3);
        inputHolderAll.add(inputHolder4);
        inputHolderAll.add(inputHolder5);

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.FACTORIAL, outputArea, inputFields));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(inputHolderAll, BorderLayout.CENTER);
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
