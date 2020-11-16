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

/**
 * This class is used to retrieve custom stylized JComponents
 * to match the ambiance and theme of the UI.
 */
public final class PanelComponents {

    // -------- Global Stylizing Elements --------
    public static final Color
            discordLightGray = new Color(185, 187, 190),
            discordLessGray = new Color(71, 71, 71),
            discordGray = new Color(54, 57, 63),
            discordGrayer = new Color(47, 49, 54);

    public static final Font titleFont = new Font("Century Gothic", Font.BOLD, 20);
    public static final Font descriptionFont = new Font("Century Gothic", Font.PLAIN, 14);
    private static final Font actionFont = new Font("Arial", Font.BOLD, 15);
    private static final Font outputFont = new Font("Arial", Font.ITALIC, 13);
    // -------------------------------------------


    /**
     * Retrieves a custom JButton.
     * @param buttonName Name and initial text of button.
     * @param type Type of button.
     * @return Customized JButton.
     */
    public static JButton getButton(String buttonName, ButtonType type) {
        JButton button = new JButton();
        setButtonPalette(buttonName, button);
        setMouseListener(button);
        button.addActionListener(getListener(type));
        return button;
    }

    /**
     * Retrieves a custom JButton.
     * @param buttonName Name and initial text of button.
     * @param type Type of button.
     * @return Customized JButton.
     */
    public static JButton getButton(String buttonName, ButtonType type, JTextArea outputField, JProgressBar bar, JTextField... fields) {
        JButton button = new JButton();
        setButtonPalette(buttonName, button);
        setMouseListener(button);
        button.addActionListener(getListener(outputField, type, bar, button, fields));
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

    public static JSeparator getSeparator() {
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

    public static JTextArea getTextArea(int rows, int cols) {
        JTextArea area = new JTextArea(rows, cols);
        area.setFont(outputFont);
        area.setBackground(discordGrayer);
        area.setForeground(discordLightGray);
        area.setPreferredSize(new Dimension(200, 200));
        area.setEditable(false);
        return area;
    }

    public static JTextField getTextField(String defaultText, int cols) {
        JTextField field = new JTextField(defaultText, cols);
        field.setFont(outputFont);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setBackground(discordGrayer);
        field.setForeground(discordLightGray);
        field.setCaretColor(discordLightGray);
        setMouseListener(field);
        return field;
    }

    public static JLabel getLabel(String name, Font font) {
        JLabel label = new JLabel(name);
        label.setFont(font);
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

    public static JProgressBar getProgressBar() {
        JProgressBar bar = new JProgressBar();
        bar.setPreferredSize(new Dimension(250, 25));
        bar.setMinimum(0);
        bar.setMaximum(100);
        bar.setOpaque(true);
        bar.setBorderPainted(false);
        bar.setBackground(discordGray);
        bar.setForeground(Color.RED);
        return bar;
    }

    public static void setBackgrounds(JPanel... panels) {
        for (JPanel panel : panels) {
            panel.setBackground(discordGrayer);
        }
    }

    public static void setMouseListener(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MainWindow.getWindowPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBackground(discordLessGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                button.setBackground(discordGray);
            }
        });
    }

    public static void setMouseListener(JTextField field) {
        field.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MainWindow.getWindowPane().setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    private static ActionListener getListener(ButtonType type) {
        /*if (type == ButtonType.HELP) {

        } else if (type == ButtonType.CREDITS) {

        } else*/ if (type == ButtonType.EXACTCUBES) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
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
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
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

    private static ActionListener getListener(JTextArea outputField, ButtonType type, JProgressBar bar, JButton button, JTextField... fields) {

        /*if (type == ButtonType.HELP) {

        } else if (type == ButtonType.CREDITS) {

        } else*/ if (type == ButtonType.EXACTCUBES) {
            return e -> new ExactCubesRequest(outputField, bar, button, fields[0].getText(), fields[1].getText());
        } /*else if (type == ButtonType.FACTORIAL) {

        } else if (type == ButtonType.RANDOMINTS) {

        } else if (type == ButtonType.GUESSING) {

        } else if (type == ButtonType.PALINDROME) {

        } else if (type == ButtonType.TRIPLES) {

        }*/
        // shut up compiler
        // will never happen
        return null;
    }
}
