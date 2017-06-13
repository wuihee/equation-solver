private void getNumbers() {
  numberPad = new ArrayList<JButton>();
  String[] pad = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "="};
  JButton button;
  Font buttonFont = new Font("Arial", Font.PLAIN, 25);

  for (String i : pad) {
    button = getButton(new JButton(i), buttonFont);
    numberPad.add(button);
  }
}

private void getOperators() {
  operatorPad = new ArrayList<JButton>();
  String[] pad = {"+", "-", "*", "/"};
  JButton button;
  Font buttonFont = new Font("Arial", Font.PLAIN, 25);

  for (String i : pad) {
    button = getButton(new JButton(i), buttonFont);
    operatorPad.add(button);
  }
}

private void addComponents() {
  contentPane = new JPanel(new GridBagLayout());
  GridBagConstraints bConstraints = new GridBagConstraints();
  GridBagConstraints oConstraints = new GridBagConstraints();

  // Add Numbers
  for (int i = 0; i < numberPad.size(); i++) {
    int row = i / 3;
    int column = i % 3;
    JButton button = numberPad.get(i);
    bConstraints.gridx = column;
    bConstraints.gridy = row;
    bConstraints.ipadx = 60;
    bConstraints.ipady = 60;
    bConstraints.insets = new Insets(5, 5, 5, 5); // External padding.
    contentPane.add(button, bConstraints);
  }

  // Add Operators
  for (int i = 0; i < operatorPad.size(); i++) {
    JButton button = operatorPad.get(i);
    oConstraints.gridx = 4;
    oConstraints.gridy = i;
    oConstraints.ipadx = 60;
    oConstraints.ipady = 60;
    oConstraints.insets = new Insets(5, 15, 5, 5);
    contentPane.add(button, oConstraints);
  }

  frame.setContentPane(contentPane);
}


public void actionPerformed(ActionEvent e) {
  // Equals Button
  if (e.getSource() == numberPad.get(11)) {
    System.out.println(equation);
  }
  else {
    // Numbers
    for (JButton b : numberPad) {
      if (e.getSource() == b) {
        equation += b.getText();
      }
    }
    // Operators
    for (JButton b : operatorPad) {
      if (e.getSource() == b) {
        equation += b.getText();
      }
    }
  }
}
