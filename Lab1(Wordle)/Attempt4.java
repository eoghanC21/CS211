import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.prefs.BackingStoreException;
import javax.swing.*;
import javax.swing.border.Border;

public class Attempt4 implements ActionListener {

    static String mysteryWord = "WRIST";
    JFrame frame = new JFrame();
    JPanel redpanel = new JPanel(); // title strip container
    JPanel bluepanel = new JPanel(); // display grid
    JPanel greenpanel = new JPanel(); // keyboard
    JPanel pinkpanel = new JPanel(); // winner panel
    JPanel blackpanel = new JPanel(); // losser panel
    JLabel label = new JLabel(); // title
    JLabel winLabel = new JLabel();
    JLabel losserLabel = new JLabel();
    JButton[][] keyboardButtons = new JButton[4][7];
    static JButton[][] displaybuttons = new JButton[6][5];
    JButton enter = new JButton();
    JButton delete = new JButton();
    static int row = 0;
    int col = 0;

    Attempt4() {
        redpanel.setBackground(Color.RED);
        redpanel.setBounds(0, 0, 300, 50);
        redpanel.setLayout(new BorderLayout());
        redpanel.add(label);

        bluepanel.setBackground(Color.BLUE);
        bluepanel.setBounds(17, 54, 250, 333);
        bluepanel.setLayout(new GridLayout(6, 5, 1, 1));
        // bluepanel.add(freelabel);

        greenpanel.setBackground(Color.GREEN);
        greenpanel.setBounds(0, 392, 287, 200);
        greenpanel.setLayout(new GridLayout(4, 7, 1, 1));

        label.setText("CS211 WORDLE");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        winLabel.setText(mysteryWord + " is correct!");
        winLabel.setFont(new Font("Neue Helvetica 75", Font.BOLD, 13));
        winLabel.setVerticalAlignment(JLabel.CENTER);
        winLabel.setHorizontalAlignment(JLabel.CENTER);

        pinkpanel.setBackground(Color.pink);
        pinkpanel.setBounds(17, 54, 250, 333);
        pinkpanel.setLayout(new BorderLayout());
        pinkpanel.add(winLabel);

        losserLabel.setText("Better luck next time");
        losserLabel.setFont(new Font("Neue Helvetica 75", Font.BOLD, 13));
        losserLabel.setForeground(Color.WHITE);
        losserLabel.setVerticalAlignment(JLabel.CENTER);
        losserLabel.setHorizontalAlignment(JLabel.CENTER);

        blackpanel.setBackground(Color.BLACK);
        blackpanel.setBounds(17, 54, 250, 333);
        blackpanel.setLayout(new BorderLayout());
        blackpanel.add(losserLabel);

        int L = 65;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                keyboardButtons[i][j] = new JButton();
                greenpanel.add(keyboardButtons[i][j]);
                keyboardButtons[i][j].setFont(new Font("Neue Helvetica 75", Font.BOLD, 16));
                keyboardButtons[i][j].setBorder(null);
                keyboardButtons[i][j].setText(String.valueOf((char) L));
                L++;
                keyboardButtons[i][j].setFocusable(false);
                keyboardButtons[i][j].addActionListener(this);
            }
        }
        keyboardButtons[3][5].setBorder(null);
        keyboardButtons[3][5].setFont(new Font("Neue Helvetica 75", Font.BOLD, 8));
        keyboardButtons[3][5].setText("DELETE");
        greenpanel.add(keyboardButtons[3][5]);

        keyboardButtons[3][6].setBorder(null);
        keyboardButtons[3][6].setFont(new Font("Neue Helvetica 75", Font.BOLD, 8));
        keyboardButtons[3][6].setText("ENTER");
        greenpanel.add(keyboardButtons[3][6]);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                displaybuttons[i][j] = new JButton();
                bluepanel.add(displaybuttons[i][j]);
                displaybuttons[i][j].setFont(new Font("Neue Helvetica 75", Font.BOLD, 16));
                displaybuttons[i][j].setBorder(null);
                displaybuttons[i][j].setFocusable(true);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(300, 700);
        frame.setVisible(true);
        frame.add(redpanel);
        frame.add(bluepanel);
        frame.add(greenpanel);
        frame.add(pinkpanel);
        frame.add(blackpanel);
    }

    public static void main(String args[]) {
        Attempt4 run = new Attempt4();

    }

    public void enterPressed() {
        if (col == 5) {
            col = 0;
            check();
        }
    }

    public void deletePressed() {
        col--;
        displaybuttons[row][col].setText("");
    }

    public void check() {

        int greenCount = 0;
        for (int i = 0; i < 5; i++) {
            if ((String.valueOf(displaybuttons[row][i].getText())).equals(String.valueOf(mysteryWord.charAt(i)))) {
                displaybuttons[row][i].setBackground(Color.GREEN);
                greenCount++;
            } else if (yellowCheck2(i) == true) {
                displaybuttons[row][i].setBackground(Color.YELLOW);
            } else {
                displaybuttons[row][i].setBackground(Color.GRAY);
            }
        }
        row++;
        if (greenCount == 5)
            win();
        else if (row == 6)
            lose();
    }

    public static boolean yellowCheck2(int pos) {
        boolean present = false;
        for (int i = 0; i < 5; i++) {
            if (mysteryWord.substring(i, i + 1).equals(displaybuttons[row][pos].getText())) {
                present = true;
                return present;
            }
        }
        return present;
    }

    public void win() {
        bluepanel.setVisible(false);
        blackpanel.setVisible(false);
    }

    public void lose() {
        bluepanel.setVisible(false);
        pinkpanel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == keyboardButtons[3][6]) {
            enterPressed();
        } else if (e.getSource() == keyboardButtons[3][5]) {
            deletePressed();
        } else if (e.getSource() != keyboardButtons[3][6]) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 7; j++) {
                    if (e.getSource() == keyboardButtons[i][j]) {
                        displaybuttons[row][col].setForeground(Color.BLACK);
                        displaybuttons[row][col].setText(keyboardButtons[i][j].getText());
                        col++;
                    }
                }
            }
        }

    }
}
