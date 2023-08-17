import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Attempt6 implements ActionListener {

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

    Attempt6() {
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
        frame.setBackground(Color.BLACK);
        frame.setForeground(Color.BLACK);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(cyanpanel2);
        cyanpanel2.setVisible(false);
        frame.add(cyanpanel);
        cyanpanel.setVisible(false);
        frame.add(redpanel);
        frame.add(bluepanel);
        frame.add(greenpanel);
        frame.add(pinkpanel);
        frame.add(blackpanel);
    }

    public static void main(String args[]) {
        Random r = new Random();
        int x = r.nextInt(2314);
        try {
            mysteryWord = (Files.readAllLines(Paths.get("wordleWords.txt")).get(x)).toUpperCase();
        } catch (IOException e) {
        }
        System.out.print(mysteryWord);
        Attempt6 run = new Attempt6();

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

        int from = 0;
        int to = 12000;

        if (word.substring(0, 1).equals("a")) {
            from = 0;
            to = 736;
        } else if (word.substring(0, 1).equals("b")) {
            from = 737;
            to = 1644;
        } else if (word.substring(0, 1).equals("c")) {
            from = 1645;
            to = 2566;
        } else if (word.substring(0, 1).equals("d")) {
            from = 2567;
            to = 3251;
        } else if (word.substring(0, 1).equals("e")) {
            from = 3252;
            to = 3554;
        } else if (word.substring(0, 1).equals("f")) {
            from = 3555;
            to = 4152;
        } else if (word.substring(0, 1).equals("g")) {
            from = 4153;
            to = 4790;
        } else if (word.substring(0, 1).equals("h")) {
            from = 4791;
            to = 5279;
        } else if (word.substring(0, 1).equals("i")) {
            from = 5280;
            to = 5444;
        } else if (word.substring(0, 1).equals("j")) {
            from = 5445;
            to = 5646;
        } else if (word.substring(0, 1).equals("k")) {
            from = 5646;
            to = 6022;
        } else if (word.substring(0, 1).equals("l")) {
            from = 6023;
            to = 6599;
        } else if (word.substring(0, 1).equals("m")) {
            from = 6600;
            to = 7292;
        } else if (word.substring(0, 1).equals("n")) {
            from = 7293;
            to = 7617;
        } else if (word.substring(0, 1).equals("o")) {
            from = 7618;
            to = 7879;
        } else if (word.substring(0, 1).equals("p")) {
            from = 7880;
            to = 8738;
        } else if (word.substring(0, 1).equals("q")) {
            from = 8739;
            to = 8816;
        } else if (word.substring(0, 1).equals("s")) {
            from = 8817;
            to = 11009;
        } else if (word.substring(0, 1).equals("t")) {
            from = 11010;
            to = 11824;
        } else if (word.substring(0, 1).equals("u")) {
            from = 11825;
            to = 12013;
        } else if (word.substring(0, 1).equals("v")) {
            from = 12014;
            to = 12255;
        } else if (word.substring(0, 1).equals("w")) {
            from = 12000;// 12556;
            to = 12668;// 12668;
        } else if (word.substring(0, 1).equals("x") || (word.substring(0, 1).equals("y"))
                || (word.substring(0, 1).equals("z"))) {
            from = 12669;
            to = 12970;
        }

        for (int i = from; i <= to; i++) {
            try {
                if (word.equals(Files.readAllLines(Paths.get("allwords.txt")).get(i))) {
                    System.out.println(i);
                    return true;
                }
            } catch (IOException e) {
            }
        }
        return false;
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
            deletePressed();
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
