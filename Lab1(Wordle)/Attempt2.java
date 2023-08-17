import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Attempt2 {

    private static JFrame frame;
    private static JPanel panel;

    private static JTextField guess1_1TF;
    private static JTextField guess1_2TF;
    private static JTextField guess1_3TF;
    private static JTextField guess1_4TF;
    private static JTextField guess1_5TF;

    private static JTextField guess2_1TF;
    private static JTextField guess2_2TF;
    private static JTextField guess2_3TF;
    private static JTextField guess2_4TF;
    private static JTextField guess2_5TF;

    private static JTextField guess3_1TF;
    private static JTextField guess3_2TF;
    private static JTextField guess3_3TF;
    private static JTextField guess3_4TF;
    private static JTextField guess3_5TF;

    private static JTextField guess4_1TF;
    private static JTextField guess4_2TF;
    private static JTextField guess4_3TF;
    private static JTextField guess4_4TF;
    private static JTextField guess4_5TF;

    private static JTextField guess5_1TF;
    private static JTextField guess5_2TF;
    private static JTextField guess5_3TF;
    private static JTextField guess5_4TF;
    private static JTextField guess5_5TF;

    private static JTextField guess6_1TF;
    private static JTextField guess6_2TF;
    private static JTextField guess6_3TF;
    private static JTextField guess6_4TF;
    private static JTextField guess6_5TF;

    public static void main(String[] args) {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(6, 5, 0, 10));

        Font font1 = new Font("Sans Serif", Font.BOLD, 30);
        frame.add(guess1_1TF = new JTextField("1"));
        guess1_1TF.setFont(font1);
        guess1_1TF.setHorizontalAlignment(JTextField.CENTER);
        frame.add(guess1_2TF = new JTextField("2"));
        frame.add(guess1_3TF = new JTextField("3"));
        frame.add(guess1_4TF = new JTextField("4"));
        frame.add(guess1_5TF = new JTextField("5"));

        frame.add(guess2_1TF = new JTextField("1"));
        frame.add(guess2_2TF = new JTextField("2"));
        frame.add(guess2_3TF = new JTextField("3"));
        frame.add(guess2_4TF = new JTextField("4"));
        frame.add(guess2_5TF = new JTextField("5"));

        frame.add(guess3_1TF = new JTextField("1"));
        frame.add(guess3_2TF = new JTextField("2"));
        frame.add(guess3_3TF = new JTextField("3"));
        frame.add(guess3_4TF = new JTextField("4"));
        frame.add(guess3_5TF = new JTextField("5"));

        frame.add(guess4_1TF = new JTextField("1"));
        frame.add(guess4_2TF = new JTextField("2"));
        frame.add(guess4_3TF = new JTextField("3"));
        frame.add(guess4_4TF = new JTextField("4"));
        frame.add(guess4_5TF = new JTextField("5"));

        frame.add(guess5_1TF = new JTextField("1"));
        frame.add(guess5_2TF = new JTextField("2"));
        frame.add(guess5_3TF = new JTextField("3"));
        frame.add(guess5_4TF = new JTextField("4"));
        frame.add(guess5_5TF = new JTextField("5"));

        frame.add(guess6_1TF = new JTextField("1"));
        frame.add(guess6_2TF = new JTextField("2"));
        frame.add(guess6_3TF = new JTextField("3"));
        frame.add(guess6_4TF = new JTextField("4"));
        frame.add(guess6_5TF = new JTextField("5"));

        panel = new JPanel();
        frame.add(panel);

        frame.setVisible(true);

    }

}
