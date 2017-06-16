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
    currentTerm += number;
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

  public void clear() {
    equation = "";
    currentTerm = "";
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
