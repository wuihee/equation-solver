import javax.script.*;

public class Equation {
  private String equation = "";
  private String currentTerm = "";

  public Equation(String equation) {
    this.equation = equation;
  }

  public Equation() {
  }

  public void addToTerm(String number) {
    /* Add the given number to the current term. */
    if (number.equals(".")) {
      if (!currentTerm.contains(".")) {
        currentTerm += number;
      }
    }
    else {
      currentTerm += number;
    }
  }

  public void addTerm(String operation) {
    /* Given an operation, add the current term. */
    if (currentTerm.equals("")) {  // Adds minus sign at the beginning of the expression.
      if (operation.equals("-")) {
        equation += operation;  // Add minus sign even if operation is empty.
      }
    }
    else {
      // Converts String to double and back to String to ensure numbers are always doubles, which prevents error.
      currentTerm = Double.toString(Double.parseDouble(currentTerm));
      equation += currentTerm;
      equation += operation;
      currentTerm = "";  // Reset current term.
    }
  }

  public void delete() {
    /* Delete previous item in equation or current term. */
    if (!currentTerm.equals("")) {
      currentTerm = currentTerm.substring(0, currentTerm.length() - 1);
    }
    else if (currentTerm.equals("") && !equation.equals("")) {
      equation = equation.substring(0, equation.length() - 1);
    }
  }

  public void clear() {
    equation = "";
    currentTerm = "";
  }

  private static double evalString(String expression) throws ScriptException {
      ScriptEngineManager mgr = new ScriptEngineManager();
      ScriptEngine engine = mgr.getEngineByName("JavaScript");
      double ans = (double) engine.eval(expression);
      return ans;
  }

  public double evaluate() {
    /* Evaluate the value of the current equation/expression. */
    try {
      equation += currentTerm;  // Add current term.
      double ans = evalString(equation);
      clear();
      return ans;
    }
    catch (ScriptException e) {
      System.out.println(e);
      clear();
      return -1.0;
    }
  }

  public double[] getPoints(double start, double end) throws ScriptException {
    equation += currentTerm;  // Add current term.
    int len = (int) Math.abs(start - end) + 1;
    double[] xPoints = new double[len];
    double[] yPoints = new double[len];

    if (equation.contains("x")) {
      int count = 0;
      for (double i = start; i < end; i++) {
          String coefficient = Double.toString(i);
          String expression = equation.replace("x", coefficient);
          xPoints[count] = evalString(expression);
          yPoints[count] = i;
          count++;
      }
    }

    clear();
    return xPoints;
  }

  public String getTerm() {
    return currentTerm;
  }

  public String getEquation() {
    return equation;
  }

  public String toString() {
    return equation;
  }
}
