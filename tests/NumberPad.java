import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class NumberPad implements ActionListener {
  private String equation = "";
  private JFrame frame;
  private JPanel contentPane;
  private JTextField keypadScreen;
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
    addComponents();
  }

  private JButton getButton(JButton button, Font font) {
    /* Method returns a button with a font and added to ActionListener. */
    button.setFont(font);
    button.addActionListener(this);
    return button;
  }

  private ArrayList<JButton> getButtonSection(String[] buttonNames) {
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

  private JPanel addButtonSection(JPanel contentPane, ArrayList<JButton> buttons, int gridx, int gridy) {
    GridBagConstraints constraints = new GridBagConstraints();
    for (int i = 0; i < buttons.size(); i++) {
      int row = i / 3;
      int column = i % 3;
      JButton b = buttons.get(i);
      constraints.gridx = column + gridx;
      constraints.gridy = row + gridy;
      constraints.ipadx = 60;
      constraints.ipady = 60;
      constraints.insets = new Insets(5, 5, 5, 5);
      contentPane.add(b, constraints);
    }
    return contentPane;
  }

  private JPanel addKeypadScreen(JPanel contentPane, int gridx, int gridy) {
    GridBagConstraints constraints = new GridBagConstraints();
    keypadScreen = new JTextField(20);
    // keypadScreen.setEditable(false);
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    constraints.gridwidth = 3;  // TEMP
    constraints.ipadx = 150;
    constraints.ipady = 50;
    contentPane.add(keypadScreen, constraints);
    return contentPane;
  }

  private void addComponents() {
    /* Adds all components to the contents pane. */
    contentPane = new JPanel(new GridBagLayout());
    contentPane = addKeypadScreen(contentPane, 0, 0);
    contentPane = addButtonSection(contentPane, getButtonSection(basicNames), 0, 1);

    operatorButtons = getButtonSection(operatorNames);

    frame.setContentPane(contentPane);
    frame.revalidate();  // Refreshes JFrame.
  }

  public void actionPerformed(ActionEvent e) {
  }
}
