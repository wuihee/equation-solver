import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeypadTest implements ActionListener {
  JFrame frame;
  JPanel contentPane;
  JButton button;

  KeypadTest() {
    frame = new JFrame("Keypad");
    frame.setVisible(true);
    frame.setSize(600, 600);
    frame.setLocationRelativeTo(null);  // Set location to center.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button = new JButton("Click Me!");
    button.addActionListener(this);

    contentPane = new JPanel();  // Use default FlowLayout.
    contentPane.add(button);
    frame.setContentPane(contentPane);
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("Yay!");
  }

  public static void main(String[] args) {
    new KeypadTest();
  }
}
