package cs105Project.userInterface.panels;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.discordGrayer;
import static cs105Project.userInterface.PanelComponents.getButton;

public final class TopPanel {

    private static final JPanel topPanel = setTopPanel();

    private static JPanel setTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(discordGrayer);
        panel.add(getButton("Help", ButtonType.HELP));
        panel.add(getButton("Credits", ButtonType.CREDITS));
        return panel;
    }

    protected static JPanel getTopPanel() {
        return topPanel;
    }
}
