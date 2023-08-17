import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordleDIY implements ActionListener {

    private static String readin;

    static String res;
    static String mysteryWord;
    JFrame frame = new JFrame();
    JPanel redpanel = new JPanel(); // title strip container
    JPanel bluepanel = new JPanel(); // display grid
    JPanel greenpanel = new JPanel(); // keyboard
    JPanel pinkpanel = new JPanel(); // winner panel
    JPanel blackpanel = new JPanel(); // losser panel
    JPanel cyanpanel = new JPanel(); // invalid msg
    JPanel cyanpanel2 = new JPanel(); // invalid msg
    JPanel bgpanel = new JPanel();
    JLabel label = new JLabel(); // title
    JLabel winLabel = new JLabel();
    JLabel losserLabel = new JLabel();
    JLabel invalidLabel = new JLabel();
    JButton xbtn = new JButton();
    JButton[][] keyboardButtons = new JButton[4][7];
    static JButton[][] displaybuttons = new JButton[6][5];
    JButton enter = new JButton();
    JButton delete = new JButton();
    static int row = 0;
    int col = 0;
    static String[] allwordsar = new String[12971];

    WordleDIY() {
        redpanel.setBackground(Color.BLACK);
        redpanel.setBounds(0, 0, 300, 50);
        redpanel.setLayout(new BorderLayout());
        redpanel.add(label);

        bluepanel.setBackground(Color.GRAY);
        bluepanel.setBounds(17, 54, 250, 333);
        bluepanel.setLayout(new GridLayout(6, 5, 1, 1));
        // bluepanel.add(freelabel);

        greenpanel.setBackground(Color.GRAY);
        greenpanel.setBounds(0, 392, 287, 200);
        greenpanel.setLayout(new GridLayout(4, 7, 1, 1));

        label.setText("CS211 WORDLE");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Neue Helvetica 75", Font.BOLD, 24));
        label.setForeground(Color.WHITE);

        winLabel.setText(mysteryWord + " is correct!");
        winLabel.setFont(new Font("Neue Helvetica 75", Font.BOLD, 16));
        winLabel.setForeground(Color.GREEN);
        winLabel.setVerticalAlignment(JLabel.CENTER);
        winLabel.setHorizontalAlignment(JLabel.CENTER);

        pinkpanel.setBackground(Color.BLACK);
        pinkpanel.setBounds(0, 392, 287, 200);
        pinkpanel.setLayout(new BorderLayout());
        pinkpanel.add(winLabel);

        losserLabel.setText("Better luck next time");
        losserLabel.setFont(new Font("Neue Helvetica 75", Font.BOLD, 13));
        losserLabel.setForeground(Color.RED);
        losserLabel.setVerticalAlignment(JLabel.CENTER);
        losserLabel.setHorizontalAlignment(JLabel.CENTER);

        invalidLabel.setText("Invalid Word");
        losserLabel.setFont(new Font("Neue Helvetica 75", Font.BOLD, 13));
        invalidLabel.setVerticalAlignment(JLabel.CENTER);
        invalidLabel.setHorizontalAlignment(JLabel.CENTER);
        invalidLabel.setForeground(Color.RED);

        blackpanel.setBackground(Color.BLACK);
        blackpanel.setBounds(0, 392, 287, 200);
        blackpanel.setLayout(new BorderLayout());
        blackpanel.add(losserLabel);

        cyanpanel.setBackground(Color.BLACK);
        cyanpanel.setBounds(63, 360, 160, 80);
        cyanpanel.setLayout(new BorderLayout());
        cyanpanel.add(xbtn);

        cyanpanel2.setBackground(Color.black);
        cyanpanel.setForeground(Color.RED);
        cyanpanel2.setBounds(63, 360, 110, 80);
        cyanpanel2.setLayout(new BorderLayout());
        cyanpanel2.add(invalidLabel);

        xbtn.setText("[x]");
        xbtn.setFont(new Font("Neue Helvetica 75", Font.BOLD, 18));
        xbtn.setVerticalAlignment(JLabel.TOP);
        xbtn.setHorizontalAlignment(JLabel.RIGHT);
        xbtn.setBackground(Color.BLACK);
        xbtn.setForeground(Color.RED);
        xbtn.addActionListener(this);
        xbtn.setRolloverEnabled(false);

        int L = 65;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                keyboardButtons[i][j] = new JButton();
                greenpanel.add(keyboardButtons[i][j]);
                keyboardButtons[i][j].setFont(new Font("Neue Helvetica 75", Font.BOLD, 16));
                keyboardButtons[i][j].setForeground(Color.WHITE);
                keyboardButtons[i][j].setBackground(Color.BLACK);
                keyboardButtons[i][j].setBorder(null);
                keyboardButtons[i][j].setText(String.valueOf((char) L));
                L++;
                keyboardButtons[i][j].setFocusable(false);
                keyboardButtons[i][j].setRolloverEnabled(false);
                keyboardButtons[i][j].addActionListener(this);
            }
        }
        keyboardButtons[3][5].setBorder(null);
        keyboardButtons[3][5].setFont(new Font("Neue Helvetica 75", Font.BOLD, 8));
        keyboardButtons[3][5].setForeground(Color.WHITE);
        keyboardButtons[3][5].setBackground(Color.BLACK);
        keyboardButtons[3][5].setText("DELETE");
        greenpanel.add(keyboardButtons[3][5]);

        keyboardButtons[3][6].setBorder(null);
        keyboardButtons[3][6].setFont(new Font("Neue Helvetica 75", Font.BOLD, 8));
        keyboardButtons[3][6].setForeground(Color.WHITE);
        keyboardButtons[3][5].setBackground(Color.BLACK);
        keyboardButtons[3][6].setText("ENTER");
        greenpanel.add(keyboardButtons[3][6]);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                displaybuttons[i][j] = new JButton();
                bluepanel.add(displaybuttons[i][j]);
                displaybuttons[i][j].setFont(new Font("Neue Helvetica 75", Font.BOLD, 16));
                displaybuttons[i][j].setForeground(Color.WHITE);
                displaybuttons[i][j].setBackground(Color.BLACK);
                displaybuttons[i][j].setBorder(null);
                displaybuttons[i][j].setRolloverEnabled(false);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(300, 629);
        frame.setForeground(Color.BLACK);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(169, 169, 169));
        frame.add(cyanpanel2);
        cyanpanel2.setVisible(false);
        frame.add(cyanpanel);
        cyanpanel.setVisible(false);
        frame.add(redpanel);
        frame.add(bluepanel);
        frame.add(greenpanel);
        frame.add(pinkpanel);
        frame.add(blackpanel);
        // frame.addKeyListener(this);
    }

    public static void main(String args[]) throws FileNotFoundException {
        File allwords = new File("allwords.txt");
        Scanner sc = new Scanner(allwords);
        readin = "";
        while (sc.hasNextLine()) {
            readin = readin.concat("," + sc.next());
        }
        sc.close();
        allwordsar = readin.split(",");
        Random r = new Random();
        int x = r.nextInt(2314);
        try {
            mysteryWord = (Files.readAllLines(Paths.get("wordleWords.txt")).get(x)).toUpperCase();
        } catch (IOException e) {
        }
        System.out.print(mysteryWord);
        WordleDIY run = new WordleDIY();
    }

    public void enterPressed() {
        String guessword = "";
        if (col == 5) {
            for (int i = 0; i < 5; i++) {
                guessword += displaybuttons[row][i].getText();
            }
            if (validcheck(guessword.toLowerCase())) {
                col = 0;
                check();
            } else {
                cyanpanel.setVisible(true);
                cyanpanel2.setVisible(true);
                for (int c = 0; c < 5; c++) {
                    displaybuttons[row][c].setText("");
                }
                col = 0;
            }
        }
    }

    public static boolean validcheck(String word) {
        for (int i = 0; i <= 12970; i++) {

            if (word.equals(allwordsar[i])) {
                return true;
            }

        }
        return false;
    }

    public void deletePressed() {
        col--;
        displaybuttons[row][col].setText("");
    }

    public void check() {
        res = "";
        int greenCount = 0;
        for (int i = 0; i < 5; i++) {
            if ((String.valueOf(displaybuttons[row][i].getText())).equals(String.valueOf(mysteryWord.charAt(i)))) {
                displaybuttons[row][i].setBackground(Color.GREEN);
                res += (String.valueOf(displaybuttons[row][i].getText()));
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
        greenpanel.setVisible(false);
        blackpanel.setVisible(false);
    }

    public void lose() {
        greenpanel.setVisible(false);
        pinkpanel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == keyboardButtons[3][6]) {
            enterPressed();
        } else if (e.getSource() == keyboardButtons[3][5]) {
            if (col != 0) {
                deletePressed();
            }
        } else if (e.getSource() == xbtn) {
            cyanpanel.setVisible(false);
            cyanpanel2.setVisible(false);
        } else if (e.getSource() != keyboardButtons[3][6]) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 7; j++) {
                    if (e.getSource() == keyboardButtons[i][j]) {
                        displaybuttons[row][col].setText(keyboardButtons[i][j].getText());
                        col++;
                    }
                }
            }
        }

    }
}
