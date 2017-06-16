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
    if (currentTerm.equals("")) {
      if (operation.equals("-")) {
        equation += operation;  // Add minus sign even if operation is empty.
      }
    }
    else {
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

  private static int evalString(String expression) throws ScriptException {
      ScriptEngineManager mgr = new ScriptEngineManager();
      ScriptEngine engine = mgr.getEngineByName("JavaScript");
      return (int) engine.eval(expression);
  }

  public double evaluate() throws ScriptException {
    equation += currentTerm;  // Add current term.
    double ans = evalString(equation);
    clear();
    return ans;
  }

  public void getPoints(int start, int end) throws ScriptException {
    System.out.println("Hello");
    if (!equation.contains("x")) {
      evaluate();
    }
    else {
      System.out.println("Test 2");
      int len = Math.abs(start - end) + 1;
      int[] xPoints = new int[len];
      int[] yPoints = new int[len];
      int count = 0;

      for (int i = start; i < end; i++) {
          String coefficient = "*" + i;
          String expression = equation.replace("x", coefficient);
          xPoints[count] = evalString(expression);
          yPoints[count] = i;
          count++;
      }

      System.out.println(xPoints);
      System.out.println(yPoints);
    }
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
