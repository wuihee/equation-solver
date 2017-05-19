import java.util.*;

public class EquationSolver {
    public static void main(String[] args) {
        ArrayList<String> equation = Equation.getEquation();
        if (equation.isEmpty()) {
            System.out.println("No Equation");
        } else {
            System.out.print("f(x) = ");
            for (String t : equation) {
                System.out.print(t);
            }
        }
    }
}
