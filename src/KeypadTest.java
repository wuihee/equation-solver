import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class KeypadTest implements ActionListener {
  JFrame frame;
  JPanel contentPane;
  JButton button;
  ArrayList<JButton> buttons;

  KeypadTest() {
    frame = new JFrame("Keypad");
    frame.setVisible(true);
    frame.setSize(600, 600);
    frame.setLocationRelativeTo(null);  // Set location to center.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button = new JButton("Click Me!");
    button.addActionListener(this);
    addButtons();

    contentPane = new JPanel();  // Use default FlowLayout.
    contentPane.add(button);
    for (JButton b : buttons) {
      contentPane.add(b);
    }
    frame.setContentPane(contentPane);
  }

  public void addButtons() {
    buttons = new ArrayList<JButton>();

    for (int i = 0; i <= 3; i++) {
      buttons.add(new JButton(Integer.toString(i)));
      buttons.get(i).addActionListener(this);
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
      System.out.println("First Manual Button");
    }

    for (JButton b : buttons) {
      if (e.getSource() == b) {
        System.out.println(b.getText());
      }
    }
  }

  public static void main(String[] args) {
    new KeypadTest();
  }
}
