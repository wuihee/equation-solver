//import java.util.*;
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

  public void evaluate() throws ScriptException {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    System.out.println(engine.eval(equation));
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
