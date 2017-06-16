import java.util.*;

public class Eval {
  public static ArrayList<String> proccessString(String expression) {
    /* Methematically evaluates a given String. */
    final String[] NUMBERS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    final String[] OPERATORS = {"+", "-", "*", "/"};
    ArrayList<String> terms = new ArrayList<String>();
    String term = "";

    for (int i = 0; i < expression.length(); i++) {
      String idx = Character.toString(expression.charAt(i));

      if (Arrays.asList(NUMBERS).contains(idx)) {
        System.out.println(idx);
        term += idx;
      }

      else if (Arrays.asList(OPERATORS).contains(idx)) {
        terms.add(term);
        terms.add(idx);
        term = "";
      }
    }
    terms.add(term);  // Add remaining term.

    return terms;
  }

  public static double evalStrings(ArrayList<String> expression) {
    final String MULTIPLY = "*";
    final String DIVIDE = "/";
    double evaluation;

    for (int i = 0; i < expression.size(); i++) {
      String idx = expression.get(i);
      if (idx.equals(MULTIPLY)) {
        double prev_term = Integer.toString(expression.get(i - 1));
        double next_term = Integer.toString(expression.get(i + 1));
        evaluation = prev_term * next_term;
      }
    }

    return evaluation;
  }

  public static void main(String[] args) {
    ArrayList<String> processed = proccessString("12*12");
    System.out.println(evalStrings(processed));
  }
}
