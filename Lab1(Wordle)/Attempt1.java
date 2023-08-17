import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Attempt1 implements ActionListener {

    private static JLabel guess1Label;
    private static JTextField guess1Text;
    private static JLabel guess2Label;
    private static JTextField guess2Text;
    private static JLabel guess3Label;
    private static JTextField guess3Text;
    private static JLabel guess4Label;
    private static JTextField guess4Text;
    private static JLabel guess5Label;
    private static JTextField guess5Text;
    private static JLabel guess6Label;
    private static JTextField guess6Text;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        guess1Label = new JLabel("Guess 1");
        guess1Label.setBounds(10, 20, 80, 25);
        panel.add(guess1Label);

        guess1Text = new JTextField();
        guess1Text.setBounds(100, 20, 150, 25);
        panel.add(guess1Text);

        guess2Label = new JLabel("Guess 2");
        guess2Label.setBounds(10, 50, 80, 25);
        panel.add(guess2Label);

        guess2Text = new JTextField();
        guess2Text.setBounds(100, 50, 150, 25);
        panel.add(guess2Text);

        guess3Label = new JLabel("Guess 3");
        guess3Label.setBounds(10, 80, 80, 25);
        panel.add(guess3Label);

        guess3Text = new JTextField();
        guess3Text.setBounds(100, 80, 150, 25);
        panel.add(guess3Text);

        guess4Label = new JLabel("Guess 4");
        guess4Label.setBounds(10, 110, 80, 25);
        panel.add(guess4Label);

        guess4Text = new JTextField();
        guess4Text.setBounds(100, 110, 150, 25);
        panel.add(guess4Text);

        guess5Label = new JLabel("Guess 5");
        guess5Label.setBounds(10, 140, 80, 25);
        panel.add(guess5Label);

        guess5Text = new JTextField();
        guess5Text.setBounds(100, 140, 150, 25);
        panel.add(guess5Text);

        guess6Label = new JLabel("Guess 6");
        guess6Label.setBounds(10, 170, 80, 25);
        panel.add(guess6Label);

        guess6Text = new JTextField();
        guess6Text.setBounds(100, 170, 150, 25);
        panel.add(guess6Text);

        /*
         * passwordLabel = new JLabel("Password");
         * passwordLabel.setBounds(10, 50, 80, 25);
         * panel.add(passwordLabel);
         * 
         * passwordText = new JPasswordField();
         * passwordText.setBounds(100, 50, 165, 25);
         * panel.add(passwordText);
         */

        button = new JButton("Login");
        button.setBounds(10, 200, 80, 25);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        button.addActionListener(new Attempt1());
        panel.add(success);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = guess1Text.getText();
        String password = passwordText.getText();
        System.out.println(user + " " + password);

        if (user.equals("Eoghan") && password.equals("fluffyDinosaur123")) {
            success.setText("Login Successful!");
        }

    }
}