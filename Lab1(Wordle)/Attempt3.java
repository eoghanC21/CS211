import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.prefs.BackingStoreException;
import javax.swing.*;

public class Attempt3 implements ActionListener {

    // Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel display_button_panel = new JPanel();
    JPanel keyboard_panel = new JPanel();
    JLabel titletext = new JLabel();
    JButton[][] buttons = new JButton[5][6];
    JButton[][] keyboard = new JButton[8][3];

    public static void main(String args[]) {
        Attempt3 run = new Attempt3();
    }

    Attempt3() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        titletext.setBackground(new Color(25, 25, 25));
        titletext.setForeground(Color.WHITE);
        titletext.setFont(new Font("Neue Helvetica 75", Font.BOLD, 75));
        titletext.setHorizontalAlignment(JLabel.CENTER);
        titletext.setText("JAVA GUI Wordle");
        titletext.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        title_panel.add(titletext);
        frame.add(title_panel, BorderLayout.NORTH);

        display_button_panel.setLayout(new GridLayout(5, 6));
        display_button_panel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                buttons[i][j] = new JButton();
                display_button_panel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("Neue Helvetica 75", Font.BOLD, 120));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
            }
        }
        frame.add(display_button_panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

/*
 * // keyboard_panel.setLayout(new GridLayout(8, 3));
 * keyboard_panel.setBackground(Color.YELLOW);
 * for (int i = 0; i < 3; i++) {
 * for (int j = 0; j < 8; j++) {
 * buttons[i][j] = new JButton();
 * display_button_panel.add(buttons[i][j]);
 * buttons[i][j].setFont(new Font("Neue Helvetica 75", Font.BOLD, 40));
 * buttons[i][j].setFocusable(false);
 * buttons[i][j].addActionListener(this);
 * }
 * }
 * frame.add(keyboard_panel, BorderLayout.SOUTH);
 * }
 */