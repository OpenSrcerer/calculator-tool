package cs105Project.userInterface;

import cs105Project.userInterface.panels.ButtonType;

import javax.swing.*;
import java.awt.*;

public abstract class PanelComponents {

    // Stylizing
    public static final Color
            discordGray = new Color(54, 57, 63),
            discordGrayer = new Color(47, 49, 54),
            discordLightGray = new Color(185, 187, 190);

    // Fonts
    public static final Font actionFont = new Font("Arial", Font.BOLD, 15);

    public static JButton getButton(String buttonName, ButtonType type) {
        JButton button = new JButton();
        button.setText("<html>" + buttonName + "</html>");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(discordGray);
        button.setForeground(discordLightGray);
        button.setFont(actionFont);
        button.addActionListener(getListener(type));
        return button;
    }

    public static JSeparator getJSeparator() {
        JSeparator separator = new JSeparator();
        separator.setBackground(discordGrayer);
        separator.setForeground(discordLightGray);
        return separator;
    }

    public static JPanel getEmptyJPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(discordGrayer);
        return panel;
    }
}
