public class Equation {
  private String equation = "";

  public Equation(String equation) {
    this.equation = equation;
  }

  public void addTerm(String term) {
    equation += term;
  }

  public String getEquation() {
    return equation;
  }

  public static void toString() {
    return equation;
  }
}
