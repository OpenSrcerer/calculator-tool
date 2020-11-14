package cs105Project.userInterface;

import cs105Project.actions.exactCubes.ExactCubesRequest;
import cs105Project.managers.RequestManager;
import cs105Project.userInterface.panels.ButtonType;
import cs105Project.userInterface.panels.ExactCubes;
import cs105Project.userInterface.panels.Selection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public final class PanelComponents {

    // Stylizing
    public static final Color
            discordLightGray = new Color(185, 187, 190),
            discordLessGray = new Color(71, 71, 71),
            discordGray = new Color(54, 57, 63),
            discordGrayer = new Color(47, 49, 54);

    // Fonts
    public static final Font titleFont = new Font("Century Gothic", Font.BOLD, 20);
    private static final Font actionFont = new Font("Arial", Font.BOLD, 15);
    private static final Font outputFont = new Font("Arial", Font.ITALIC, 13);

    public static JButton getButton(String buttonName, ButtonType type) {
        JButton button = new JButton();
        setButtonPalette(buttonName, button);
        setMouseListener(button);
        button.addActionListener(getListener(type));
        return button;
    }

    public static JButton getButton(String buttonName, ButtonType type, JTextArea outputField, JTextField inputField) {
        JButton button = new JButton();
        setButtonPalette(buttonName, button);
        setMouseListener(button);
        button.addActionListener(getListener(type, outputField, inputField));
        return button;
    }

    public static void setButtonPalette(String buttonName, JButton button) {
        button.setText("<html>" + buttonName + "</html>");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(discordGray);
        button.setForeground(discordLightGray);
        button.setFont(actionFont);
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

    public static JTextArea getJTextArea(int rows, int cols) {
        JTextArea area = new JTextArea(rows, cols);
        area.setFont(outputFont);
        area.setBackground(discordGrayer);
        area.setForeground(discordLightGray);
        return area;
    }

    public static JTextField getJTextField(String defaultText, int cols) {
        JTextField field = new JTextField(defaultText, cols);
        field.setFont(outputFont);
        field.setBackground(discordGrayer);
        field.setForeground(discordLightGray);
        return field;
    }

    public static JLabel getJLabel(String name) {
        JLabel label = new JLabel(name);
        label.setFont(titleFont);
        label.setForeground(discordLightGray);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    public static JPanel getBorderedButton(String buttonName, ButtonType type) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(getButton(buttonName, type));
        panel.setBorder(BorderFactory.createLineBorder(discordLessGray, 1));
        return panel;
    }

    public static void setBackgrounds(JPanel... panels) {
        for (JPanel panel : panels) {
            panel.setBackground(discordGrayer);
        }
    }

    private static ActionListener getListener(ButtonType type) {
        /*if (type == ButtonType.HELP) {

        } else if (type == ButtonType.CREDITS) {

        } else*/ if (type == ButtonType.EXACTCUBES) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                ExactCubes.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } /*else if (type == ButtonType.FACTORIAL) {

        } else if (type == ButtonType.RANDOMINTS) {

        } else if (type == ButtonType.GUESSING) {

        } else if (type == ButtonType.PALINDROME) {

        } else if (type == ButtonType.TRIPLES) {

        }*/ else if (type == ButtonType.BACK) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                Selection.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.EXIT) {
            return e -> {
                MainWindow.disposeJFrame();
                RequestManager.killExecutor();
            };
        }
        // shut up compiler
        // will never happen
        return null;
    }

    private static ActionListener getListener(ButtonType type, JTextArea outputField, JTextField inputField) {

        /*if (type == ButtonType.HELP) {

        } else if (type == ButtonType.CREDITS) {

        } else*/ if (type == ButtonType.EXACTCUBES) {
            return e -> new ExactCubesRequest(outputField, inputField.getText());
        } /*else if (type == ButtonType.FACTORIAL) {

        } else if (type == ButtonType.RANDOMINTS) {

        } else if (type == ButtonType.GUESSING) {

        } else if (type == ButtonType.PALINDROME) {

        } else if (type == ButtonType.TRIPLES) {

        }*/ else if (type == ButtonType.BACK) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                Selection.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.getWindowPane().repaint();
            };
        } else if (type == ButtonType.EXIT) {
            return e -> {
                MainWindow.disposeJFrame();
                RequestManager.killExecutor();
            };
        }
        // shut up compiler
        // will never happen
        return null;
    }

    public static void setMouseListener(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(discordLessGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(discordGray);
            }
        });
    }
}
