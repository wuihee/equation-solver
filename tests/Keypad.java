import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Keypad implements ActionListener {
  Equation equation = new Equation();
  private JFrame frame;
  private JPanel contentPane;
  private JTextField keypadScreen;
  private ArrayList<JButton> keypadButtons;
  private String[] buttonNames = {
    "7", "8", "9", "DEL", "AC",
    "4", "5", "6", "*", "/",
    "1", "2", "3","+", "-",
    "0", ".", "(", ")", "="
  };
  private final String[] NUMBER_BUTTONS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
  private final String[] OPERATOR_BUTTONS = {"+", "-", "*", "/"};
  private final String CLEAR = "AC";
  private final String DELETE = "DEL";
  private final String EQUAL = "=";

  Keypad() {
    getFrame();
    addComponents();
  }

  private void getFrame() {
    /* Initialize main frame, with its properties. */
    frame = new JFrame("Keypad");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(1000, 1200);
  }

  private ArrayList<JButton> getButtonSection(String[] buttonNames) {
    /* Returns an ArrayList of JButton objects. */
    ArrayList<JButton> buttonSection = new ArrayList<JButton>();
    Font buttonFont = new Font("Arial", Font.PLAIN, 25);

    for (String name : buttonNames) {
       JButton button = new JButton(name);
       button.setFont(buttonFont);
       button.addActionListener(this);
       buttonSection.add(button);
    }
    return buttonSection;
  }

  private JPanel addButtonSection(JPanel contentPane, ArrayList<JButton> buttons, int numCols, int numRows, int gridx, int gridy) {
    GridBagConstraints constraints = new GridBagConstraints();
    for (int i = 0; i < buttons.size(); i++) {
      int col = i % numCols;  // To find current column (x value).
      int row = i / numCols;  // To find current row (y value).
      JButton b = buttons.get(i);
      constraints.gridx = col + gridx;
      constraints.gridy = row + gridy;
      constraints.fill = GridBagConstraints.BOTH;
      constraints.ipadx = 60;
      constraints.ipady = 60;
      // Create algorithm to evenly space all buttons.
      // constraints.insets = new Insets(5, 5, 5, 5);
      contentPane.add(b, constraints);
    }
    return contentPane;
  }

  private JPanel addKeypadScreen(JPanel contentPane, int width, int gridx, int gridy) {
    GridBagConstraints constraints = new GridBagConstraints();
    Font screenFont = new Font("Arial", Font.PLAIN, 30);
    keypadScreen = new JTextField(20);

    keypadScreen.setEditable(false);
    keypadScreen.setFont(screenFont);
    // keypadScreen.setText("y = ");
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    constraints.gridwidth = width;
    constraints.fill = GridBagConstraints.BOTH;
    constraints.ipadx = 150;
    constraints.ipady = 50;
    contentPane.add(keypadScreen, constraints);
    return contentPane;
  }

  private void addComponents() {
    /* Adds all components to the contents pane. */
    int numCols = 5;
    int numRows = 4;
    keypadButtons = getButtonSection(buttonNames);

    contentPane = new JPanel(new GridBagLayout());
    contentPane = addKeypadScreen(contentPane, numCols, 0, 0);
    contentPane = addButtonSection(contentPane, keypadButtons, numCols, numRows, 0, 1);

    frame.setContentPane(contentPane);
    frame.revalidate();  // Refreshes JFrame.
  }

  private void updateScreen() {
    String text = "";
    text += equation.getEquation() + equation.getTerm();
    keypadScreen.setText(text);
  }

  public void actionPerformed(ActionEvent e) {
    String buttonPressed = "";
    for (JButton b : keypadButtons) {
      if (e.getSource() == b) {
        buttonPressed = b.getText();  // Get the button pressed.
      }
    }
    // Add button pressed to current term in equation if button pressed is a number.
    for (String b : NUMBER_BUTTONS) {
      if (buttonPressed.equals(b)) {
        equation.addToTerm(buttonPressed);
      }
    }
    // Add term to equation if button pressed is an operator.
    for (String b : OPERATOR_BUTTONS) {
      if (buttonPressed.equals(b)) {
        equation.addTerm(buttonPressed);
      }
    }
    if (buttonPressed.equals(CLEAR)) {
      equation.clear();
    }

    updateScreen();
  }
}
