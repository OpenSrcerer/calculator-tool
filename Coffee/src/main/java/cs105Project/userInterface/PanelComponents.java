package cs105Project.userInterface;

import cs105Project.RunProject;
import cs105Project.actions.exactCubes.ExactCubesRequest;
import cs105Project.actions.FactorialRequest;
import cs105Project.actions.GuessingRequest;
import cs105Project.actions.PalindromeRequest;
import cs105Project.actions.RandomIntsRequest;
import cs105Project.actions.TriplesRequest;
import cs105Project.managers.RequestManager;
import cs105Project.userInterface.panels.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

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
    public static JButton getButton(String buttonName, ButtonType type, Object... arg) {
        JButton button = new JButton();
        setButtonPalette(buttonName, button);
        setMouseListener(button);
        button.addActionListener(getListener(type, button, arg));
        return button;
    }

    /**
     * Changes a given button's theme to match the discord theme.
     * @param buttonName String to change the button name to.
     * @param button Button to change.
     */
    public static void setButtonPalette(String buttonName, JButton button) {
        button.setText("<html>" + buttonName + "</html>");
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(discordGray);
        button.setForeground(discordLightGray);
        button.setFont(actionFont);
    }

    /**
     * @return A discord-themed JSeperator.
     */
    public static JSeparator getSeparator() {
        JSeparator separator = new JSeparator();
        separator.setBackground(discordGrayer);
        separator.setForeground(discordLightGray);
        return separator;
    }

    public static JPanel getJPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(discordGrayer);
        return panel;
    }

    public static JPanel getJPanel(LayoutManager manager) {
        JPanel panel = new JPanel();
        panel.setLayout(manager);
        panel.setBackground(discordGrayer);
        return panel;
    }

    public static JPanel getJPanel(int layout) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, layout));
        panel.setBackground(discordGrayer);
        return panel;
    }

    public static JTextArea getTextArea(int rows, int cols) {
        JTextArea area = new JTextArea(rows, cols);
        area.setFont(outputFont);
        area.setBackground(discordGrayer);
        area.setForeground(discordLightGray);
        area.setPreferredSize(new Dimension(200, 200));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
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

    public static JCheckBox getCheckBox(String name, boolean isSelected) {
        JCheckBox box = new JCheckBox(name, isSelected);
        box.setBackground(discordGray);
        box.setFont(actionFont);
        box.setForeground(discordLightGray);
        return box;
    }

    public static Image getImage(String imgName) throws IOException, NullPointerException {
        BufferedImage image;

        InputStream imageStream = RunProject.class.getClassLoader().getResourceAsStream(imgName);
        if (imageStream == null)
            throw new NullPointerException();
        image = ImageIO.read(imageStream);

        return image;
    }

    public static JLabel getImageLabel(String imgName) {
        Image myPicture;
        try {
            myPicture = getImage(imgName);
        } catch (IOException | NullPointerException ex) {
            return getLabel("[Image]", descriptionFont);
        }

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBackground(discordGrayer);

        return picLabel;
    }

    /**
     * Takes in a number of JPanels and sets
     * their background to discordGrayer.
     *
     * @deprecated Due to the getJPanel method
     * setting a custom background color
     * background without the need of
     * this method.
     */
    @Deprecated
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
        if (type == ButtonType.HELP) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                Help.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.CREDITS) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                Credits.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.EXACTCUBES) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                ExactCubes.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.FACTORIAL) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                Factorial.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.RANDOMINTS) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                RandomInts.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.GUESSING) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                Guessing.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.PALINDROME) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                Palindrome.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.TRIPLES) {
            return e -> {
                MainWindow.getWindowPane().removeAll();
                MainWindow.getWindowPane().setCursor(Cursor.getDefaultCursor());
                Triples.setComponents(MainWindow.getWindowPane());
                MainWindow.packJFrame();
                MainWindow.repaintJFrame();
            };
        } else if (type == ButtonType.BACK) {
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

        // Will never happen
        return null;
    }

    private static ActionListener getListener(ButtonType type, JButton button, Object[] args) {

        if (type == ButtonType.EXACTCUBES) {
            return e -> new ExactCubesRequest((JTextArea) args[0], (JProgressBar) args[1], button, ((JTextField) args[2]).getText(), ((JTextField) args[3]).getText());
        } else if (type == ButtonType.FACTORIAL) {
            return e -> new FactorialRequest((JTextArea) args[0], button, (JTextField[]) args[1]);
        } else if (type == ButtonType.RANDOMINTS) {
            return e -> new RandomIntsRequest((JTextArea) args[0], button);
        } else if (type == ButtonType.GUESSING) {
            return e -> new GuessingRequest((JTextArea) args[0], button, ((JTextField) args[1]).getText());
        } else if (type == ButtonType.PALINDROME) {
            return e -> new PalindromeRequest((JTextArea) args[0], button, ((JTextField) args[1]).getText(), ((JCheckBox) args[2]).isSelected());
        } else if (type == ButtonType.TRIPLES) {
            return e -> new TriplesRequest((JTextArea) args[0], button);
        }

        // Will never happen
        return null;
    }
}
