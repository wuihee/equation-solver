import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class NumberPad implements ActionListener {
  private String equation = "";
  private JFrame frame;
  private JPanel contentPane;
  private JTextField screen;
  private ArrayList<JButton> basicButtons;
  private ArrayList<JButton> operatorButtons;
  private String[] basicNames = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "="};
  private String[] operatorNames = {"DEL", "AC", "*", "/", "+", "-", "(", ")"};
  private int numSections = 0;

  NumberPad() {
    getFrame();
    addComponents();
  }

  private void getFrame() {
    /* Initialize main frame, with its properties. */
    frame = new JFrame("Number Pad");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(1000, 1200);
  }

  private JButton getButton(JButton button, Font font) {
    /* Method returns a button with a font and added to ActionListener. */
    button.setFont(font);
    button.addActionListener(this);
    return button;
  }

  private ArrayList<JButton> getSection(String[] buttonNames) {
    /* Returns a 'section', an ArrayList of JButton objects. */
    ArrayList<JButton> section = new ArrayList<JButton>();
    Font buttonFont = new Font("Arial", Font.PLAIN, 25);
    JButton button;

    for (String name : buttonNames) {
       button = getButton(new JButton(name), buttonFont);
       section.add(button);
    }

    numSections++;
    return section;
  }

  private void addComponents() {
    /* Adds all components to the contents pane. */
    contentPane = new JPanel(new GridBagLayout());
    frame.setContentPane(contentPane);
    GridBagConstraints constraints = new GridBagConstraints();

    screen = new JTextField(20);
    basicButtons = getSection(basicNames);
    operatorButtons = getSection(operatorNames);

    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 3;
    constraints.gridheight = 3;
    contentPane.add(screen, constraints);
  }

  public void actionPerformed(ActionEvent e) {
  }
}
