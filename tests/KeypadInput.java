import javax.script.*;

public class KeypadInput {
  public static Equation updateEquation(Equation equation, String buttonPressed) throws ScriptException {
    final String[] NUMBER_BUTTONS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "(", ")"};
    final String[] OPERATOR_BUTTONS = {"+", "-", "*", "/"};
    final String CLEAR = "AC";
    final String DELETE = "DEL";
    final String EQUAL = "=";

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
    if (buttonPressed.equals(DELETE)) {
      equation.delete();
    }
    if (buttonPressed.equals(EQUAL)) {
      equation.evaluate();
    }

    return equation;
    }
}
