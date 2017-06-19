import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.script.*;
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
    "0", ".", "(", ")", "x",
    "=", "G"
  };

  private void getFrame() {
    /* Initialize main frame, with its properties. */
    frame = new JFrame("Graphing Calculator");
    frame.setLocationRelativeTo(null);  // Makes components appear in the middle of the frame.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(1000, 1200);
    frame.setResizable(true);  // Make the frame resizable (so that different users can use it).
  }

  private ArrayList<JButton> getButtonSection(String[] buttonNames) {
    /* Returns an ArrayList of JButton objects. */
    ArrayList<JButton> buttonSection = new ArrayList<JButton>();
    Font buttonFont = new Font("Arial", Font.PLAIN, 25);

    for (String name : buttonNames) {
      // Set the font, ActionListener and add each button.
       JButton button = new JButton(name);
       button.setFont(buttonFont);
       button.addActionListener(this);
       buttonSection.add(button);
    }
    return buttonSection;
  }

  private JPanel addButtonSection(JPanel contentPane, ArrayList<JButton> buttons, int numCols, int numRows, int gridx, int gridy) {
    /* Add a set of buttons in an ArrayList. */
    GridBagConstraints constraints = new GridBagConstraints();  // Set component constraints using this object.
    for (int i = 0; i < buttons.size(); i++) {
      int col = i % numCols;  // To find current column (x value).
      int row = i / numCols;  // To find current row (y value).
      JButton b = buttons.get(i);
      constraints.gridx = col + gridx;  // x and y position of the section.
      constraints.gridy = row + gridy;
      constraints.fill = GridBagConstraints.BOTH;  // Fill unfilled spaces.
      constraints.ipadx = 60;  // Size of the buttons.
      constraints.ipady = 60;
      // Create algorithm to evenly space all buttons.
      // Current way of spacing buttons is extremely inconsistent and repetitive.
      // constraints.insets = new Insets(5, 5, 5, 5);
      contentPane.add(b, constraints);
    }
    return contentPane;
  }

  private JPanel addKeypadScreen(JPanel contentPane, int width, int gridx, int gridy) {
    /* Creates and adds the screen of the keypad where button inputs show up. */
    GridBagConstraints constraints = new GridBagConstraints();  // Set component constraints using this object.
    Font screenFont = new Font("Arial", Font.PLAIN, 30);
    keypadScreen = new JTextField(20);

    keypadScreen.setEditable(false);  // Does not allow users to edit.
    keypadScreen.setFont(screenFont);
    keypadScreen.setText("y=");  // Because it is a graphing calculator, always start with "y=".
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    constraints.gridwidth = width;  // Stretch across the width of the buttons.
    constraints.fill = GridBagConstraints.BOTH;  // Fill unfilled spaces.
    constraints.ipadx = 150;  // Set padding.
    constraints.ipady = 50;
    contentPane.add(keypadScreen, constraints);
    return contentPane;
  }

  private void addComponents() {
    /* Adds all components to the contents pane. */
    int numCols = 5;  // Calculator is 5 x 4.
    int numRows = 4;
    keypadButtons = getButtonSection(buttonNames);

    contentPane = new JPanel(new GridBagLayout());
    contentPane = addKeypadScreen(contentPane, numCols, 0, 0);
    contentPane = addButtonSection(contentPane, keypadButtons, numCols, numRows, 0, 1);

    frame.setContentPane(contentPane);
    frame.revalidate();  // Refreshes JFrame.
  }

  private void updateScreen() {
    /* Updates equation on keypad screen with new terms and operations. */
    String text = "y=";  // Ensures that start is always "y=".
    text += equation.getEquation() + equation.getTerm();
    keypadScreen.setText(text);
  }

  public void createAndShowGUI() {
    getFrame();
    addComponents();
  }

  public void actionPerformed(ActionEvent event) {
    for (JButton b : keypadButtons) {
      if (event.getSource() == b) {
        try {
          equation = KeypadInput.updateEquation(equation, b.getText());  // Update Equation object using KeypadInput.
        }
        catch (ScriptException e) {
          System.out.println(e);
        }
      }
    }
    updateScreen();
  }
}
